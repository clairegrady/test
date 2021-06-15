package gui;

import controller.BodyViewController;
import gui.body.*;
import gui.body.progressView.CreateAccountScreen;
import gui.body.progressView.CreateJobForm;

import javax.swing.*;
import java.awt.*;

public class MainBodyPane extends JPanel {

    private BodyViewController bvc;


    public MainBodyPane(BodyViewController bvc) {

        super();
        this.bvc = bvc;
        this.setLayout(new CardLayout());
        this.setMinimumSize(new Dimension(800,800));
        this.add(new LoginPane(bvc, bvc.getMainFrame().getLC()), "LOGIN");
        this.add(new CreateAccountScreen(bvc), "CREATEACCOUNT");
        this.add(new CreateJobForm(bvc), "CREATEJOB"); // added
        this.add(new ChooseAccount(bvc), "CHOOSE");
        this.setBody("LOGIN");
    }

    public void createPanes() {
        this.add(new JobManagementBody(bvc), "JOBMANAGER");
        this.add(new RecruiterView(bvc), "RECRUITER");
        this.add(new JobSeekerView(bvc), "JOBSEEKER");

        this.setBody("LOGIN");
    }

    public void setBody(String body) {
        CardLayout bp = (CardLayout) (this.getLayout());
        bp.show(this, body);
    }
}