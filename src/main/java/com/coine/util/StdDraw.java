package com.coine.util;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author lihailong
 * @version 2017/11/22
 * @since 4-0-
 */
public class StdDraw {
    /** the color black */
    public static final Color BLANK = Color.BLACK;

    public static final Color BLUE = Color.BLUE;

    public static final Color CYAN = Color.CYAN;

    public static final Color DARK_GRAY = Color.DARK_GRAY;

    public static final Color GRAY = Color.GRAY;

    public static final Color GREEN = Color.GREEN;

    public static final Color LIGHT_GRAY = Color.LIGHT_GRAY;

    public static final Color MAGENTA = Color.MAGENTA;

    public static final Color ORANGE = Color.ORANGE;

    public static final Color PINK = Color.PINK;

    public static final Color RED = Color.RED;

    public static final Color WHITE = Color.WHITE;

    public static final Color YELLOW = Color.YELLOW;

    public static final Color BOOK_BLUE = new Color(9, 90, 160);

    public static final Color BOOL_LIGHT_BLUE = new Color(103, 198, 243);

    public static final Color BOOK_RED = new Color(150, 35, 31);

    public static final Color PRINCETON_ORANGE = new Color(245, 128, 37);
    // default colors
    private static final Color DEFAULT_PEN_COLOR = BLANK;
    private static final Color DEFAULT_CLEAR_COLOR = WHITE;
    // current pen color
    private static Color penColor;

    // default canvas size is DEFAULT_SIZE-by-DEFAULT_SIZE
    private static final int DEFAULT_SIZE = 512;
    private static int width = DEFAULT_SIZE;
    private static int height = DEFAULT_SIZE;
    // default pen radius
    private static final double DEFAULT_PEN_RADIUS = 0.002;
    // current pen radius
    private static double penRadius;
    // show we draw immediately or wait until next show?
    private static boolean defer = false;

    private static final double BORDER = 0.00;
    private static final double DEFAULT_XMIN = 0.0;
    private static final double DEFAULT_XMAX = 1.0;
    private static final double DEFAULT_YMIN = 0.0;
    private static final double DEFAULT_YMAX = 1.0;
    private static double xmin, xmax, ymin, ymax;
    // for synchronize
    private static Object mouseLock = new Object();
    private static Object keyLock = new Object();

    private static final Font DEFAULT_FONT = new Font("SansSerif", Font.PLAIN, 16);
    // current font
    private static Font font;
    // double buffered graphics
    private static BufferedImage offscreenImage, onscreenImage;
    private static Graphics2D offscreen, onscreen;

    // singleton for callbacks; avoids generation of extra .class files
    private static StdDraw std = new StdDraw();
}
