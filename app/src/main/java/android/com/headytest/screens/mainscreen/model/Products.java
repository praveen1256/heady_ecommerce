package android.com.headytest.screens.mainscreen.model;

/**
 * Created by Praveen on 24-02-2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("rankings")
    @Expose
    private List<Ranking> rankings = null;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

}
