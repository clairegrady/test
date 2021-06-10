package controller;

import gui.MainFrame;


public class BodyViewController {

    MainFrame mainFrame;

    public BodyViewController (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void loginComplete(Boolean loginComplete) {
        mainFrame.setBody("RECRUITER");
    }

    public void logOut(Boolean logoutRequested) {
        mainFrame.setBody("LOGIN");
    }

    public MainFrame getMF() {
        return mainFrame;
    }




}