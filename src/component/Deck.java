package component;

import interfaces.Drawable;
import utils.Constants;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Drawable {
    private final LinkedList<Card> deck = new LinkedList<>();
    private final LinkedList<Card> resetDeck = new LinkedList<>();

    public Deck() {
        loadCards();
    }

    public void loadCards() {
        for (int i = 1; i <= Constants.AMOUNT_OF_GROUP_CARDS; i++) {
            for (int j = 1; j <= Constants.AMOUNT_OF_CARDS; j++) {
                System.out.println(i + "-" + j +".png");
                Card currentCard = new Card(0,0, i + "-" + j +".png");
                deck.add(currentCard);
            }
        }
        System.out.println("end");
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
        resetDeck.addAll(deck);
    }

    public void resetDeck() {
        deck.clear();
        resetDeck.forEach(item -> item.setHidden(true));// hide cards since the beginning
        deck.addAll(resetDeck);
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public Card removeLastCard() {
        return deck.removeLast();
    }

    public LinkedList<Card> removeXCards(int x) {
        LinkedList<Card> removedCards = new LinkedList<>();
        while(x > 0) {
            removedCards.add(deck.removeLast());
            x--;
        }
        return removedCards;
    }

    public int getDeckSize() {
        return deck.size();
    }

    @Override
    public void drawGraphics(Graphics g) {
        deck.forEach(item -> item.drawGraphics(g));
    }
}
