package gui.body;

import controller.HeaderViewController;

import javax.swing.*;

public class JobManagementPane extends JPanel{

    private HeaderViewController hvc;

    public JobManagementPane(HeaderViewController hvc) {

        super();
        this.hvc = hvc;
        JLabel Seeker = new JLabel("Sweet Dev Job");
//        Seeker.setHorizontalAlignment(JLabel.RIGHT);
        this.add(Seeker);

    }
}
