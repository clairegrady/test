package gui.header;

import controller.HeaderViewController;

import javax.swing.*;

public class RecruiterHeaderPane extends JPanel {

    private HeaderViewController hvc;

    public RecruiterHeaderPane(HeaderViewController hvc) {

        super();
        this.hvc = hvc;
        JLabel Seeker = new JLabel("Recruiter");
//        Seeker.setHorizontalAlignment(JLabel.RIGHT);
        this.add(Seeker);

    }
}