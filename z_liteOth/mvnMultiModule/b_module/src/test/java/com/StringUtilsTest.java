package com;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringUtilsTest {
    @Test
    public void stringToUpperCaseTest() {
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }
}