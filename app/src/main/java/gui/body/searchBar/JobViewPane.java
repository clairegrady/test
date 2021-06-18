package gui.body.searchBar;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class JobViewPane extends JPanel {

    private Dimension searchBarSize = new Dimension(700,45);
    protected BodyViewController bvc;
    protected JPanel centrePanel;
    private JLabel jobCreatedOnText;
    private JButton homeButton;

    public JobViewPane(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.homeButton = new JButton("Home");
        this.centrePanel = new JPanel();
        this.add(centrePanel);
        String createdDate = "";
        this.jobCreatedOnText = new JLabel("Job Created on: " + createdDate);
        this.homeButton.addActionListener(e -> bvc.loginComplete("RECRUITER"));
        this.centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.LINE_AXIS));
        this.centrePanel.setPreferredSize(searchBarSize);
        this.centrePanel.setBorder(BorderFactory.createEmptyBorder(7,0,15,0));
        this.centrePanel.add(jobCreatedOnText);
        this.centrePanel.add(Box.createHorizontalGlue());
        this.centrePanel.add(homeButton);
        this.homeButton.addActionListener(e -> bvc.createJob());
    }

    public String dateToString(int numDate) {
        String strDate = "" + numDate;
        String year = strDate.substring(0,4);
        String month = strDate.substring(4,6);
        String day = strDate.substring(6);
        String finalDate = day + "/" + month + "/" + year;

        return finalDate;
    }
    
}