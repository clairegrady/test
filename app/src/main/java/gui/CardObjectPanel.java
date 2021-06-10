package gui;

import controller.CardViewController;

import javax.swing.*;
import java.awt.*;

public class CardObjectPanel extends JPanel {
    
    String text;
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
//    CardViewController cvc;
    
    public CardObjectPanel(String text, CardViewController cvc) {
        super();
        super.setLayout(gbl);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
//        this.cvc = cvc;
        
        for (int index = 0; index < 100; index++) {
            DefaultCard card = new DefaultCard(text, cvc);
            this.add(card, gbc);
        }
    }
}