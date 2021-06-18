package gui.body;

import controller.JobController;
import controller.NavigationController;

import javax.swing.*;

public class Button extends JButton {

    public NavigationController navigationController;
    public JobController jobController;
    private String property;

    public Button() {
        this.navigationController = null;
        this.property = "Default";
        this.setText("Default");
    }

    public Button(String text, NavigationController navigationController) {
        this.property = "Default";
        this.navigationController = navigationController;
        this.setText(text);
    }

    public Button(String text, JobController jobController) {
        this.property = "Default";
        this.jobController = jobController;
        this.setText(text);
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }
}
