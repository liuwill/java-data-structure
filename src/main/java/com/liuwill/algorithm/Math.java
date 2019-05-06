package com.liuwill.algorithm;

class Math {

    private final static int BIT_LENGTH = 3;

    public static double sqrt(double value, int len) {
        double bit = 1;
        double start = 0;
        for (int i = 0; i < len + 1; i++) {
            double prev = start;
            while(start * start < value) {
                prev = start;
                start += bit;
            }
            start = prev;

            bit = bit * 0.1;
        }
        return start;
    }

    public static double sqrt(double value) {
        return sqrt(value, BIT_LENGTH);
    }
}
