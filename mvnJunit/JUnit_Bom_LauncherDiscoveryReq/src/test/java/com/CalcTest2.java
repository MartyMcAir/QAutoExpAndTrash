package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import сom.calc.Calc;

public class CalcTest2 {
    @Test
    public void sumTest() {
        Assertions.assertEquals(Calc.sum(3, 3), 6);
    }

    @Test
    public void multiplyTest() {
        Assertions.assertEquals(Calc.multiply(3, 3), 9);
    }
}