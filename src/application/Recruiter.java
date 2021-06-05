package application;

import java.util.List;

public class Recruiter extends User {

    private String company;

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

}