package utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Constants {
    public static final int WINDOW_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().getSize().width);
    public static final int WINDOW_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().getSize().height * 0.8);
    public static final Color BACKGROUND_COLOR = new Color(51, 161, 73);
    public static Color GROUP_COLOR = new Color(80, 90, 70, 150);
    public static Color SELECTED_CARD_COLOR = new Color(227, 98, 106, 100);

    public static int CARD_WITH = 100;
    public static int CARD_HEIGHT = 160;
    public static int AMOUNT_OF_GROUP_CARDS = 4;
    public static int AMOUNT_OF_CARDS = 13;

    public static int SPACE_BETWEEN_CARDS_INSIDE_GROUP = 30;

    public static BufferedImage HIDDEN_IMAGE = ImageManager.readImage("back-1.png");
    
    public static final double NANO_SECOND = 1000000000;

}
