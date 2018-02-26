package android.com.headytest.modules;

import android.app.Application;
import android.com.headytest.util.MyApplication;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Praveen on 25-02-2018.
 */

@Module
public class DatabaseModule {
    private Context mApplication;

    public DatabaseModule(Context context) {
        this.mApplication=context;
    }

    @Provides
    Realm provideRealm() {
        Realm.init(mApplication);
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name("headytest.realm");
        RealmConfiguration config = builder.build();
        return Realm.getInstance(config);
    }

}
