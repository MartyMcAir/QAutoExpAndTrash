package com.cars;

import com.eangieans.Engine;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class JustCar implements Car {
    @Inject
    @Named("e_Engine")
    private Engine eEngine;

    public void engineOn() {
        System.out.println("engine is turn ON");
    }

    public void runMethodFromEngine() {
        eEngine.runEngine();
    }

}