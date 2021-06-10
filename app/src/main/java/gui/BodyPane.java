package gui;

import controller.BodyViewController;
import javax.swing.*;
import java.awt.*;

public class BodyPane extends JPanel {

    private BodyViewController bvc;

    public BodyPane(BodyViewController bvc) {

        super();
        this.setLayout(new CardLayout());
        this.add(new LoginPane(bvc), "LOGIN");
        this.add(new TabbedPaneView(bvc), "JOBMANAGER");
        this.add(new RecruiterView(bvc), "RECRUITER");
        this.setBody("LOGIN");
    }

    public void setBody(String body) {
        CardLayout bp = (CardLayout) (this.getLayout());
        bp.show(this, body);
    }
}