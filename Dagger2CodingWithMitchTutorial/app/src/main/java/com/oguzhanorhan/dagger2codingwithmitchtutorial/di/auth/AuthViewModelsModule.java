package com.oguzhanorhan.dagger2codingwithmitchtutorial.di.auth;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.di.ViewModelKey;
import com.oguzhanorhan.dagger2codingwithmitchtutorial.ui.auth.AuthViewModel;
import com.oguzhanorhan.dagger2codingwithmitchtutorial.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}
