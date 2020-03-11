package com.oguzhanorhan.dagger2codingwithmitchtutorial;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
