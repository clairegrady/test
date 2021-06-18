package gui.body.searchBar;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.NavigationController;

import javax.swing.*;
import java.awt.*;

public class DetailsEditPane extends JPanel {

    Dimension searchBarSize = new Dimension(800, 40);
    NavigationController navigationController;

    public DetailsEditPane(NavigationController navigationController) {//}, String seekerFirstName, String seekerLastName) {
        super();
        this.navigationController = navigationController;
        this.setPreferredSize(searchBarSize);
        this.setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));

        JPanel leftPanel = new JPanel();
        JLabel textLabel = new JLabel();
        textLabel.setText("Seeker Name");//seekerFirstName + " " + seekerLastName);
        leftPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 15, 5, 15), -1, -1));
        leftPanel.add(textLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 15, 5, 15), -1, -1));
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "navigationController METHOD TO LAUNCH EDIT DETAILS MAIN PANEL");
        });
        rightPanel.add(editButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.add(leftPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
        this.add(rightPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

    }
}