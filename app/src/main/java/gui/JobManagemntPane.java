package gui;

import controller.HeaderViewController;

import javax.swing.*;

public class JobManagemntPane extends JPanel{

    private HeaderViewController hvc;

    public JobManagemntPane(HeaderViewController hvc) {

        super();
        this.hvc = hvc;
        JLabel Seeker = new JLabel("Sweet Dev Job");
//        Seeker.setHorizontalAlignment(JLabel.RIGHT);
        this.add(Seeker);

    }
}
