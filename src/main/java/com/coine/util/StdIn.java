package com.coine.util;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author lihailong
 * @version 2017/11/21
 * @since 4-0-
 */
public class StdIn {

    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.CHINA;
    // the default token separator; we maintain the invariant that this value
    // is held by the scanner's delimiter by calls
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    // makes whitespace significant
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");
    // used to read the entire input
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    /** end: section(1 of 2) of code duplicated form In to StdIn */
    private static Scanner scanner;
    // it doesn't make sense to instantiate this class
    private StdIn() {}

    /// begin: section (2 of 2) of code duplicated from In to StdIn
    /// with all methods changed from "public" to "public static"

    /**
     * Returns true if standard input is empty (except possibly for whitespace). Use this method to
     * know whether the next call to {@link #readString()}, {@link #readDouble()}, etc will succeed.
     *
     * @return {@code true} if standard input is empty (except possibly for whitespace); {@code
     *     false} otherwise
     */
    public static boolean isEmpty() {
        return !isNotEmpty();
    }

    public static boolean isNotEmpty() {
        return scanner.hasNext();
    }

    /**
     * Returns true if standard input has a next line. Use this method to know whether the next call
     * to {@link #readLine()} will succeed. This method is functionally equivalent to {@link
     * #hasNextChar()}
     *
     * @return {@code true} if standard input has more input (including whitespace); <br>
     *     {@code false} otherwise
     */
    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * Return true if the standard input has more input (include whitespace). Use this method to
     * know whether the next call to {@link #readChar()} will succeed. This method is functionally
     * equivalent to {@link #hasNextLine()}.
     *
     * @return {@code true } if standard input has more input (including whitespace); <br>
     *     {@code false} otherwise
     */
    public static boolean hasNextChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    /**
     * Reads and returns the next line, excluding the line separator if present.
     *
     * @return the next line, excluding the line separator if present. {@code null} if no such line
     */
    public static String readLine() {
        String line;
        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            line = null;
        }
        return line;
    }

    /**
     * Reads and returns the next character.
     *
     * @return the next {@code char}
     * @throws NoSuchElementException if stand input is empty
     */
    public static char readChar() {
        try {
            scanner.useDelimiter(EMPTY_PATTERN);
            String ch = scanner.next();
            assert ch.length() == 1
                    : "Internal (Std)In.readChar() error! Please contact the authors";
            scanner.useDelimiter(WHITESPACE_PATTERN);
            return ch.charAt(0);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'char' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Reads and returns the remainder of the input, as a String.
     *
     * @return the remainder of the input, as a string.
     * @throws NoSuchElementException if standard input is empty
     */
    public static String readAll() {
        if (!scanner.hasNextLine()) return "";

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that import to reset delimiter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    /**
     * Reads the next token and returns the {@code String}
     *
     * @return the next {@code String}
     * @throws NoSuchElementException if standard input is empty
     */
    public static String readString() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'String' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Read the next token from standard input, parses it as an integer, and returns the integer.
     *
     * @return the next integer on standard input.
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as an {@code int}
     */
    public static int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read an 'int' value from standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read an 'int' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Reads the next token from standard input, parses it as a double, and returns the double.
     *
     * @return the next double on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as {@code double}
     */
    public static double readDouble() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read a 'double' value from standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'double' value from the standard input, but there are no more tokens available");
        }
    }

    /**
     * Reads the next token from standard input, parses it as a float, and return the float.
     *
     * @return the next float on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code float}
     */
    public static float readFloat() {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read a 'float' value from standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read 'float' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Read the next token from the standard input, parses it as a long, and return the long
     * integer.
     *
     * @return the next long integer on standard input.
     * @throws NoSuchElementException if the standard input is empty.
     * @throws InputMismatchException if the next token cannot be parsed as a {@code long}
     */
    public static long readLong() {
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read a 'long' value from standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'long' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Read the next token from standard input, parses it as a short integer, and return the short
     * integer.
     *
     * @return the next short integer on standard input.
     * @throws NoSuchElementException if the standard input is empty.
     * @throws InputMismatchException if the next token cannot be parsed as a {@code short}
     */
    public static short readShort() {
        try {
            return scanner.nextShort();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read a 'short' value from standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'short' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Reads the next token from standard input, parses it as a byte, and return the byte.
     *
     * @return the next byte on standard input
     * @throws NoSuchElementException if the standard input is empty.
     * @throws InputMismatchException if the next token cannot be parsed as {@code byte}
     */
    public static byte readByte() {
        try {
            return scanner.nextByte();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read a 'byte' value from the standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'byte' value from the standard input, but there are no more tokens available");
        }
    }

    /**
     * Reads the next token from standard input, parses it as a boolean.
     *
     * @return the next byte on standard input
     * @throws NoSuchElementException if the standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code byte}
     */
    public static boolean readBoolean() {
        try {
            return scanner.nextBoolean();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException(
                    "attempts to read a 'boolean' value from the standard input, but the next token is \""
                            + token
                            + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attempts to read a 'boolean' value from the standard input, but there are no more tokens available");
        }
    }

    /**
     * Read all remaining tokens from the standard input and returns them as an array of strings.
     *
     * @return all remaining tokens on standard input, as an array of strings
     */
    public static String[] readAllStrings() {
        // we could use readAll.trim().split(), but there is no consistent
        // because trim() uses characters 0x00, 0x20 as whitespace.
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0) {
            return tokens;
        }

        // don't include first token if it is leading whitespace
        String[] decapitokens = new String[tokens.length - 1];
        for (int i = 0; i < tokens.length - 1; i++) {
            decapitokens[i] = tokens[i + 1];
        }
        return decapitokens;
    }

    /**
     * Reads all remaining lines from standard input, and return them as an array of strings.
     *
     * @return all remaining lines on standard input, as an array of strings
     */
    public static String[] readAllLines() {
        ArrayList<String> lines = new ArrayList<>();
        while (hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * Reads all remaining tokens from standard input, parses them as as integers, and returns them
     * as an array of integers.
     *
     * @return all remaining integers on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as an {@code int}
     */
    public static int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++) {
            vals[i] = Integer.parseInt(fields[i]);
        }
        return vals;
    }

    /**
     * Reads all remaining tokens from standard input, parse them as longs, and returns them as an
     * array of long.
     *
     * @return all remaining longs on standardinput, as an array
     * @throws InputMismatchException if any token cannot be parsed as a {@code long}
     */
    public static long[] readAllLongs() {
        String[] fields = readAllStrings();
        long[] vals = new long[fields.length];
        for (int i = 0; i < fields.length; i++) {
            vals[i] = Long.parseLong(fields[i]);
        }
        return vals;
    }

    /**
     * Reads all remaining tokens from standard input, parses them as doubles, and returns them as
     * an array of double.
     *
     * @return all remaining doubles on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as {@code double}
     */
    public static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++) {
            vals[i] = Double.parseDouble(fields[i]);
        }
        return vals;
    }

    static {
        resync();
    }

    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }

    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(LOCALE);
    }
}
