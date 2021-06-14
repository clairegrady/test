package gui.card;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import gui.body.Button;
import gui.body.ButtonController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;

/**
 * The default card is used for displaying jobs the recruiter posted and searching cards for job seekers.
 */
public class Card extends JPanel implements ButtonController {

    public CardController cardController;

    private static final GridConstraints CARD_CONSTRAINTS = new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false);

    private static final GridConstraints CONTENT_CONSTRAINTS = new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false);

    private static final GridConstraints CONTENT_2_CONSTRAINTS = new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null,
            0, false);

    private static final Insets CARD_INSETS = new Insets(5, 15, 5, 15);

    private static final GridConstraints BUTTON_CONSTRAINTS = new GridConstraints(0, 0, 2, 1,
            GridConstraints.ANCHOR_EAST,
            GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false);

    private static final GridLayoutManager CARD_LAYOUT = new GridLayoutManager(3, 1, CARD_INSETS,
            -1, -1);

    public Card(CardController cardController, String text, String text2, int rows, Button button) {
        super();
        formatView();

        this.cardController = cardController;

        JPanel card = makeCard(rows, text, text2, button);

        this.add(card);
        this.add(card, CARD_CONSTRAINTS);
    }

    public JPanel makeCard(int rows, String labelText, String text2, Button button){
        JPanel card = new JPanel();
        card.setLayout(CARD_LAYOUT);
        card.setBackground(Color.WHITE);

        // content 1
        JLabel content = new JLabel();
        content.setText(labelText);
        content.setHorizontalAlignment(JLabel.CENTER);
        card.add(content, CONTENT_CONSTRAINTS);

        // content 2
        JLabel content2 = new JLabel();
        content2.setText(text2);
        content2.setHorizontalAlignment(JLabel.CENTER);
        card.add(content2,CONTENT_2_CONSTRAINTS);

        card.add(button, BUTTON_CONSTRAINTS);

        return card;
    }

    public void formatView() {
        this.setLayout(new GridLayout(1, 1));
        this.setPreferredSize((new Dimension(700, 100)));
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(8, 8, 8, 8));
    }
}