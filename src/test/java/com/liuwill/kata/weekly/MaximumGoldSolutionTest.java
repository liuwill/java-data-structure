package com.liuwill.kata.weekly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
class MaximumGoldSolutionTest {

    @Test
    @DisplayName("test max gold solution!")
    void solutionTest(TestInfo testInfo) {
        int[][][] sourceCase = {
            {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}},
            {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}},
            {
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 0, 0, 0, 0, 0},
                {3, 0, 0, 20, 20, 20},
            },
        };
        int[] expectList = { 24, 28, 60 };


        for (int i = 0; i < sourceCase.length; i++) {
            int expect = expectList[i];
            int[][] grid = sourceCase[i];

            int target = new MaximumGoldSolution().getMaximumGold(grid);
            assertEquals(target, expect, "getMaximumGold work Success");
        }
    }
}
