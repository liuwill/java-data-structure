package com.liuwill.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
class MathTest {

    @Test
    @DisplayName("test Math sqrt")
    void sqrtTest(TestInfo testInfo) {
        double result = Math.sqrt(2);
        assertEquals(1.414, result, "math sqrt 2");

        double resultZero = Math.sqrt(2, 0);
        assertEquals(1, resultZero, "math sqrt 2 with 0");
    }
}
