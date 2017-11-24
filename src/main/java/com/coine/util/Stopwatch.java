package com.coine.util;

import com.coine.math.MathUtil;

/**
 * The {@code Stopwatch} data type is for measuring the time that elapses between the start and end
 * of a programming task (wall-clock time)
 *
 * See {@link StopwatchCPU} for a version that measures CPU time.
 * @author lihailong
 * @version 2017/11/24
 * @since 1.0
 */
public class Stopwatch {

    private final long start;

    /**
     * Initializes a new stopwatch
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 0; i < n; i++) {
            sum1 += MathUtil.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.15f seconds)\n", sum1, time1);

        Stopwatch timer2 = new Stopwatch();
        double sum2 = 0.0;
        for (int i = 0; i < n; i++) {
            sum2 += Math.sqrt(i);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.15f seconds)\n", sum2, time2);
    }
}
