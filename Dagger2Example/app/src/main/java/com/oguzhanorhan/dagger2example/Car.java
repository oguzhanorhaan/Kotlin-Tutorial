package com.oguzhanorhan.dagger2example;

import android.util.Log;

import javax.inject.Inject;

@PerActivity
public class Car {

    private Driver driver;
    private Engine engine;
    private Wheel wheel;

    @Inject //CONSTRUCTOR INJECTION
    public Car(Driver driver, Engine engine, Wheel wheel) {
        this.engine = engine;
        this.wheel = wheel;
        this.driver = driver;
    }

    public void drive() {
        engine.start();
        Log.d(MainActivity.TAG,driver+" driving "+this);
    }

    @Inject //executed automatically after the constructor is created, METHOD INJECTION
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
}
