package component;

import utils.Constants;

import java.awt.*;
import java.util.LinkedList;

public class FinalGroup extends CardGroup {
    public FinalGroup() {
        super();
    }

    public FinalGroup(int x, int y) {
        super(x, y, Constants.CARD_WITH, Constants.CARD_HEIGHT);
    }

    public void addCard(Card card) {
        card.setX(this.getX());
        card.setY(this.getY());
        cardGroup.add(card);
    }

    public void addAllCards(LinkedList<Card> cards) {
        cards.forEach(item -> {
            item.setHidden(false);
            item.setX(this.getX());
            item.setY(this.getY());
        });
        cardGroup.addAll(cards);
    }

    @Override
    public void drawGraphics(Graphics g) {
        g.setColor(Constants.GROUP_COLOR);
        g.fillRect(this.getX(), this.getY(), Constants.CARD_WITH, Constants.CARD_HEIGHT);

        cardGroup.forEach(item -> item.drawGraphics(g));
    }
}
