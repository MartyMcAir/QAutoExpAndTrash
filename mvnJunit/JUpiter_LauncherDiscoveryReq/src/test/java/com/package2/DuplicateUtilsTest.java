package com.package2;

import com.DuplicateUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DuplicateUtilsTest {
    @Test
    public void duplicateNumberTest() {
        assertEquals(DuplicateUtils.duplicateNumber(3), 33);
    }
}