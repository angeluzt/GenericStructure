package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Constants {
    public static final int WINDOW_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().getSize().width * 0.5);
    public static final int WINDOW_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().getSize().height * 0.5);
    public static final Color BACKGROUND_COLOR = new Color(51, 161, 73);
    
    public static final double NANO_SECOND = 1000000000;

    public static void playSound(String soundName) {
        String gongFile = "resources/sound/" + soundName;
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(gongFile)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public static BufferedImage readImage(String path){
        try {
            return ImageIO.read(new File("resources/images/" + path));
        } catch (IOException e) {
            // log information
        }
        return null;
    }

}
