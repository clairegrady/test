package gui;


import controller.HeaderViewController;

import javax.swing.*;
import java.awt.*;

public class LoggedOutHeaderPane extends HeaderPane {

    private HeaderViewController hvc;

    public LoggedOutHeaderPane(HeaderViewController hvc) {
        super(hvc);
        this.hvc = hvc;
        JLabel loggedOut = new JLabel("Welcome");
        loggedOut.setHorizontalAlignment(JLabel.CENTER);
        this.add(loggedOut);
    }


    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }
}