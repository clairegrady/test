package gui;

import controller.JobController;
import controller.NavigationController;
import controller.UserController;
import gui.body.*;
import gui.body.progressView.CreateAccountScreen;
import gui.body.progressView.CreateJobForm;
import gui.body.PersonalProfileTab;

import javax.swing.*;
import java.awt.*;

public class MainBodyPane extends JPanel {

    private NavigationController navigationController;
    private UserController userController;
    private JobController jobController;


    public MainBodyPane(NavigationController navigationController, UserController userController, JobController jobController) {

        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.userController = userController;
        this.setLayout(new CardLayout());
        this.setMinimumSize(new Dimension(800, 800));
        this.add(new LoginPane(navigationController, userController), "LOGIN");
        this.add(new CreateAccountScreen(navigationController, userController, true), "CREATEACCOUNT");
        this.add(new CreateAccountScreen(navigationController, userController, false), "CREATESEEKER");
        this.add(new CreateJobForm(navigationController,
                jobController), "CREATEJOB"); // added
        this.add(new ChooseAccount(navigationController), "CHOOSE");


        this.setBody("LOGIN");
    }

    public void createPanes() {
        if (userController.getUserType().equals("RECRUITER")) {
            this.add(new RecruiterView(navigationController, userController, jobController), "RECRUITER");
        } else {
            this.add(new JobSeekerView(navigationController, userController, jobController), "JOBSEEKER");
            this.add(new PersonalProfileTab(navigationController, userController), "SEEKPROFILE");
        }

        this.setBody("LOGIN");

    }

    public void setBody(String body) {
        if (body.equals("JOBMANAGER")) {
            this.add(new JobManagementView(navigationController, jobController), "JOBMANAGER");
        }
        CardLayout bp = (CardLayout) (this.getLayout());
        bp.show(this, body);
    }

}