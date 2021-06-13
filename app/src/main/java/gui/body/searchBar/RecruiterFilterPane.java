package gui.body.searchBar;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class RecruiterFilterPane extends JPanel {

    Dimension searchBarSize = new Dimension(800,40);
    BodyViewController bvc;

    public RecruiterFilterPane(BodyViewController bvc, int numJobs, String status) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));

        JPanel leftPanel = new JPanel();
        JLabel textLabel = new JLabel();

        if (numJobs == 1){
            textLabel.setText("You have " + numJobs + " " + status + " job.");
        }
        else {
            textLabel.setText("You have " + numJobs + " " + status + " jobs.");
        }

        leftPanel.add(textLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 15, 5, 15), -1, -1));
        JButton createJobButton = new JButton("Create Job");
        createJobButton.addActionListener(e -> bvc.createJob());
        rightPanel.add(createJobButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.add(leftPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
        this.add(rightPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

    }



}