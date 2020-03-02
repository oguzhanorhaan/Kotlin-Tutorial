package com.oguzhanorhan.dagger2example;

import android.util.Log;

import javax.inject.Inject;

import static com.oguzhanorhan.dagger2example.MainActivity.TAG;

public class DieselEngine implements Engine {
    private int horsePower=0;

  //  @Inject
    public DieselEngine() {}

    @Inject
    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: DieselEngine, horsePower:  "+horsePower);
    }
}
