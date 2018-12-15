package com.liuwill.kata.promise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
class FutureTest {

    @Test
    @DisplayName("test promise future! 😎")
    void promiseTest(TestInfo testInfo) {
        Future<Integer> promise = new Future<Integer> ((tick) -> {
            Integer source = 1;
            tick.resolve(source++);
        });
        promise.then((input) -> {
            assertEquals(input, new Integer(2), "Future work as Promise");
            return null;
        });
    }
}
