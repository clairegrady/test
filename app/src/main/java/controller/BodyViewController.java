package controller;

import gui.MainFrame;

import javax.swing.*;


public class BodyViewController {

    MainFrame mainFrame;

    public BodyViewController (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void loginComplete(String userType) {
        /*     fetch user data?
         *      do some validation?
         *      for now we are just going straight into a generic user
        */
        mainFrame.setBody(userType);
        mainFrame.setHeader(userType);

    }

    public void logOut(Boolean logoutRequested) {
        mainFrame.setBody("LOGIN");
        mainFrame.setHeader("LOGGEDOUT");
    }

    public void createJob(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Test of Create Job");
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }




}