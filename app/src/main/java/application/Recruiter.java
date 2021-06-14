package application;

import java.util.ArrayList;
import java.util.List;

public class Recruiter extends User {

    private String company;

    public Recruiter() {
        super("Default", "Default", "Default", "Default", new ArrayList<>());
        this.company = "Default";
    }

    public Recruiter(String email, String password, String firstName, String lastName, String company) {
        super(email, password, firstName, lastName, new ArrayList<>());
        this.company = company;
    }

    public Recruiter(String email, String password, String firstName, String lastName,
            List<JobInteraction> jobInteractions, String company) {
        super(email, password, firstName, lastName, jobInteractions);
        this.company = company;
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                super.toString() +
                ", company='" + company + '\'' +
                '}';
    }

}