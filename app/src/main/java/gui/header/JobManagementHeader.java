package gui.header;

import controller.HeaderViewController;

import javax.swing.*;

public class JobManagementHeader extends JPanel{

    private HeaderViewController hvc;

    public JobManagementHeader(HeaderViewController hvc) {

        super();
        this.hvc = hvc;
        JLabel Seeker = new JLabel("Sweet Dev Job");
//        Seeker.setHorizontalAlignment(JLabel.RIGHT);
        this.add(Seeker);

    }
}
