package gui.body;

import application.CardData;
import application.CardDisplayable;
import gui.card.CardController;
import gui.card.Card;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

public class CardPanel extends JPanel implements CardController {

    private final GridBagConstraints gbc = new GridBagConstraints();
    private final CardPanelController cpc;

    public CardPanel(CardPanelController cpc) {
        super();
        super.setLayout(new GridBagLayout());
        this.cpc = cpc;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
    }

    public void addCard(CardData cardData, int rows, Button button) {
        this.add(
                new Card(this, cardData.getLabelOne(), cardData.getLabelTwo(), rows, button),
                gbc
        );
    }

}