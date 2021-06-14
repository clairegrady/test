package gui.body;

import application.*;
import data.DataStore;
import gui.card.Card;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Optional;

public class ScrollPane<T extends CardDisplayable> extends JPanel implements CardPanelController<T> {

    ScrollPaneController spc;
    JScrollPane scrollPane;
    CardPanel cpo;
    T type;

    public ScrollPane(ScrollPaneController spc, JPanel searchBar) {

        super(new BorderLayout());
        this.spc = spc;
        this.cpo = new CardPanel(this);
        this.scrollPane = new JScrollPane(cpo);
        this.add(searchBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }

    public void display(String pane) {
        getCardPanelObjects(pane);
    }

    public void getCardPanelObjects(String pane) {

        cpo.removeAll();

        List<? extends CardDisplayable> list = spc.getScrollPaneData(pane);

        for (CardDisplayable cardDisplayable : list) {
            cpo.addCard(
                    cardDisplayable.getCardData(),
                    list.size(),
                    spc.getCardButton()
            );
        }

    }

}
