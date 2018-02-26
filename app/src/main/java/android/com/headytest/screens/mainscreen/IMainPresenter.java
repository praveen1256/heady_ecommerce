package android.com.headytest.screens.mainscreen;


import android.com.headytest.screens.mainscreen.model.Products;

public interface IMainPresenter {

    void getProducts();

    void insertData(Products products);

    void getRankingData(String sortText,int position);


}
