package android.com.headytest.screens.mainscreen;

import android.com.headytest.R;
import android.com.headytest.realm.RankingRm;
import android.com.headytest.screens.mainscreen.model.Category;
import android.com.headytest.screens.mainscreen.model.Product;
import android.com.headytest.screens.mainscreen.model.Products;
import android.com.headytest.util.MyApplication;
import android.com.headytest.util.RestApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements IMainView {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private TextView tv_tv;
    private TextView tv_tv1;
    private TextView tv_tv2;
    IMainPresenter iMainPresenter;

    @Inject
    RestApi service;

    @Inject
    Realm realm;

    private RankingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getNetComponent().inject(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        tv_tv = (TextView)findViewById(R.id.tv_tv);
        tv_tv1 = (TextView)findViewById(R.id.tv_tv1);
        tv_tv2 = (TextView)findViewById(R.id.tv_tv2);
        iMainPresenter = new MainPresenter(service, realm, this);
        RealmResults<RankingRm> rmRealmResults = realm.where(RankingRm.class).findAll();
        rmRealmResults.load();
        if (rmRealmResults == null || rmRealmResults.size() == 0) {
            iMainPresenter.getProducts();
        } else {
            iMainPresenter.getRankingData("Most Viewed Products",0);
            iMainPresenter.getRankingData("Most OrdeRed Products",1);
            iMainPresenter.getRankingData("Most ShaRed Products",2);
        }

    }

    @Override
    public void onDataSuccess(Products products) {
        if (products != null && products.getCategories() != null && products.getCategories().size() > 0) {
            iMainPresenter.insertData(products);
        }
        Toast.makeText(MainActivity.this, "Size " + products.getCategories().size(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDataFailed(String message) {
        Toast.makeText(MainActivity.this, "On Failure", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDataInsertedSuccess(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        iMainPresenter.getRankingData("Most Viewed Products",0);
        iMainPresenter.getRankingData("Most OrdeRed Products",1);
        iMainPresenter.getRankingData("Most ShaRed Products",2);
    }

    @Override
    public void onDataInsertedFailed(String message) {

    }

    @Override
    public void onDataFetch(RealmResults<RankingRm> rmRealmResults,int position) {

        if(position==0){
            tv_tv.setText("Most Viewed Products");
            mAdapter = new RankingAdapter(rmRealmResults,position);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }else if(position==1){
            tv_tv1.setText("Most OrdeRed Products");
            mAdapter = new RankingAdapter(rmRealmResults,position);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView1.setLayoutManager(mLayoutManager);
            recyclerView1.setItemAnimator(new DefaultItemAnimator());
            recyclerView1.setAdapter(mAdapter);
        }else if(position==2){
            tv_tv2.setText("Most ShaRed Products");
            mAdapter = new RankingAdapter(rmRealmResults,position);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView2.setLayoutManager(mLayoutManager);
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
            recyclerView2.setAdapter(mAdapter);
        }

    }

}
