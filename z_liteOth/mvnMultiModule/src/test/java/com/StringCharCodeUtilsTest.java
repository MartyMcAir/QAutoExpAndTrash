package com;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class StringCharCodeUtilsTest {
    @Test
    public void getCharCodeFromFirstLetterTest() {
        assertEquals(StringCharCodeUtils.getCharCodeFromFirstLetter("abc"), 97);
    }
}