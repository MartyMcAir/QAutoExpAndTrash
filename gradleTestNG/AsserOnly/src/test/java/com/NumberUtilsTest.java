package com;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberUtilsTest {
    @Test
    public void revertTwoNumbersTest() {
        assertEquals(NumberUtils.revertTwoNumbers(38), 83);
    }
}