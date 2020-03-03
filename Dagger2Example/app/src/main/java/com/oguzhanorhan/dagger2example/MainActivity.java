package com.oguzhanorhan.dagger2example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Car";

    @Inject Car car1, car2; //Can not be null, FIELD INJECTION


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //car = DaggerCarComponent.create().getCar();
        //DaggerCarComponent.create().inject(this); // field injection

      /*  ActivityComponent component = DaggerCarComponent.builder()
                .dieselEngineModule(new DieselEngineModule(100)) //horse power value set at runtime
                .build(); */
     /* ActivityComponent component = DaggerCarComponent.builder()
              .horsePower(150)
              .engineCapacity(1400)
              .build();

        */

       // ActivityComponent component = ((DaggerApplication) getApplication()).getCarComponent();

        ActivityComponent component = DaggerActivityComponent.builder() // Activity component creates local singletons
                .horsePower(120)
                .engineCapacity(1600)
                .appComponent(((DaggerApplication) getApplication()).getAppComponent()) // App component creates app singletons
                .build();

        component.inject(this);

        //Every component has its own scope and singleton objects created inside these scopes
        car1.drive();
        car2.drive();
    }
}
