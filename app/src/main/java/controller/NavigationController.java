package controller;

import gui.MainFrame;

import java.io.Serializable;

public class NavigationController implements Serializable {

    MainFrame mainFrame;

    public NavigationController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void loginComplete(String userType) {
        /*     fetch user data?
         *      do some validation?
         *      for now we are just going straight into a generic user
         */
        mainFrame.createPanes();
        mainFrame.setBody(userType);
        mainFrame.setHeader(userType);

    }

    public void setBody(String body) {
        mainFrame.setBody(body);
    }

    public void setHeader(String header) {
        mainFrame.setHeader(header);
    }

    public void logout() {
        mainFrame.setBody("LOGIN");
        mainFrame.setHeader("LOGIN");
    }

}