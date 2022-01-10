package com.eangieans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Named;

@Named
@Default // for use priority for use in DI
@ApplicationScoped
public class WarpEngine implements Engine {

    @Override
    public void runEngine() {
        System.out.println("method warp engine is running");
    }

}
