package controller;

import application.*;
import data.DataStore;
import data.KeywordType;
import gui.body.SeekerProfileBody;
import jss.DummyData;

import java.util.ArrayList;
import java.util.Optional;

public class UserController {

    private NavigationController navigationController;
    private String authenticatedUserID;
    private String profileUserID;
    private String userType;

    public UserController(NavigationController navigationController) {
        this.navigationController = navigationController;
        this.authenticatedUserID = "*@example.com";
        this.userType = "LOGGEDOUT";
        new DummyData();
    }

    public String getProfileUserName() {
        Optional<User> user = DataStore.getDatastore().getUserById(this.profileUserID);
        return user.orElseThrow().getFirstName() + user.get().getLastName();
    }

    public void sendInvitation(String message) {
        JobInteraction ji = new JobInvitation(navigationController.getJobController().getCurrentJob(), message);
        Optional<User> user = DataStore.getDatastore().getUserById(this.profileUserID);
        user.orElseThrow().addJobInteraction(ji);
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

    public void addJobListing(JobListing jobListing) {
        User u = DataStore.getDatastore().getUserById(authenticatedUserID).get();

        u.addJobInteraction(jobListing);
    }

    public void setUserType() {
        Optional<User> user = DataStore.getDatastore().getUserById(authenticatedUserID);

        try {
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

    public ArrayList<String> getLoggedInUserDetails() {
        ArrayList<String> details = new ArrayList<>();

        details.add(0, "");
        details.add(1, "");
        details.add(2, "");
        details.add(3, "");
        details.add(4, "");
        details.add(5, "");
        details.add(6, "");

        Optional<User> user = DataStore.getDatastore().getUserById(authenticatedUserID);
        try {
            JobSeeker jobSeeker = (JobSeeker) user.orElseThrow();
            details.set(0, jobSeeker.getEmail());
            details.set(1, jobSeeker.getPassword());
            details.set(2, jobSeeker.getFirstName());
            details.set(3, jobSeeker.getLastName());
            details.set(4, jobSeeker.getPersonalSummary());
            details.set(5, jobSeeker.getQualifications());
            details.set(6, jobSeeker.getExperience());
        } catch (Exception e) {
            System.out.println("User Error");
        }
        return details;
    }

    public void chooseAccount() {
        navigationController.setBody("CHOOSE");
    }

    // TODO: determine where this method lives and move it?
    public void createRecruiter(String email, String password, String firstName, String lastName, String company) {
        Recruiter recruiter = new Recruiter(email, password, firstName, lastName, company);
        DataStore.getDatastore().updateUser(recruiter);
    }

    public void setPersonalDetailsPaneInformation(SeekerProfileBody seekerProfileBody) {
        Optional<User> user = DataStore.getDatastore().getUserById(authenticatedUserID);
        JobSeeker jobSeeker = (JobSeeker) user.orElseThrow();
        seekerProfileBody.addPersonalDetials(
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getEmail(),
                jobSeeker.getPersonalSummary(),
                jobSeeker.getExperience(),
                jobSeeker.getKeywordsListForType(KeywordType.SKILL),
                jobSeeker.getKeywordsListForType(KeywordType.QUALIFICATION),
                jobSeeker.getKeywordsListForType(KeywordType.LOCATION),
                jobSeeker.getKeywordsListForType(KeywordType.EDUCATION)
        );

    }

    public void setSeekerProfileInformation(SeekerProfileBody seekerProfileBody) {
        Optional<User> user = DataStore.getDatastore().getUserById(profileUserID);
        JobSeeker jobSeeker = (JobSeeker) user.orElseThrow();
        seekerProfileBody.addPersonalDetials(
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getEmail(),
                jobSeeker.getPersonalSummary(),
                jobSeeker.getExperience(),
                jobSeeker.getKeywordsListForType(KeywordType.SKILL),
                jobSeeker.getKeywordsListForType(KeywordType.QUALIFICATION),
                jobSeeker.getKeywordsListForType(KeywordType.LOCATION),
                jobSeeker.getKeywordsListForType(KeywordType.EDUCATION)
        );

    }

    public void createSeeker(String email, String password, String firstName, String lastName) {
        JobSeeker seeker = new JobSeeker(email, password, firstName, lastName);
        DataStore.getDatastore().updateUser(seeker);
    }

    public JobSeeker getJobSeekerById(String id) {
        Optional<JobSeeker> jobSeeker = DataStore.getDatastore().getJobSeekerById(id);
//TODO: error handling for null val
        return jobSeeker.get();

    }

    public void setProfileUser(String id) {
        profileUserID = id;
    }
}
