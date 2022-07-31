package com;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Alphanumeric.class
public class MethodOrdersTest {

    @Test
    @Order(8)
    public void def() {
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }

    @Test
    @Order(16)
    public void abc() {
        assertEquals(StringUtils.toUpperCase("little"), "LITTLE");
    }

}