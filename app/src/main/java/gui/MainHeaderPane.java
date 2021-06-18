package gui;

import controller.NavigationController;
import controller.UserController;
import gui.header.HeaderPane;

import javax.swing.*;
import java.awt.*;

public class MainHeaderPane extends JPanel {

    private final NavigationController navigationController;
    private final UserController userController;

    public MainHeaderPane(NavigationController navigationController, UserController userController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.setMinimumSize(new Dimension(800, 100));
        this.setLayout(new CardLayout());
        this.add(new HeaderPane(navigationController, userController, false, "Job Seeker System"), "LOGIN");
        this.setHeader("LOGIN");
    }

    public void createPanes() {
        this.add(new HeaderPane(navigationController, userController, true, "Job Seeker System"), "JOBSEEKER");
        this.add(new HeaderPane(navigationController, userController, true, "Job Seeker System - Recruiter"), "RECRUITER");
        this.add(new HeaderPane(navigationController, userController, true, "NEED TO INSERT GETJOBNAME() METHOD AND STATUS"), "JOBMANAGER");
        this.add(new HeaderPane(navigationController, userController, true, "Create / Edit Job Ad"), "EDITJOB");
    }

    public void setHeader(String header) {

        CardLayout hp = (CardLayout) (this.getLayout());
        hp.show(this, header);
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }

}