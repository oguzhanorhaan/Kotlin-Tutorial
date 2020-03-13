package com.oguzhanorhan.dagger2codingwithmitchtutorial.di;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.di.auth.AuthModule;
import com.oguzhanorhan.dagger2codingwithmitchtutorial.di.auth.AuthViewModelsModule;
import com.oguzhanorhan.dagger2codingwithmitchtutorial.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();
}
