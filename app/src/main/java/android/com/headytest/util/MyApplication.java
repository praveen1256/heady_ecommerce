package android.com.headytest.util;

import android.app.Application;
import android.com.headytest.components.ApiComponent;
import android.com.headytest.components.DaggerApiComponent;
import android.com.headytest.modules.ApiModule;
import android.com.headytest.modules.AppModule;
import android.com.headytest.modules.DatabaseModule;

/**
 * Created by Praveen on 24-02-2018.
 */

public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("http://stark-spire-93433.herokuapp.com/"))
                .databaseModule(new DatabaseModule(this))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}
