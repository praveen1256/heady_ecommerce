package android.com.headytest.screens.mainscreen;


import android.com.headytest.realm.RankingRm;
import android.com.headytest.screens.mainscreen.model.Products;

import io.realm.RealmResults;

public interface IMainView {

    void onDataSuccess(Products products);

    void onDataFailed(String message);

    void onDataInsertedSuccess(String message);

    void onDataInsertedFailed(String message);

    void onDataFetch(RealmResults<RankingRm> rmRealmResults,int position);

}
