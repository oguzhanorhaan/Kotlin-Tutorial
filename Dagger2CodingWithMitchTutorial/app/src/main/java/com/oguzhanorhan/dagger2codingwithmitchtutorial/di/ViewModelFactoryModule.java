package com.oguzhanorhan.dagger2codingwithmitchtutorial.di;

import androidx.lifecycle.ViewModelProvider;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
