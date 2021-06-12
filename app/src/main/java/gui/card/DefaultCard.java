package gui.card;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.CardViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The default card is used for displaying jobs the recruiter posted and searching cards for job seekers.
 */
public class DefaultCard extends JPanel {


    CardViewController cvc;

    public static class ButtonProperty extends JButton{
        private String value;

        public String getProperty()
        {
            return this.value;
        }

        public void setProperty(String value)
        {
            this.value = value;
        }
    }

    public DefaultCard(String text, String text2, String buttonText, int i, String uid, CardViewController cvc, int rows) {
        super();
        this.cvc = cvc;
        this.setLayout(new GridLayout(1, 1));
        this.setPreferredSize((new Dimension(700, 100)));
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(8, 8, 8, 8));
        JPanel cardPanel;

        if (rows == 1){
            cardPanel = makeCardPanel(rows,1, text + " - " + text2, uid, buttonText, i);
        }
        else {
            cardPanel = makeCardPanel(rows,1, text, uid, buttonText, i);
            JLabel content2 = new JLabel();
            content2.setText(text2);
            content2.setHorizontalAlignment(JLabel.CENTER);
            cardPanel.add(content2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        }

        this.add(cardPanel);
        this.add(cardPanel, new GridConstraints(i, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    public JPanel makeCardPanel(int rows, int columns, String labelText, String uid, String buttonText, int i){
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayoutManager(rows, columns, new Insets(5, 15, 5, 15), -1, -1));
        cardPanel.setBackground(Color.WHITE);
        JLabel content = new JLabel();
        content.setText(labelText);
        content.setHorizontalAlignment(JLabel.CENTER);
        cardPanel.add(content, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonProperty button = new ButtonProperty();
        button.setProperty(uid);
        button.setText(buttonText);
        button.addActionListener(ae -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of Card Number " + i + ", " + button.getProperty());
        });
        cardPanel.add(button, new GridConstraints(0, columns - 1, rows, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        return cardPanel;
    }
}