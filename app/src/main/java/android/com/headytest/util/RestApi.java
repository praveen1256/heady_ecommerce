package android.com.headytest.util;

import android.com.headytest.screens.mainscreen.model.Category;
import android.com.headytest.screens.mainscreen.model.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RestApi {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("json")
    Call<Products> getCategories();


}

