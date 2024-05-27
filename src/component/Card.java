package component;

import utils.Constants;
import utils.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Card extends GenericComponent {
    private BufferedImage cardImage;
    private boolean isHidden;

    public Card() {
    }

    public Card(String path) {
        this.setCardImage(path);
    }

    public Card(int x, int y, String path) {
        super(x, y, Constants.CARD_WITH, Constants.CARD_HEIGHT);

        this.isHidden = true;
        this.setCardImage(path);
    }

    public void setCardImage(String path) {
        cardImage = ImageManager.readImage(path);
    }

    public BufferedImage getCardImage() {
        return cardImage;
    }

    public void setCardImage(BufferedImage cardImage) {
        this.cardImage = cardImage;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    @Override
    public void drawGraphics(Graphics g) {
        if(isHidden) {
            g.drawImage(Constants.HIDDEN_IMAGE, this.getX(), this.getY(), this.getWith(), this.getHeight(), null);
        } else {
            g.drawImage(cardImage, this.getX(), this.getY(), this.getWith(), this.getHeight(), null);
        }
    }
}