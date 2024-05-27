package interfaces;

import component.Card;
import component.CardGroup;

import java.awt.*;
import java.util.LinkedList;

public interface Draggable {
    boolean dragEvent(Point point, CardGroup cardGroup);
}
