package com.oguzhanorhan.dagger2example;

import android.os.Build;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;


@PerActivity
/*
 * To use the driver object of the AppComponent, we defined it as a dependency
 *
@Component(dependencies = AppComponent.class ,modules = {WheelModule.class, PetrolEngineModule.class})
*/
@Subcomponent(modules = {WheelModule.class, PetrolEngineModule.class})
public interface ActivityComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);


        ActivityComponent build();
    }
}
