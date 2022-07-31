package com.package1;

import com.Calc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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