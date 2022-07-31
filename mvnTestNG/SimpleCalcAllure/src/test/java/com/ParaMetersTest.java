package com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParaMetersTest {

    @Test()
    @Parameters({"key1", "key2"})
    public void someTest(String val1, String val2) {
        System.out.println("val1: " + val1 + ", val2:" + val2); // val1: mango, val2:yogurt
    }

}