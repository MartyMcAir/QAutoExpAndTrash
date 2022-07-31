package com;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DuplicateUtilsTest {
    @Test
    public void duplicateNumberTest() {
        assertEquals(DuplicateUtils.duplicateNumber(3), 33);
    }
}