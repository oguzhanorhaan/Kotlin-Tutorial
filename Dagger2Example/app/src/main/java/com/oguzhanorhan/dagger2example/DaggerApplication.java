package com.oguzhanorhan.dagger2example;

import android.app.Application;

public class DaggerApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.create();

    }

    public AppComponent getAppComponent() {
        return component;
    }
}
