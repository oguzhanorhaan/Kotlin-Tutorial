package com.oguzhanorhan.dagger2example;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

   // Driver getDriver();

    ActivityComponent.Builder getActivityyComponentBuilder();
}
