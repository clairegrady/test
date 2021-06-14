package gui.body;

import application.CardDisplayable;

import java.util.List;

public interface ScrollPaneController {

    List<? extends CardDisplayable> getScrollPaneData(String paneName);
    Button getCardButton();

}
