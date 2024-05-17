package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageManager {
    public static BufferedImage readImage(String path){
        try {
            return ImageIO.read(new File("resources/images/" + path));
        } catch (IOException e) {
            // log information
        }
        return null;
    }
}
