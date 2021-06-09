package application;

import java.util.ArrayList;
import java.util.List;

public class JobSeeker extends User {

    private String personalSummary;
    private String qualifications;
    private String experience;
    private List<Keyword> seekerKeywords;

    public JobSeeker() {
        super("Default", "Default", "Default", "Default", new ArrayList<>());
        this.personalSummary = "Default";
        this.qualifications = "Default";
        this.experience = "Default";
        this.seekerKeywords = new ArrayList<>();
    }

    public JobSeeker(String email, String password, String firstName, String lastName,
            List<JobInteraction> jobInteractions, String personalSummary, String qualifications, String experience,
            List<Keyword> seekerKeywords) {
        super(email, password, firstName, lastName, jobInteractions);
        this.personalSummary = personalSummary;
        this.qualifications = qualifications;
        this.experience = experience;
        this.seekerKeywords = seekerKeywords;
    }

    public String getPersonalSummary() {
        return personalSummary;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getExperience() {
        return experience;
    }

    public List<Keyword> getSeekerKeywords() {
        return seekerKeywords;
    }

    public void setPersonalSummary(String personalSummary) {
        this.personalSummary = personalSummary;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setSeekerKeywords(List<Keyword> seekerKeywords) {
        this.seekerKeywords = seekerKeywords;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                super.toString()  +
                ", personalSummary='" + personalSummary + '\'' +
                ", qualifications='" + qualifications + '\'' +
                ", experience='" + experience + '\'' +
                ", seekerKeywords=" + seekerKeywords +
                '}';
    }
}