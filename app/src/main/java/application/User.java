package application;

import data.Storable;

import java.io.Serializable;
import java.util.List;

public class User implements Storable {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<JobInteraction> jobInteractions;

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String password, String firstName, String lastName, List<JobInteraction> jobInteractions) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobInteractions = jobInteractions;
    }

    @Override
    public String getUniqueId() {
        return getEmail();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<JobInteraction> getJobInteractions() {
        return jobInteractions;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJobInteractions(List<JobInteraction> jobInteractions) {
        this.jobInteractions = jobInteractions;
    }

    @Override
    public String toString() {
        return "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobInteractions=" + jobInteractions;
    }

}