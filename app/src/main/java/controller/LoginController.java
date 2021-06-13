package controller;

import application.User;
import data.DataStore;
import gui.MainFrame;
import jss.DummyData;

import java.util.Optional;

public class LoginController {

    private MainFrame mainFrame;
    private String authenticatedUserID;
    private String userType;

    public LoginController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.authenticatedUserID = "*@example.com";
        this.userType = "LOGGEDOUT";
        new DummyData();
    }

    public boolean validateLogin(String email, String password) {

        Optional<User> user = DataStore.getDatastore().getUserById(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            authenticatedUserID = email;
            setUserType();
            System.out.println("Passed");
            return true;
        } else {
            System.out.println(email);
            System.out.println("Failed");
            return false;
        }
    }

    public void setUserType() {
        Optional<User> user = DataStore.getDatastore().getUserById(authenticatedUserID);

        try{
            if (user.orElseThrow().getClass().getName().equals("application.JobSeeker")) {
                System.out.println("JOBSEEKER" + "\n" + user.orElseThrow().getClass().getName().equals("application.JobSeeker"));
                userType = "JOBSEEKER";
            } else if (user.orElseThrow().getClass().getName().equals("application.Recruiter")) {
                System.out.println("RECRUITER" + "\n" + user.orElseThrow().getClass().getName().equals("application.Recruiter"));
                userType = "RECRUITER";
            } else {
                System.out.println(user.orElseThrow().getClass().getName());
            }
        } catch (java.util.NoSuchElementException noSuchElementException) {
            userType = "LOGIN";
        }
    }

    public String getUserType() {
        return userType;
    }

    public String getLoggedInUser() {
        return authenticatedUserID;
    }

    public void createAccount() {
        mainFrame.setBody("CREATEACCOUNT");
    }
}
