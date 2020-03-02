package com.oguzhanorhan.dagger2example;

import javax.inject.Inject;

public class Wheel {

    Rims rims;
    Tires tires;

    public Wheel(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
