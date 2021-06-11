package application;

import data.KeywordType;
import search.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class JobSeeker extends User implements Searchable {

    private String personalSummary;
    private String qualifications;
    private String experience;
    private Map<KeywordType, List<String>> seekerKeywords;

    public JobSeeker() {
        super("Default", "Default", "Default", "Default", new ArrayList<>());
        this.personalSummary = "Default";
        this.qualifications = "Default";
        this.experience = "Default";
        this.seekerKeywords = new HashMap<>();
    }

    public JobSeeker(String email, String password, String firstName, String lastName,
            List<JobInteraction> jobInteractions, String personalSummary, String qualifications,
                     String experience, Map<KeywordType, List<String>> seekerKeywords) {
        super(email, password, firstName, lastName, jobInteractions);
        this.personalSummary = personalSummary;
        this.qualifications = qualifications;
        this.experience = experience;
        this.seekerKeywords = seekerKeywords;
    }

    @Override
    public List<String> getAllKeywordsList() {
        return this.seekerKeywords.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<String> getKeywordsListForType(KeywordType type) {
        return this.seekerKeywords.get(type);
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

    public Map<KeywordType, List<String>> getSeekerKeywords() {
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

    public void setSeekerKeywords(Map<KeywordType, List<String>> seekerKeywords) {
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