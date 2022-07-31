package com;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringUtilsTest {
    @Test
    public void def() {
        System.out.println("stringToUpperCaseTest");
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }

    @Test
    public void stringToUpperCaseTest() {
        System.out.println("stringToUpperCaseTest");
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }

    @Test
    public void abc() {
        System.out.println("stringToUpperCaseTest");
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }


}