package application;

import java.util.List;
import java.util.HashMap;

public class Job {

    private List<Keyword> jobKeywords; 
    private EmploymentType employmentType;
    private String description;
    private int payCeiling;
    private int payFloor;
    private String company;
    private int uid;
    private int dateCreated;
    private int advertised;
    private HashMap<String, String > matchingScore; // Had to make both K and V a string so my linter would stop yelling at me, not sure why?

    public Job(List<Keyword> jobKeywords, EmploymentType employmentType, String description, int payCeiling, int payFloor, String company, int uid, int dateCreated, int advertised, HashMap<String, String> matchingScore) {
        this.jobKeywords = jobKeywords;
        this.employmentType = employmentType;
        this.description = description;
        this.payCeiling = payCeiling;
        this.payFloor = payFloor;
        this.company = company;
        this.uid = uid;
        this.dateCreated = dateCreated;
        this.advertised = advertised;
        this.matchingScore = matchingScore;
    }

    public List<Keyword> getJobKeywords() {
        return jobKeywords;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public String getDescription() {
        return description;
    }

    public int getPayCeiling() {
        return payCeiling;
    }

    public int getPayFloor() {
        return payFloor;
    }

    public String getCompany() {
        return company;
    }

    public int getUid() {
        return uid;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public int getAdvertised() {
        return advertised;
    }

    public HashMap<String, String> getMatchingScore() {
        return matchingScore;
    }

    public void setJobKeywords(List<Keyword> jobKeywords) {
        this.jobKeywords = jobKeywords;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayCeiling(int payCeiling) {
        this.payCeiling = payCeiling;
    }

    public void setPayFloor(int payFloor) {
        this.payFloor = payFloor;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setAdvertised(int advertised) {
        this.advertised = advertised;
    }

    public void setMatchingScore(HashMap<String, String> matchingScore) {
        this.matchingScore = matchingScore;
    }
}