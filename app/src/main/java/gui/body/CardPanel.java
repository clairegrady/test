package gui.body;

import gui.card.Card;
import gui.card.CardData;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CardPanel extends JPanel {

    private final GridBagConstraints gbc = new GridBagConstraints();
    private final CardPanelController cardPanelController;
    private List<Card> cards = new ArrayList<>();

    public CardPanel(CardPanelController cardPanelController) {
        super();
        super.setLayout(new GridBagLayout());
        this.cardPanelController = cardPanelController;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);
    }

    public void displayCards(List<CardDisplayable> cards) {
        clearCardPanel();
        this.cards = new ArrayList<>();
        for (CardDisplayable card : cards) {
            CardData cd = card.getCardData();
            addCard(
                    cd.getMainLabel(),
                    cd.getSecondaryLabel(),
                    cardPanelController.getCardCenterLabel(cd.getItemUniqueId()),
                    cardPanelController.getCardButton(card.getCardDisplayUniqueId())
            );
        }
    }

    public void displayFilteredCards(List<Card> cards) {
        clearCardPanel();
        for (Card card : cards) {
            add(card,gbc);
        }
    }

    public void applyPredicate(Predicate<Card> pred) {
        clearCardPanel();
        List<Card> filteredCards = cards.stream()
                .filter(pred)
                .collect(Collectors.toList());

        for (Card card : filteredCards) {
            addCard(card);
        }

    }

    public void clearCardPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    public void addCard(String mainLabel, String secondaryLabel, String centerLabel, Button button) {
        Card card = new Card(mainLabel, secondaryLabel, centerLabel, button);
        this.add(card, gbc);
        this.cards.add(card);
    }

    public void addCard(Card card) {
        this.add(card, gbc);
    }

    public List<Card> getCards() {
        return cards;
    }
}