package gui;

import controller.HeaderViewController;

import javax.swing.*;
import java.awt.*;

public class HeaderPane extends JPanel {

    private HeaderViewController hvc;

    public HeaderPane(HeaderViewController hvc) {
        super();
        this.hvc = hvc;

        this.setLayout(new CardLayout());
        this.add(new HeaderButtonsPane(), "BUTTONS");
//        this.add(new RecruiterHeader(this.hvc.getMF(), "Brett"), "RECRUITER");
        this.add(new RecruiterHeaderPane(this.hvc), "RECRUITER");
        this.add(new JobSeekerHeaderPane(this.hvc), "JOBSEEKER");
        this.add(new LoggedOutHeaderPane(this.hvc), "LOGGEDOUT");
        this.add(new JobManagemntPane(this.hvc), "JOBMANAGER");
        this.setHeader("LOGGEDOUT");
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