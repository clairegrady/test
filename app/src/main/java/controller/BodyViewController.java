package controller;

import application.Recruiter;
import data.DataStore;
import data.KeywordType;
import gui.MainFrame;

import java.io.Serializable;
import java.awt.*;
import java.util.Map;



public class BodyViewController implements Serializable {

    MainFrame mainFrame;

    public BodyViewController (MainFrame mainFrame) {
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

    public void logOut() {
        mainFrame.setBody("LOGIN");
        mainFrame.setHeader("LOGIN");
    }

    public void createJob(){
        mainFrame.setBody("CREATEJOB");
    }

    public static void createNewJob(String jobTitle, Map<KeywordType, List> keywordMap, String employmentType, String description, int salaryCeiling, int salaryFloor, String companyName, String status){
        System.out.println(companyName + " has a new job named " + jobTitle + " which been created. The job is " + employmentType + " with a pay range of " + salaryFloor + " to " + salaryCeiling + ". This job will be " + status);
    }


    public MainFrame getMainFrame() {
        return mainFrame;
    }

    // TODO: determine where this method lives and move it?
    public void createRecruiter(String email, String password, String firstName, String lastName, String company) {
        Recruiter recruiter = new Recruiter(email, password, firstName, lastName, company);
        DataStore.getDatastore().updateUser(recruiter);
    }

    public String getLoggedInUser() {
        return this.mainFrame.getLC().getLoggedInUser();
    }

    public void setBody(String body) {
        mainFrame.setBody(body);
    }

    public void setBody(String body, String id) {
        mainFrame.setBody(body, id);
    }

}