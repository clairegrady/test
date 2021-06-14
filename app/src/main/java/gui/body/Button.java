package gui.body;

import controller.BodyViewController;

import javax.swing.*;

public class Button extends JButton {

    private String property;
    public BodyViewController bvc;

    public Button() {
        this.bvc = null;
        this.property = "Default";
        this.setText("Default");
    }

    public Button(String text, BodyViewController bvc) {
        this.property = "Default";
        this.bvc = bvc;
        this.setText(text);
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public BodyViewController getBvc() {
        return bvc;
    }

    public void setBvc(BodyViewController bvc) {
        this.bvc = bvc;
    }
}
