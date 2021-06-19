package gui.body;

import gui.card.Card;
import gui.card.CardController;
import gui.card.CardData;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class CardPanel extends JPanel implements CardController {

    private final GridBagConstraints gbc = new GridBagConstraints();
    private final CardPanelController cardPanelController;

    public CardPanel(CardPanelController cardPanelController) {
        super();
        super.setLayout(new GridBagLayout());
        this.cardPanelController = cardPanelController;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
//        displayCards();
    }

//    public void displayCards() {
//        clearCardPanel();
//        List<CardDisplayable> cardPanelData = cardPanelController.getCardPanelData();
//        for (CardDisplayable cd : cardPanelData) {
//            addCard(
//                    cd.getCardData(),
//                    cardPanelData.size(),
//                    cardPanelController.getCardButton(cd.getCardDisplayUniqueId())
//            );
//        }
//    }

//    public void displayCards(List<CardDisplayable> cards) {
//        clearCardPanel();
//        for (CardDisplayable cd : cards) {
//            addCard(
//                    cd.getCardData(),
//                    cards.size(),
//                    cardPanelController.getCardButton(cd.getCardDisplayUniqueId())
//            );
//        }
//    }

    public void displayCardsTest(List<CardDisplayable> cards) {
        clearCardPanel();
        for (CardDisplayable card : cards) {
            CardData cd = card.getCardData();
            addCard(
                    cd.getMainLabel(),
                    cd.getSecondaryLabel(),
                    cardPanelController.getCardCenterLabel(cd.getItemUniqueId()),
                    cardPanelController.getCardButton(card.getCardDisplayUniqueId())
            );
        }
    }

    public void clearCardPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    public void addCard(CardData cardData, int rows, Button button) {
        this.add(
                new Card(this, cardData.getMainLabel(), cardData.getSecondaryLabel(), rows, button),
                gbc
        );
    }

    public void addCard(String mainLabel, String secondaryLabel, String centerLabel, Button button) {
        this.add(
                new Card(mainLabel, secondaryLabel, centerLabel, button),
                gbc
        );
    }

}