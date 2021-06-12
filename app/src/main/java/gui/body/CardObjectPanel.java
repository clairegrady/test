package gui.body;

import controller.CardViewController;

import javax.swing.*;
import java.awt.*;

public class CardObjectPanel extends JPanel {

    String text;
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
//    CardViewController cvc;

//    public CardObjectPanel(String text, CardViewController cvc) {
//        super();
//        super.setLayout(gbl);
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
//        gbc.insets = new Insets(2, 2, 2, 2);
////        this.cvc = cvc;
//
//        for (int index = 0; index < 100; index++) {
//            DefaultCard card = new DefaultCard(text, cvc);
//            this.add(card, gbc);
//        }
//    }

    public CardObjectPanel(String text, String text2, String buttonText, int listLength, String listIndex, CardViewController cvc, int rows) {
        super();
        super.setLayout(gbl);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
//        this.cvc = cvc;

        for (int index = 0; index < listLength; index++) {
            String cardLabel = text + " " + index;
            gui.card.DefaultCard card = new gui.card.DefaultCard(cardLabel, text2, buttonText, index, listIndex + "[ " + index + "]", cvc, rows);
            this.add(card, gbc);
        }


        /* We need to implement the logic to figure out which cards to display and for them to be able to generate different states further along.
         * this is probably going to be big job :|
         */
    }
}