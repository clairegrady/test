package controller;

import gui.MainFrame;


public class BodyViewController {

    MainFrame mainFrame;

    public BodyViewController (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void loginComplete(Boolean loginComplete) {
        /*     fetch user data?
         *      do some validation?
         *      for now we are just going straight into a generic user
        */
        mainFrame.setBody("RECRUITER");
        mainFrame.setHeader("RECRUITER");

    }

    public void logOut(Boolean logoutRequested) {
        mainFrame.setBody("LOGIN");
        mainFrame.setHeader("LOGGEDOUT");
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }




}