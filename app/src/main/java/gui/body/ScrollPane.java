package gui.body;

import controller.BodyViewController;
import controller.CardViewController;
import gui.body.searchBar.SearchPane;
import gui.body.searchBar.RecruiterFilterPane;

import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JPanel {

    BodyViewController bvc;
    CardViewController cvc;

    public ScrollPane(BodyViewController bvc, JPanel searchBar,String getText, String getText2, String buttonDetails, int maxCards, String cardID, int rows) {

        super(new BorderLayout());
        this.bvc = bvc;
        this.cvc = new CardViewController(bvc.getMainFrame());
        JScrollPane scrollPane = new JScrollPane(new CardObjectPanel(getText, getText2, buttonDetails, maxCards, cardID, cvc, rows));
        this.add(searchBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }
}