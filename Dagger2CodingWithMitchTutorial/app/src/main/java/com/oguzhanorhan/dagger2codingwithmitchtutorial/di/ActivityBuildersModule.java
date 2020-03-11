package com.oguzhanorhan.dagger2codingwithmitchtutorial.di;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();
}
