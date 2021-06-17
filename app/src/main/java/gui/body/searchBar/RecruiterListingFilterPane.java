package gui.body.searchBar;

import application.JobStatus;

import javax.swing.*;
import java.awt.*;

public class RecruiterListingFilterPane extends JPanel {

    Dimension searchBarSize = new Dimension(700,45);
    protected RecruiterFilterPaneController recruiterFilterPaneController;
    protected JPanel centrePanel;
    private JLabel jobNumDisplay;
    private JButton createJobButton;

    private int numJobs;
    private JobStatus status;

    public RecruiterListingFilterPane(RecruiterFilterPaneController recruiterFilterPaneController, int numJobs, JobStatus status) {
        super();
        this.recruiterFilterPaneController = recruiterFilterPaneController;
        this.numJobs = numJobs;
        this.status = status;
        this.jobNumDisplay = new JLabel();
        this.setPreferredSize(searchBarSize);
        this.centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.LINE_AXIS));
        centrePanel.setPreferredSize(new Dimension(700,45));

        centrePanel.setBorder(BorderFactory.createEmptyBorder(7,0,15,0));

        this.createJobButton = new JButton("Create Job");

        updatejobNumDisplay();


        centrePanel.add(jobNumDisplay);
        centrePanel.add(Box.createHorizontalGlue());
        centrePanel.add(createJobButton);
        createJobButton.addActionListener(e -> recruiterFilterPaneController.createJob());
        this.add(centrePanel);
    }

    public void setNumJobs(int numJobs) {
        this.numJobs = numJobs;
        updatejobNumDisplay();
    }

    public void updatejobNumDisplay() {
        this.jobNumDisplay.setText(
                String.format("You have %d %s %s."
                        , numJobs
                        , status
                        , (numJobs != 1 ? "jobs" : "job")
                )
        );

    }
}