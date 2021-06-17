package gui.body;

import gui.card.CardDisplayable;

import java.util.List;

public interface CardPanelController {

    List<CardDisplayable> getCardPanelData();
    Button getCardButton(String id);

}
