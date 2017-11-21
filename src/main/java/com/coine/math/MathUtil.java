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
}
