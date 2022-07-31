package com;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(CustomOrder.class)
public class zDntWrkCustomMethodOrdersTest {

    @Test
    public void def() {
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }

    @Test
    public void abc() {
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }

}