package com;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilsTest {
    @Test
    public void revertTwoNumbersTest() {
        assertEquals(NumberUtils.revertTwoNumbers(38), 83);
    }
}