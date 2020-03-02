package com.oguzhanorhan.dagger2example;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WheelModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        return new Tires();
    }

    @Provides
    static Wheel providesWheel(Rims rims, Tires tires) {
        return new Wheel(rims, tires);
    }
}
