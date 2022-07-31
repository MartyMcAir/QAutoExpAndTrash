package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalcTest {
    @Test
    public void sumTest() {
        assertEquals(Calc.sum(3, 3), 6);
    }

    @Test
    public void multiplyTest() {
        assertEquals(Calc.multiply(3, 3), 9);
    }
}