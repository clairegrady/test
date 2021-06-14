package gui.body.searchBar;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class DetailsSavePane extends JPanel {

    Dimension searchBarSize = new Dimension(800,40);
    BodyViewController bvc;

    public DetailsSavePane(BodyViewController bvc, String seekerFirstName, String seekerLastName) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));

        JPanel leftPanel = new JPanel();
        JLabel textLabel = new JLabel();
        textLabel.setText(seekerFirstName + " " + seekerLastName);
        leftPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 15, 5, 15), -1, -1));
        leftPanel.add(textLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "BVC METHOD TO setJobSeekerDetails() AND TO LAUNCH SEEKER DETAILS MAIN PANEL");
        });
        JButton discardButton = new JButton("Discard Changes");
        discardButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "BVC METHOD TO LAUNCH SEEKER DETAILS MAIN PANEL");
        });
        rightPanel.add(discardButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rightPanel.add(saveButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.add(leftPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
        this.add(rightPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

    }
}