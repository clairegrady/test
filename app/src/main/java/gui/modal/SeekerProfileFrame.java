package gui.modal;

import controller.NavigationController;
import controller.UserController;
import gui.body.JobSeekerProfileModalPane;
import gui.body.SeekerProfileBody;

import javax.swing.*;
import java.awt.*;

public class SeekerProfileFrame extends JFrame {

    private final NavigationController navigationController;
    private final UserController userController;
    private final SeekerProfileBody jobSeekerProfile;

    public SeekerProfileFrame(NavigationController navigationController, UserController userController) {
        super("Job Seeker Details");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setMinimumSize(new Dimension(900, 700));
            this.navigationController = navigationController;
            this.userController = userController;
            this.jobSeekerProfile = new JobSeekerProfileModalPane(navigationController,userController);
            this.add(jobSeekerProfile);
            this.pack();
            super.setLocationRelativeTo(null);
            super.setVisible(true);
        }

}