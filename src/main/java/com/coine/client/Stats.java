package com.coine.client;

import com.coine.basic.Bag;
import com.coine.math.MathUtil;
import com.coine.util.StdIn;
import com.coine.util.StdOut;

/**
 * @author lihailong
 * @version 2017/11/22
 * @since 1.0
 */
public class Stats {

    public static void main(String[] args) {

        Bag<Double> numbers = new Bag<>();
        while (StdIn.isNotEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = MathUtil.sqrt(sum/ (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
