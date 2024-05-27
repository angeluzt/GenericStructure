package component;

import interfaces.Clickable;
import utils.Constants;
import utils.MathUtils;

import java.awt.*;
import java.util.LinkedList;

public class FoodCardGroup extends CardGroup implements Clickable {

    public FoodCardGroup() {
        super();
    }

    public FoodCardGroup(int x, int y, LinkedList<Card> cards, boolean hideAll) {
        super(x, y, Constants.CARD_WITH, Constants.CARD_HEIGHT);
        this.cardGroup.addAll(cards);

        cardGroup.forEach(item -> {
            item.setHidden(true);
        });
        this.setCardFinalLocation();
    }

    public void setCardFinalLocation() {
        cardGroup.forEach(item -> {
            item.setX(this.getX());
            item.setY(this.getY());
        });
    }

    public void addCard(Card card, boolean isHidden) {
        cardGroup.add(card);
        card.setHidden(isHidden);
        card.setX(this.getX());
        card.setY(this.getY());
    }

    public void addAllCards(LinkedList<Card> cards,  boolean isHidden) {
        cards.forEach(item -> {
            item.setX(this.getX());
            item.setY(this.getY());
            item.setHidden(isHidden);
        });
        cardGroup.addAll(cards);
    }

    @Override
    public void drawGraphics(Graphics g) {
        g.setColor(Constants.GROUP_COLOR);
        g.fillRect(this.getX(), this.getY(), Constants.CARD_WITH, Constants.CARD_HEIGHT);

        cardGroup.forEach(item -> item.drawGraphics(g));
    }

    @Override
    public boolean clickEvent(Point point) {
        if(MathUtils.isLocationClicked(point, this.getX(), this.getY(), this.getWith(), this.getHeight())) {
            System.out.println("Food clicked");
            return true;
        }

        return false;
    }
}
