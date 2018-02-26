package android.com.headytest.screens.mainscreen;

import android.com.headytest.realm.CategoryRm;
import android.com.headytest.realm.ProductRm;
import android.com.headytest.realm.RankingRm;
import android.com.headytest.realm.TaxRm;
import android.com.headytest.realm.VariantRm;
import android.com.headytest.screens.mainscreen.model.Category;
import android.com.headytest.screens.mainscreen.model.Product;
import android.com.headytest.screens.mainscreen.model.Product_;
import android.com.headytest.screens.mainscreen.model.Products;
import android.com.headytest.screens.mainscreen.model.Ranking;
import android.com.headytest.screens.mainscreen.model.Tax;
import android.com.headytest.screens.mainscreen.model.Variant;
import android.com.headytest.util.RestApi;
import android.widget.ImageView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Praveen on 25-02-2018.
 */

public class MainPresenter implements IMainPresenter {

    IMainView iMainView;
    RestApi service;
    Realm realm;

    public MainPresenter(RestApi service, Realm realm, IMainView iMainView) {
        this.service = service;
        this.iMainView = iMainView;
        this.realm = realm;
    }

    @Override
    public void getProducts() {
        Call<Products> call = service.getCategories();

        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                iMainView.onDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                iMainView.onDataFailed(t.getMessage());
            }
        });
    }

    @Override
    public void insertData(Products products) {
        List<Category> categoryList = products.getCategories();
        realm.beginTransaction();
        for (Category category : categoryList) {
            CategoryRm categoryRm = realm.createObject(CategoryRm.class);
            categoryRm.setId(category.getId());
            categoryRm.setName(category.getName());
            for (Product product : category.getProducts()) {
                ProductRm productRm = realm.createObject(ProductRm.class);
                productRm.setCatId(category.getId());
                productRm.setProductId(product.getId());
                productRm.setDate_added(product.getDateAdded());
                productRm.setProductName(product.getName());
                TaxRm taxRm = realm.createObject(TaxRm.class);
                taxRm.setCatId(category.getId());
                taxRm.setProductId(product.getId());
                taxRm.setTaxName(product.getTax().getName());
                taxRm.setTaxValue(product.getTax().getValue());
                for (Variant variant : product.getVariants()) {
                    VariantRm variantRm = realm.createObject(VariantRm.class);
                    variantRm.setCatId(category.getId());
                    variantRm.setProductId(product.getId());
                    variantRm.setProductName(product.getName());
                    variantRm.setVarientId(variant.getId());
                    variantRm.setVarientColor(variant.getColor());
                    variantRm.setVarientSize(variant.getSize());
                    variantRm.setVarientPrice(variant.getPrice());
                }
            }
        }
        realm.commitTransaction();

        realm.beginTransaction();
        List<Ranking> rankingList = products.getRankings();
        for (Ranking ranking : rankingList) {
            List<Product_> product_list = ranking.getProducts();
            for (Product_ product_ : product_list) {
                RankingRm rankingRm = realm.createObject(RankingRm.class);
                rankingRm.setProductId(product_.getId());
                rankingRm.setRankingText(ranking.getRanking());
                if (ranking.getRanking().equalsIgnoreCase("Most Viewed Products"))
                    rankingRm.setViewCount(product_.getViewCount());
                else if (ranking.getRanking().equalsIgnoreCase("Most OrdeRed Products"))
                    rankingRm.setViewCount(product_.getOrderCount());
                else if (ranking.getRanking().equalsIgnoreCase("Most ShaRed Products"))
                    rankingRm.setViewCount(product_.getShares());
            }
        }
        realm.commitTransaction();
        iMainView.onDataInsertedSuccess("Data Inserted");
    }

    @Override
    public void getRankingData(String sortText,int position) {
        RealmResults<RankingRm> rmRealmResults = realm.where(RankingRm.class).
                contains("rankingText", sortText).findAllSorted("viewCount", Sort.DESCENDING).
                distinct("viewCount");

        rmRealmResults.load();
        iMainView.onDataFetch(rmRealmResults,position);
    }

}
