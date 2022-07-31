package com;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {
    @Test
    public void stringToUpperCaseTest() {

        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");

    }

}