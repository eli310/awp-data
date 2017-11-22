package com.coine.util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * @author lihailong
 * @version 2017/11/22
 * @since 1.0
 */
public class StdOut {

    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.CHINA;
    // send output here
    private static PrintWriter out;

    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }
    // don't instantiate
    private StdOut() {}

    /** Closes standard output */
    public static void close() {
        out.close();
    }

    /** Terminates the current line by printing the line-separate or string. */
    public static void println() {
        out.println();
    }

    /**
     * Prints an object to this output stream and then terminates the line.
     *
     * @param x the object to output
     */
    public static void println(Object x) {
        out.println(x);
    }

    /**
     * Print a boolean to standard output and then terminates the line.
     *
     * @param x the boolean to print
     */
    public static void println(boolean x) {
        out.println(x);
    }

    /**
     * Print a char to standard output and then terminates the line.
     *
     * @param x the char to print
     */
    public static void println(char x) {
        out.println(x);
    }

    /**
     * Print an int to standard output and then terminates the line.
     *
     * @param x the int to print
     */
    public static void println(int x) {
        out.println(x);
    }

    /**
     * Print a long to standard output and then terminates the line.
     *
     * @param x the long to print
     */
    public static void println(long x) {
        out.println(x);
    }

    /**
     * Print a short to standard output and then terminates the line.
     *
     * @param x the short to print
     */
    public static void println(short x) {
        out.println(x);
    }

    /**
     * Print a float to standard output and then terminates the line
     *
     * @param x the float to print
     */
    public static void println(float x) {
        out.println(x);
    }

    /**
     * Print a double to standard output and then terminates the line.
     *
     * @param x the double to print
     */
    public static void println(double x) {
        out.println(x);
    }

    /**
     * Print a byte to standard output and then terminates the line.
     *
     * @param x the byte to print
     */
    public static void println(byte x) {
        out.println(x);
    }

    /** Prints an object to standard output and flushes standard output. */
    public static void print() {
        out.flush();
    }

    /**
     * Prints an object to standard output and flushes standard output.
     *
     * @param x the object to print
     */
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a boolean to standard output and flushes standard output.
     *
     * @param x the boolean to print
     */
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a char to standard output and flushes standard output.
     *
     * @param x the char to print
     */
    public static void print(char x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a x to standard output and flushes standard output.
     *
     * @param x the int to print
     */
    public static void print(int x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a long to standard output and flushes standard output.
     *
     * @param x the long to print
     */
    public static void print(long x) {
        out.print(x);
        out.flush();
    }

    public static void print(float x) {
        out.print(x);
        out.flush();
    }

    public static void print(double x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a byte to standard output and flushes the standard output
     *
     * @param x the byte to print
     */
    public static void print(byte x) {
        out.print(x);
        out.flush();
    }

    /**
     * Prints a formatted string to standard output, using the specified format string and
     * arguments, and then flushes standard output.
     *
     * @param format format string
     * @param args the arguments accompany the format string
     */
    public static void printf(String format, Object... args) {
        out.printf(format, args);
        out.flush();
    }

    /**
     * Prints a formatted string to standard output, using the locale and the specified format
     * string and arguments; then flushes standard output
     *
     * @param locale the locale
     * @param format format string
     * @param args the arguments accompany the format string
     */
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }
}
