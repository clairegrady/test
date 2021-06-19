package gui.body.searchBar;

import controller.JobController;
import controller.NavigationController;

import javax.swing.*;
import java.awt.*;

public class JobViewPane extends JPanel {

    protected NavigationController navigationController;
    private JobController jobController;
    protected JPanel centrePanel;
    private Dimension searchBarSize = new Dimension(700, 45);
    private JLabel jobCreatedOnText;
    private JButton homeButton;

    public JobViewPane(NavigationController navigationController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.setPreferredSize(searchBarSize);
        this.homeButton = new JButton("Home");
        this.centrePanel = new JPanel();
        this.add(centrePanel);
        String createdDate = "";
        this.jobCreatedOnText = new JLabel("Job Created on: " + jobController.getJobListingPublishDate());
        this.homeButton.addActionListener(e -> navigationController.loginComplete("RECRUITER"));
        this.centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.LINE_AXIS));
        this.centrePanel.setPreferredSize(searchBarSize);
        this.centrePanel.setBorder(BorderFactory.createEmptyBorder(7, 0, 15, 0));
        this.centrePanel.add(jobCreatedOnText);
        this.centrePanel.add(Box.createHorizontalGlue());
        this.centrePanel.add(homeButton);
        this.homeButton.addActionListener(e -> navigationController.setBody("CREATEJOB"));
    }

    public String dateToString(int numDate) {
        String strDate = "" + numDate;
        String year = strDate.substring(0, 4);
        String month = strDate.substring(4, 6);
        String day = strDate.substring(6);
        String finalDate = day + "/" + month + "/" + year;

        return finalDate;
    }

}