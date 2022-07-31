package com.package2;

import com.DuplicateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DuplicateUtilsTest {
    @Test
    public void duplicateNumberTest() {
        Assert.assertEquals(DuplicateUtils.duplicateNumber(3), 33);
    }
}