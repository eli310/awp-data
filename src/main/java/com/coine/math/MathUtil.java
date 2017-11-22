package com.coine.math;

/**
 * @author lihailong
 * @version 2017/11/21
 * @since 4-0-
 */
public class MathUtil {

    public static int gcd(int p, int q) {
        if (p < q) return gcd(q, p);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int abs(int x) {
        if (x < 0) return -x;
        return x;
    }

    public static double abs(double x) {
        if (x < 0.0) return -x;
        return x;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static double sqrt(double c) {
        if (c < 0.0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    public static double hypotenuse(double a, double b) {
        return sqrt(a * a + b * b);
    }

    public static double H(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static void swap(Object a, Object b) {
        Object tmp = a;
        a = b;
        b = tmp;
    }
}
