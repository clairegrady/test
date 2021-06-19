package gui.modal;


import controller.JobController;
import controller.NavigationController;
import gui.body.JobDetailsModalPane;

import javax.swing.*;
import java.awt.*;

public class JobDetailsFrame extends JFrame {

    private final NavigationController navigationController;
//    private final UserController userController;
    private final JobController jobController;
    private final JobDetailsModalPane jobDetails;

    public JobDetailsFrame(NavigationController navigationController, JobController jobController) {
        super("Job Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(900, 700));
        this.navigationController = navigationController;
        this.jobController = jobController;
        jobDetails = new JobDetailsModalPane(navigationController,jobController);
        this.add(jobDetails);
        this.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }


}