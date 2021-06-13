package gui;

import controller.HeaderViewController;
import gui.header.HeaderPane;

import javax.swing.*;
import java.awt.*;

public class MainHeaderPane extends JPanel {

    private HeaderViewController hvc;

    public MainHeaderPane(HeaderViewController hvc) {
        super();
        this.hvc = hvc;

        this.setLayout(new CardLayout());
        this.add(new HeaderPane(true, "Job Seeker System"), "JOBSEEKER");
        this.add(new HeaderPane(true, "Job Seeker System - Recruiter"), "RECRUITER");
        this.add(new HeaderPane(false, "Job Seeker System"), "LOGIN");
        this.add(new HeaderPane(true, "NEED TO INSERT GETJOBNAME() METHOD AND STATUS"), "JOBMANAGER");
        this.add(new HeaderPane(true, "Create / Edit Job Ad"), "EDITJOB");
        this.setHeader("LOGIN");
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