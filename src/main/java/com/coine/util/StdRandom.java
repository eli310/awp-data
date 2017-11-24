package com.coine.util;

import java.util.Random;

/**
 * @author lihailong
 * @version 2017/11/21
 * @since 4-0-
 */
public class StdRandom {
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    // don't instantiate
    private StdRandom() {}
    /** initialize */
    public static void setSeed(long s) {
        seed = s;
        random = new Random();
    }

    /**
     * Returns the seed of the pseudo random number generator
     *
     * @return the seed
     */
    public static long getSeed() {
        return seed;
    }

    /**
     * Returns a random real number uniformly in [0, 1)
     *
     * @return a random real number uniformly in [0, 1)
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * Returns a random real number uniformly in [0, 1)
     *
     * @param n number of possible integers
     * @return a random integer uniformly between 0 (inclusive) and {@code n} (exclusive)
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt(n);
    }

    /**
     * Returns a random long integer uniformly in [0, n).
     *
     * @param n number of possible long integers
     * @return a random long integer uniformly between 0 (inclusive) and {@code n} (exclusive)
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static long uniform(long n) {
        if (n <= 0L) throw new IllegalArgumentException("argument must be positive: " + n);

        long r = random.nextLong();
        long m = n - 1;

        if ((n & m) == 0L) {
            return r & m;
        }

        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }

    /** integer between lo and hi */
    public static int uniform(int lo, int hi) {
        if ((hi <= lo) || ((long) hi - lo >= Integer.MAX_VALUE))
            throw new IllegalArgumentException("invalid range: [" + lo + ", " + hi + ")");
        return lo + uniform(hi - lo);
    }

    /**
     * Returns a random real number uniformly in [a, b)
     *
     * @param lo the left endpoint
     * @param hi the right endpoint
     * @return a random real number uniformly in [a, b)
     * @throws IllegalArgumentException unless {@code a < b}
     */
    public static double uniform(double lo, double hi) {
        if (!(lo < hi))
            throw new IllegalArgumentException("invalid range: [" + lo + ", " + hi + ")");
        return lo + uniform() * (hi - lo);
    }

    /**
     * Returns a random boolean from a Bernoulli distribution with success probability <em>p</em>
     *
     * @param p the probability of return {@code true}
     * @return {@code true} with probability {@code p} and {@code false} with probability {@code p}
     * @throws IllegalArgumentException unless {@code 0} &le: {@code p} &le: {@code 1.0}
     */
    public static boolean bernoulli(double p) {
        if (!(p >= 0.0 && p <= 1.0))
            throw new IllegalArgumentException("probability p must be between 0.0 and 1.0: " + p);
        return uniform() < p;
    }

    /**
     * Returns a random boolean from a Bernoulli distribution with success probability 1/2
     *
     * @return {@code true} with probability 1/2 and {@code false} with probability 1/2
     */
    public static boolean bernoulli() {
        return bernoulli(0.5);
    }

    /**
     * Returns a random real number from a standard Gaussian distribution
     *
     * @return a random real number from a standard Gaussian distribution (mean 0 and standard
     *     deviation 1).
     */
    public static double gaussian() {
        double r, x, y;
        do {
            x = uniform(-1.0, 1.0);
            y = uniform(-1.0, 1.0);
            r = x * x + y * y;
        } while (r >= 1 || r == 0);
        return x * Math.sqrt(-2 * Math.log(r) / r);
    }

    /**
     * Returns a random real number from a Gaussian distribution with mean &mu;
     * and standard deviation &sigma
     * @param mu the mean
     * @param sigma the standard deviation
     * @return a real number distributed according to the Gaussian
     */
    public static double gaussian(double mu, double sigma) {
        return mu + sigma * gaussian();
    }

    public static int discrete(double[] a) {
        double r = uniform();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum >= r) return i;
        }
        return -1;
    }

    public static void shuffle(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
