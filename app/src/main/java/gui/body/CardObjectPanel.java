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

    public CardObjectPanel(String text, CardViewController cvc) {
        super();
        super.setLayout(gbl);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
//        this.cvc = cvc;

        for (int index = 0; index < 100; index++) {
            String jobName = text + " " + index;
            gui.card.RecruiterCard card = new gui.card.RecruiterCard(jobName, index, cvc);
            this.add(card, gbc);
        }
    }


    /* We need to implement the logic to figure out which cards to display and for them to be able to generate different states further along.
     * this is probably going to be big job :|
     */
}