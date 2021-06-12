package gui.card;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.CardViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RecruiterCard extends JPanel {


    private CardViewController cvc;

    public RecruiterCard(String jobName, int i, CardViewController cvc) {
        super();
        this.cvc = cvc;
        JPanel cardPanel = new JPanel();
        this.add(cardPanel);
        cardPanel.setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));
        JLabel content = new JLabel();
        content.setText(jobName);
        cardPanel.setBackground(Color.WHITE);

        content.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(1, 1));
        this.setPreferredSize((new Dimension(700, 100)));
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(8, 8, 8, 8));
        this.add(content);
        JButton button = new JButton();
        button.setText("Details");
        button.addActionListener(ae -> {
            ae.getSource();
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of Job Number " + i);
        });
        this.add(button, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cardPanel.add(content, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cardPanel.add(button, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.add(cardPanel, new GridConstraints(i, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }
}