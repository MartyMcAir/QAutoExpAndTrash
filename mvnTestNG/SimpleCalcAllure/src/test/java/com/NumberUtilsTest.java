package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NumberUtilsTest {

    @Test(description = "my description",
            enabled = true, priority = 3, alwaysRun = true,
//            dataProvider = "dataName",
//            groups = "grName",
            suiteName = "suiteName",
            expectedExceptions = ArithmeticException.class)
    public void revertTwoNumbersTest() {
        assertEquals(NumberUtils.revertTwoNumbers(38), 83);
    }

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new StringUtilsTest(), new StringUtilsTest()};
    }

    @DataProvider(name = "provider1")
    public Object[][] someProvider() {
        return new Object[][]{
                {"val1.1", "val1.2"},
                {"val2.1", "val2.2"},
        };
    }

    @Test(dataProvider = "provider1", groups = "grName")
    public void someTest(String value1, String value2) {
        System.out.println(value1 + ", and value2: " + value2);
    }

}