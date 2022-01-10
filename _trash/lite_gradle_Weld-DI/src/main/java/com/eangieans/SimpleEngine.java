package com.eangieans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative // skip Ambiguous dependencies for container_ use it like Alternative if nothing else..
public class SimpleEngine implements Engine {

    @Override
    public void runEngine() {
        System.out.println("method simple engine is running");
    }

}
