package com.oguzhanorhan.dagger2example;

import android.util.Log;

import javax.inject.Inject;

import static com.oguzhanorhan.dagger2example.MainActivity.TAG;

public class Remote {

    @Inject
    public Remote() { }

    void setListener(Car car) {
        Log.d(TAG,"Remote connected");
    }
}
