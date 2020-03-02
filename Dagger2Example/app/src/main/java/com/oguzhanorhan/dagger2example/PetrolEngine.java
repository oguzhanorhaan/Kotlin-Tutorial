package com.oguzhanorhan.dagger2example;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import static com.oguzhanorhan.dagger2example.MainActivity.TAG;

public class PetrolEngine implements Engine {
    private int horsePower = 0;
    private int engineCapacity = 0;

    @Inject
    public PetrolEngine(@Named("horse power") int horsePower, @Named("engine capacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: Petrol Engine, horse power = "+horsePower+" engine capacity "+engineCapacity);
    }
}
