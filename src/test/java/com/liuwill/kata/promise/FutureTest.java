package com.liuwill.kata.promise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
class FutureTest {

    @Test
    @DisplayName("test promise future! 😎")
    void promiseTest(TestInfo testInfo) {
        final HashMap<String, Integer> sourceMap = new HashMap() {
            {
                put("source", 0);
            }
        };
        Integer target = 2;
        final Exception targetError = new Exception();
        Future<Integer> promise = new Future<Integer> ((tick) -> {
            Integer source = 1;
            tick.resolve(source+1);
        });
        promise.then((input) -> {
            sourceMap.put("source", 2);
            assertEquals(input, target, "Future work as Promise resolve");
            throw targetError;
        }).catchError((exception) -> {
            assertEquals(exception, targetError, "Future work as Promise reject");
        });

        assertEquals(sourceMap.get("source"), target, "Future work Success");
    }
}
