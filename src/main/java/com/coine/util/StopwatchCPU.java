package com.coine.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * The {@code StopwatchCPU} data type is for measuring the CPU time used during a programming task.
 *
 * @author lihailong
 * @version 2017/11/24
 * @since 1.0
 */
public class StopwatchCPU {
    private static final double NANOSECONDS_PER_SECOND = 1000_000_000;

    private final ThreadMXBean threadTimer;
    private final long start;

    /** Initializes a new stopwatch */
    public StopwatchCPU() {
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was create
     */
    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }

    /**
     * Unit tests the {@code StopwatchCPU} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StopwatchCPU timer1 = new StopwatchCPU();
        double sum1 = 0.0;
        for (int i = 0; i < n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.15f seconds)\n", sum1, time1);

        StopwatchCPU timer2 = new StopwatchCPU();
        double sum2 = 0.0;
        for (int i = 0; i < n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.15f seconds)\n", sum2, time2);
    }
}
