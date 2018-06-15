package edu.purdue.mehta109.trialanderror;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
