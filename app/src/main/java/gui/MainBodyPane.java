package gui;

import controller.BodyViewController;
import gui.body.LoginPane;
import gui.body.RecruiterView;
import gui.body.TabbedPaneView;
import gui.body.progressView.CreateAccountScreen;

import javax.swing.*;
import java.awt.*;

public class MainBodyPane extends JPanel {

    private BodyViewController bvc;

    public MainBodyPane(BodyViewController bvc) {

        super();
        this.setLayout(new CardLayout());
        this.add(new LoginPane(bvc, bvc.getMainFrame().getLC()), "LOGIN");
        this.add(new TabbedPaneView(bvc), "JOBMANAGER");
        this.add(new RecruiterView(bvc), "RECRUITER");
        this.add(new CreateAccountScreen(bvc), "CREATEACCOUNT");
        this.setBody("CREATEACCOUNT");
    }

    public void setBody(String body) {
        CardLayout bp = (CardLayout) (this.getLayout());
        bp.show(this, body);
    }
}