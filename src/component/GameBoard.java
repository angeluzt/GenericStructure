package component;

import interfaces.Drawable;

import java.awt.*;
import java.util.LinkedList;

public class GameBoard extends GenericComponent implements Drawable {

    private final Deck deck;
    public FoodCardGroup deck_provider;
    public FoodCardGroup deck_provider_display;
    public FinalGroup final_deck_1;
    public FinalGroup final_deck_2;
    public FinalGroup final_deck_3;
    public FinalGroup final_deck_4;

    public CardGroup game_deck_1;
    public CardGroup game_deck_2;
    public CardGroup game_deck_3;
    public CardGroup game_deck_4;
    public CardGroup game_deck_5;
    public CardGroup game_deck_6;
    public CardGroup game_deck_7;

    public CardGroup dragCardGroup;
    public CardGroup originalDragGroup;
    private boolean isDragCards = false;

    public GameBoard() {
        deck = new Deck();
        initGame();
    }

    public void initGame() {
        deck.shuffleCards();

        game_deck_1 = new CardGroup(50, 300, deck.removeXCards(1));
        game_deck_2 = new CardGroup(250, 300, deck.removeXCards(2));
        game_deck_3 = new CardGroup(450, 300, deck.removeXCards(3));
        game_deck_4 = new CardGroup(650, 300, deck.removeXCards(4));
        game_deck_5 = new CardGroup(850, 300, deck.removeXCards(5));
        game_deck_6 = new CardGroup(1050, 300, deck.removeXCards(6));
        game_deck_7 = new CardGroup(1250, 300, deck.removeXCards(7));

        deck_provider = new FoodCardGroup(50, 50, deck.removeXCards(deck.getDeckSize()), true);
        deck_provider_display = new FoodCardGroup(250, 50, new LinkedList<>(), false);

        final_deck_1 = new FinalGroup(650, 50);
        final_deck_2 = new FinalGroup(850, 50);
        final_deck_3 = new FinalGroup(1050, 50);
        final_deck_4 = new FinalGroup(1250, 50);

        dragCardGroup = new CardGroup();
    }

    @Override
    public void drawGraphics(Graphics g) {

        game_deck_1.drawGraphics(g);
        game_deck_2.drawGraphics(g);
        game_deck_3.drawGraphics(g);
        game_deck_4.drawGraphics(g);
        game_deck_5.drawGraphics(g);
        game_deck_6.drawGraphics(g);
        game_deck_7.drawGraphics(g);

        deck_provider.drawGraphics(g);
        deck_provider_display.drawGraphics(g);

        final_deck_1.drawGraphics(g);
        final_deck_2.drawGraphics(g);
        final_deck_3.drawGraphics(g);
        final_deck_4.drawGraphics(g);

        // if drag group is active
        if(!dragCardGroup.isEmpty())
            dragCardGroup.drawGraphics(g);
    }

    public void clickEvent(Point point) {
        if (deck_provider.clickEvent(point)) {
            if (!deck_provider.isEmpty()) {
                Card currentCard = deck_provider.removeLastCard();

                deck_provider_display.addCard(currentCard, false);
            } else {
                deck_provider.addAllCards(deck_provider_display.getAllCards(), true);
                deck_provider_display.getAllCards().clear();
            }
        }
    }

    public void dragEvent(Point point) {

        if (isDragCards) {
            dragCardGroup.setX(point.x - 30);
            dragCardGroup.setY(point.y - 30);
            dragCardGroup.updateCardsLocation();

            return;
        }

        if (deck_provider_display.dragEvent(point, dragCardGroup)) {
            originalDragGroup = deck_provider_display;
            isDragCards = true;
            return;
        }

        if (game_deck_1.dragEvent(point, dragCardGroup)) {
            originalDragGroup = game_deck_1;
            isDragCards = true;
            return;
        }
        if(game_deck_2.dragEvent(point,dragCardGroup)) {
            originalDragGroup = game_deck_2;
            isDragCards = true;
            return;
        }
        if(game_deck_3.dragEvent(point, dragCardGroup)) {
            originalDragGroup = game_deck_3;
            isDragCards = true;
            return;
        }
        if(game_deck_4.dragEvent(point, dragCardGroup)) {
            originalDragGroup = game_deck_4;
            isDragCards = true;
            return;
        }
        if(game_deck_5.dragEvent(point, dragCardGroup)) {
            originalDragGroup = game_deck_5;
            isDragCards = true;
            return;
        }
        if(game_deck_6.dragEvent(point, dragCardGroup)) {
            originalDragGroup = game_deck_6;
            isDragCards = true;
            return;
        }
        if(game_deck_7.dragEvent(point, dragCardGroup)) {
            originalDragGroup = game_deck_7;
            isDragCards = true;
        }
    }

    public void releaseEvent() {
        originalDragGroup.addAllCards(dragCardGroup.getAllCards());
        dragCardGroup = new CardGroup();
        isDragCards = false;

    }
}
