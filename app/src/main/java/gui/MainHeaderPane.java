package gui;

import controller.HeaderViewController;
import gui.header.HeaderPane;

import javax.swing.*;
import java.awt.*;

public class MainHeaderPane extends JPanel {

    private HeaderViewController hvc;

    public MainHeaderPane(HeaderViewController newHVC) {
        super();
        this.hvc = newHVC;
        this.setMinimumSize(new Dimension(800,100));
        this.setLayout(new CardLayout());
        this.add(new HeaderPane(hvc,false, "Job Seeker System"), "LOGIN");
        this.setHeader("LOGIN");
    }

    public void createPanes() {
        this.add(new HeaderPane(hvc,true, "Job Seeker System"), "JOBSEEKER");
        this.add(new HeaderPane(hvc,true, "Job Seeker System - Recruiter"), "RECRUITER");
        this.add(new HeaderPane(hvc,true, "NEED TO INSERT GETJOBNAME() METHOD AND STATUS"), "JOBMANAGER");
        this.add(new HeaderPane(hvc,true, "Create / Edit Job Ad"), "EDITJOB");
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