package com.eangieans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

//@Alternative // skip Ambiguous dependencies for container_ use it like Alternative if nothing else..
@Named
@ApplicationScoped
public class E_Engine implements Engine {

    @Override
    public void runEngine() {
        System.out.println("method electro engine is running");
    }

}