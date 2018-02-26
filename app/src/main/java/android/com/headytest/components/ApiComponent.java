package android.com.headytest.components;

import android.com.headytest.modules.ApiModule;
import android.com.headytest.modules.AppModule;
import android.com.headytest.modules.DatabaseModule;
import android.com.headytest.screens.mainscreen.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Praveen on 24-02-2018.
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class, DatabaseModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
