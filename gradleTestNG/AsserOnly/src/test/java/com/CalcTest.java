package com;

import com.Calc;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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