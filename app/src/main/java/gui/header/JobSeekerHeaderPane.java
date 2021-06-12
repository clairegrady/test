package gui.header;

import controller.HeaderViewController;

import javax.swing.*;

public class JobSeekerHeaderPane extends JPanel {

    private HeaderViewController hvc;

    public JobSeekerHeaderPane(HeaderViewController hvc) {

        super();
        this.hvc = hvc;
        JLabel Seeker = new JLabel("Job Seeker");
//        Seeker.setHorizontalAlignment(JLabel.RIGHT);
        this.add(Seeker);

    }
}