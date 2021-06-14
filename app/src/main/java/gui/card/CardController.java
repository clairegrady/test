package gui.card;

import application.CardData;
import gui.body.Button;

public interface CardController {
    void addCard(CardData cardData, int rows, Button button);
}
