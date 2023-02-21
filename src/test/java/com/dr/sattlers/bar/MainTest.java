package com.dr.sattlers.bar;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void futureMethodHappyPath() {
        assertEquals(1, Main.futureMethod(100000));
    }

    @Test
    public void futureMethodExceptionPath() {
        assertThrows(RuntimeException.class, () -> {
            Main.futureMethod(1);
        });
    }

    @Test
    public void testIsGreater() {
        // Test case 1: num1 is greater than num2
        int num1 = 10;
        int num2 = 5;
        assertTrue(Main.isGreater(num1, num2));

        // Test case 2: num1 is equal to num2
        num1 = 5;
        num2 = 5;
        assertFalse(Main.isGreater(num1, num2));

        // Test case 3: num1 is less than num2
        num1 = 5;
        num2 = 10;
        assertFalse(Main.isGreater(num1, num2));
    }
}