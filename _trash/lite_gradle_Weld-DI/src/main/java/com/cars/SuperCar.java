package com.cars;

import com.eangieans.Engine;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class SuperCar implements Car {
    //    @Named("warpEngine")
    @Inject
    @Named("e_Engine")
    private Engine eEngine;

    public void engineOn() {
        System.out.println("engine is turn ON Super Car!");
    }

    public void runMethodFromEngine() {
        eEngine.runEngine();
    }

}