package com.oguzhanorhan.dagger2example;

import dagger.Binds;
import dagger.Module;

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract Engine provideEngine(PetrolEngine engine);
}
