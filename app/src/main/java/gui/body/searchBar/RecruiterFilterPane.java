package gui.body.searchBar;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class RecruiterFilterPane extends JPanel {

    Dimension searchBarSize = new Dimension(700,45);
    protected BodyViewController bvc;
    protected JPanel centrePanel;
    private JLabel jobNumDisplay;
    private JButton createJobButton;

    public RecruiterFilterPane(BodyViewController bvc, int numJobs, String status) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.LINE_AXIS));
        centrePanel.setPreferredSize(new Dimension(700,45));
        centrePanel.setBorder(BorderFactory.createEmptyBorder(7,0,15,0));
        this.createJobButton = new JButton("Create Job");
        String pluralJob = numJobs != 1 ? "jobs" : "job";
        this.jobNumDisplay = new JLabel(String.format("You have %d %s %s.", numJobs, status, pluralJob));
        centrePanel.add(jobNumDisplay);
        centrePanel.add(Box.createHorizontalGlue());
        centrePanel.add(createJobButton);
        createJobButton.addActionListener(e -> bvc.createJob());
        this.add(centrePanel);
    }
}