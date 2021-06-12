package gui.body;

import controller.BodyViewController;
import controller.CardViewController;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JPanel {

    BodyViewController bvc;
    CardViewController cvc;

    public ScrollPane(String text, BodyViewController bvc) {

        super(new BorderLayout());
        this.bvc = bvc;
        cvc = new CardViewController(bvc.getMainFrame());
        JScrollPane scrollPane = new JScrollPane(new CardObjectPanel(text, cvc));
        SearchPane searchPane = new SearchPane(bvc);
        this.add(searchPane, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }
}