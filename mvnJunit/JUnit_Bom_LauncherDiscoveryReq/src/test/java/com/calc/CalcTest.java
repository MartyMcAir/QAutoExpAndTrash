package com.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test; // J 5
import сom.calc.Calc;

public class CalcTest {
    @Test
    public void sumTest() {
        Assertions.assertEquals(Calc.sum(3, 3), 6);
    }

    @Test
    public void multiplyTest() {
        Assertions.assertEquals(Calc.multiply(3, 3), 9);
    }
}