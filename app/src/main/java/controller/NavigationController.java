package controller;

import data.DataStore;
import gui.MainFrame;
import gui.body.SeekerProfileBody;
import gui.modal.SeekerProfileFrame;

import javax.swing.*;
import java.io.Serializable;

public class NavigationController implements Serializable {

    MainFrame mainFrame;
    private UserController userController;

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

    public void displayProfileModal(String id) {
        System.out.println(DataStore.getDatastore().getUserById(id));
//        SeekerProfileFrame spf = new SeekerProfileFrame(this, userController);
//        spf.displayProfile(new SeekerProfileBody().createBody());
//        setBody("SEEKPROFILE");
    }

}