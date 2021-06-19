package gui.card;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import gui.body.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The default card is used for displaying jobs the recruiter posted and searching cards for job seekers.
 */
public class Card extends JPanel {

    private static final GridConstraints CARD_CONSTRAINTS = new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false);

    private static final Insets CARD_INSETS = new Insets(5, 15, 5, 15);

    private static final GridLayoutManager CARD_LAYOUT = new GridLayoutManager(4, 4, CARD_INSETS,
            -1, -1);

    private static final GridConstraints MAIN_LABEL_CONSTRAINTS = new GridConstraints(0, 0, 2, 2,
            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false);

    private static final GridConstraints SECOND_LABEL_CONSTRAINTS = new GridConstraints(2, 0, 1, 2,
            GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
            0, false);

    private static final GridConstraints CENTER_LABEL_CONSTRAINTS = new GridConstraints(0, 2, 4, 1,
            GridConstraints.ANCHOR_EAST, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
            0, false);

    private static final GridConstraints BUTTON_CONSTRAINTS = new GridConstraints(0, 3, 4, 1,
            GridConstraints.ANCHOR_EAST,
            GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false);

    public CardController cardController;

    public Card(CardController cardController, String text, String text2, int rows, Button button) {
        super();
        formatView();

        this.cardController = cardController;

        JPanel card = makeCard(text, text2, "test", button);

        this.add(card);
        this.add(card, CARD_CONSTRAINTS);
    }

    public Card(String mainLabel, String secondaryLabel, String centerLabel, Button button) {
        super();
        formatView();

        JPanel card = makeCard(mainLabel, secondaryLabel, centerLabel, button);

        this.add(card);
        this.add(card, CARD_CONSTRAINTS);
    }

    public JPanel makeCard(String mainLabel, String secondaryLabel, String centerLabel, Button button) {
        JPanel card = new JPanel();
        card.setLayout(CARD_LAYOUT);
        card.setBackground(Color.WHITE);

        // content 1
        JLabel content = new JLabel();
        content.setText(mainLabel);
        content.setHorizontalAlignment(JLabel.LEFT);
        content.setFont(new Font(null, Font.BOLD, 18));
        card.add(content, MAIN_LABEL_CONSTRAINTS);

        // content 2
        JLabel content2 = new JLabel();
        content2.setText(secondaryLabel);
        content2.setFont(new Font(null, Font.PLAIN, 14));
        content2.setHorizontalAlignment(JLabel.LEFT);
        card.add(content2, SECOND_LABEL_CONSTRAINTS);

        // content 2
        JLabel content3 = new JLabel();
        content3.setText(centerLabel);
        content3.setFont(new Font(null, Font.ITALIC, 16));
        content3.setHorizontalAlignment(JLabel.RIGHT);
        card.add(content3, CENTER_LABEL_CONSTRAINTS);

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