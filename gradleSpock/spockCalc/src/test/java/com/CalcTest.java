package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {

    @Test
    public void sumTest() {
        assertEquals(6, Calc.sum(3, 3));
    }

}