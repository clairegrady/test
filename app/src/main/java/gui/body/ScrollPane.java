package gui.body;

import controller.BodyViewController;
import controller.CardViewController;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JPanel {

    BodyViewController bvc;
    CardViewController cvc;

    public ScrollPane(BodyViewController bvc, String getText, String getText2, String buttonDetails, int maxCards, String cardID, int rows) {

        super(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(new CardObjectPanel(getText, getText2, buttonDetails, maxCards, cardID, cvc, rows));
        SearchPane searchPane = new SearchPane(bvc);
        this.add(searchPane, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }
}