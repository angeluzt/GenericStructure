package utils;

import java.awt.*;

public class MathUtils {
    public static boolean isLocationClicked(Point p1_click, int x, int y, int with, int height) {
        if(p1_click.x >= x && p1_click.x <= x + with && p1_click.y >= y && p1_click.y <= y + height) {
            return true;
        }

        return false;
    }
}
