package com.package1;

import com.Calc;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalcTest {
    @Test
    public void sumTest() {
        Assert.assertEquals(Calc.sum(3, 3), 6);
    }

    @Test
    public void multiplyTest() {
        assertEquals(Calc.multiply(3, 3), 9);
    }
}