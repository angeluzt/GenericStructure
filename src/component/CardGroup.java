package component;

import interfaces.Draggable;
import interfaces.Drawable;
import utils.Constants;
import utils.MathUtils;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class CardGroup extends GenericComponent implements Drawable, Draggable {
    protected final LinkedList<Card> cardGroup = new LinkedList<>();

    public CardGroup() {
        super();
    }

    public CardGroup(int x, int y, LinkedList<Card> cards) {
        super(x, y, Constants.CARD_WITH, Constants.CARD_HEIGHT);
        cardGroup.addAll(cards);

        cardGroup.getLast().setHidden(false);

        this.setCardFinalLocation();
    }

    public void setCardFinalLocation() {
        for(int i = 0; i < cardGroup.size(); i++) {
            Card currentCard = cardGroup.get(i);
            //item.setHidden(true);
            currentCard.setX(this.getX());
            currentCard.setY(this.getY() + Constants.SPACE_BETWEEN_CARDS_INSIDE_GROUP * i);
        }
        AtomicInteger index = new AtomicInteger();
        cardGroup.forEach(item -> {

            index.getAndIncrement();
        });
    }

    public CardGroup(int x, int y) {
        super(x, y, Constants.CARD_WITH, Constants.CARD_HEIGHT);
    }

    public CardGroup(int x, int y, int sizeX, int sizeY) {
        super(x, y, sizeX, sizeY);
    }

    public void addCard(Card card) {
        cardGroup.add(card);
        card.setX(this.getX());
        card.setY(this.getY() + Constants.SPACE_BETWEEN_CARDS_INSIDE_GROUP * cardGroup.size());
    }

    public void addAllCards(LinkedList<Card> cards) {
        cardGroup.addAll(cards);
        updateCardsLocation();
    }

    public void updateCardsLocation() {
        AtomicInteger index = new AtomicInteger();
        cardGroup.forEach(item -> {
            item.setX(this.getX());
            item.setY(this.getY() + Constants.SPACE_BETWEEN_CARDS_INSIDE_GROUP * index.get());
            index.getAndIncrement();
        });
    }

    public Card getLastCard() {
        return cardGroup.getLast();
    }

    public Card removeLastCard() {
        return cardGroup.removeLast();
    }

    public boolean isEmpty() {
        return cardGroup.isEmpty();
    }

    public LinkedList<Card> getAllCards() {
        return cardGroup;
    }

    @Override
    public void drawGraphics(Graphics g) {
        g.setColor(Constants.GROUP_COLOR);
        g.fillRect(this.getX(), this.getY(), Constants.CARD_WITH, Constants.CARD_HEIGHT);

        cardGroup.forEach(item -> item.drawGraphics(g));
    }

    @Override
    public boolean dragEvent(Point point, CardGroup cardGroup) {
        LinkedList<Card> currentCards = new LinkedList<>();

        Iterator<Card> itrCards = this.getAllCards().descendingIterator();
        while(itrCards.hasNext()) {
            Card currentCard = itrCards.next();

            if(currentCard.isHidden()) {

                return false;
            } else {
                currentCards.addFirst(currentCard);

                if(MathUtils.isLocationClicked(point, currentCard.getX(), currentCard.getY(), currentCard.getWith(), currentCard.getHeight())) {
                    cardGroup.addAllCards(currentCards);
                    System.out.println("Drag: X = " + point.getX() + ", Y = " + point.getY());

                    for (int i = 0; i < currentCards.size(); i++)
                        this.getAllCards().removeLast();

                    return true;
                }
            }
        }

        return false;
    }
}
