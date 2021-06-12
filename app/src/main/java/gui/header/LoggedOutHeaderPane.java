package gui.header;


import controller.HeaderViewController;

import javax.swing.*;

public class LoggedOutHeaderPane extends JPanel {

    private HeaderViewController hvc;

    public LoggedOutHeaderPane(HeaderViewController hvc) {
        super();
        this.hvc = hvc;
        JLabel loggedOut = new JLabel("Welcome");
//        loggedOut.setHorizontalAlignment(JLabel.EAST);
        this.add(loggedOut);
    }


//    @Override
//    public Component add(Component comp) {
//        return super.add(comp);
//    }
}