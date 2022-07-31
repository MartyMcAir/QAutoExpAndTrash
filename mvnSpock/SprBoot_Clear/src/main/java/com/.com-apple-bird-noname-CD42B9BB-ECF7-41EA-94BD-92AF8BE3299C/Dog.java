package com.tmp;

public class Dog extends Animal{
    @Override
    public void voice() {
        System.out.println("гав гав");
    }

    public void dogMethod(){
        System.out.println("Dog method");
    }
}
