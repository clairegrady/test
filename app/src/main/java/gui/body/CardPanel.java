package gui.body;

import application.CardData;
import gui.card.Card;
import gui.card.CardController;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel implements CardController {

    private final GridBagConstraints gbc = new GridBagConstraints();
    private final CardPanelController cpc;

    public CardPanel(CardPanelController cpc) {
        super();
        super.setLayout(new GridBagLayout());
        this.cpc = cpc;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
    }

    public void addCard(CardData cardData, int rows, Button button) {
        this.add(
                new Card(this, cardData.getLabelOne(), cardData.getLabelTwo(), rows, button),
                gbc
        );
    }

}