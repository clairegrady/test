package gui.body;

import gui.card.CardData;
import gui.card.CardDisplayable;
import gui.card.CardController;
import gui.card.Card;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

public class CardPanel extends JPanel implements CardController {

    private final GridBagConstraints gbc = new GridBagConstraints();
    private final CardPanelController cardPanelController;

    public CardPanel(CardPanelController cardPanelController) {
        super();
        super.setLayout(new GridBagLayout());
        this.cardPanelController = cardPanelController;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
        displayCards();
    }

    public void displayCards() {
        clearCardPanel();
        List<CardDisplayable> cardPanelData = cardPanelController.getCardPanelData();
        for (CardDisplayable cd :  cardPanelData) {
            addCard(
                    cd.getCardData(),
                    cardPanelData.size(),
                    cardPanelController.getCardButton(cd.getCardDisplayUniqueId())
            );
        }
    }

    public void displayCards(List<CardDisplayable> cards) {
        clearCardPanel();
        for (CardDisplayable cd :  cards) {
            addCard(
                    cd.getCardData(),
                    cards.size(),
                    cardPanelController.getCardButton(cd.getCardDisplayUniqueId())
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
                new Card(this, cardData.getLabelOne(), cardData.getLabelTwo(), rows, button),
                gbc
        );
    }

}