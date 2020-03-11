package com.oguzhanorhan.dagger2codingwithmitchtutorial.di;

import android.app.Application;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application); //we can use the application in the app module because of bindsInstance

        AppComponent build();
    }
}
