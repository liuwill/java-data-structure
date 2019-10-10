package com.liuwill.kata.weekly;

import java.util.Stack;

class MaximumGoldSolution {

    private int[][] initVisitedMap(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        return new int[width][height];
    }

    private boolean couldVisit(int i, int j, int[][] grid, int[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0 || visited[i][j] > 0) {
            return false;
        }
        return true;
    }

    public int getMaximumGold(int[][] grid) {
        Stack<Integer[]> stack = new Stack<>();

        int[][] visited;
        int[][] target = initVisitedMap(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited = initVisitedMap(grid);
                stack.push(new Integer[] { i, j, grid[i][j], 0 });

                while (!stack.isEmpty()) {
                    Integer[] point = stack.pop();
                    int x = point[0];
                    int y = point[1];
                    int current = point[2];

                    if (point[3] == 1) {
                        visited[x][y] = 0;
                        continue;
                    } else {
                        point[3] = 1;
                    }

                    if (!couldVisit(x, y, grid, visited)) {
                        continue;
                    }

                    visited[x][y] = 1;
                    if (current > target[i][j]) {
                        target[i][j] = current;
                    }

                    stack.push(point);
                    if (i > 0) {
                        stack.push(new Integer[] { i - 1, j, current + grid[i - 1][j], 0 });
                    }
                    if (j > 0) {
                        stack.push(new Integer[] { i, j - 1, current + grid[i][j - 1], 0 });
                    }
                    if (i < grid.length - 1) {
                        stack.push(new Integer[] { i + 1, j, current + grid[i + 1][j], 0 });
                    }
                    if (j < grid[0].length - 1) {
                        stack.push(new Integer[] { i, j + 1, current + grid[i][j + 1], 0 });
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if (target[i][j] > max) {
                    max = target[i][j];
                }
            }
        }

        return max;
    }
}
