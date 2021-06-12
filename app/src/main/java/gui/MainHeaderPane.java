package gui;

import controller.HeaderViewController;
import gui.body.JobManagementPane;
import gui.header.HeaderButtonsPane;
import gui.header.JobSeekerHeaderPane;
import gui.header.LoggedOutHeaderPane;
import gui.header.RecruiterHeaderPane;

import javax.swing.*;
import java.awt.*;

public class MainHeaderPane extends JPanel {

    private HeaderViewController hvc;

    public MainHeaderPane(HeaderViewController hvc) {
        super();
        this.hvc = hvc;

        this.setLayout(new CardLayout());
        this.add(new HeaderButtonsPane(), "BUTTONS");
//        this.add(new RecruiterHeader(this.hvc.getMF(), "Brett"), "RECRUITER");
        this.add(new RecruiterHeaderPane(this.hvc), "RECRUITER");
        this.add(new JobSeekerHeaderPane(this.hvc), "JOBSEEKER");
        this.add(new LoggedOutHeaderPane(this.hvc), "LOGGEDOUT");
        this.add(new JobManagementPane(this.hvc), "JOBMANAGER");
        this.setHeader("BUTTONS");
    }

    public void setHeader(String header) {

        CardLayout hp = (CardLayout) (this.getLayout());
        hp.show(this, header);
    }

//        JLabel filler = new JLabel("Job Seeker System");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        this.setPreferredSize((new Dimension(800, 100)));
//        this.setLayout(new GridLayout(1, 1));
//        this.add(filler);

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }

}