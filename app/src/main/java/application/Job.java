package application;

import data.EmploymentType;
import data.KeywordType;
import data.Storable;
import gui.card.CardData;
import gui.card.CardDisplayable;
import search.Searchable;
import utility.UniqueId;

import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Job implements Storable, Searchable, CardDisplayable {

    @Override
    public CardData getCardData() {
        return new CardData(this.getTitle(), this.getCompany());
    }

    @Override
    public String getCardDisplayUniqueId() {
        return uniqueId;
    }

    private final String uniqueId = UniqueId.generate();
    private String title;
    private Map<KeywordType, List<String>> jobKeywords;
    private EmploymentType employmentType;
    private String description;
    private int payCeiling;
    private int payFloor;
    private String company;
    private int uid;
    private int dateCreated;
    private int advertised;
    private Map<String, Integer > matchingScore; // Had to make both K and V a string so my linter
    // would stop yelling at me, not sure why?

    public Job() {
        this.title = "title";
        this.jobKeywords = new HashMap<>();
        this.employmentType = EmploymentType.NULL;
        this.description = "description";
        this.payCeiling = -1;
        this.payFloor = -1;
        this.company = "company";
        this.dateCreated = -1;
        this.advertised = -1;
        this.matchingScore = new HashMap<>();
    }

    public Job(String title, Map<KeywordType, List<String>> jobKeywords, EmploymentType employmentType,
               String description, int payCeiling, int payFloor, String company, int dateCreated,
               int advertised, Map<String, Integer> matchingScore) {
        this.title = title;
        this.jobKeywords = jobKeywords;
        this.employmentType = employmentType;
        this.description = description;
        this.payCeiling = payCeiling;
        this.payFloor = payFloor;
        this.company = company;
        this.dateCreated = dateCreated;
        this.advertised = advertised;
        this.matchingScore = matchingScore;
    }

    @Override
    public String getUniqueId() {
        return uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public Map<KeywordType, List<String>> getJobKeywords() {
        return jobKeywords;
    }

    @Override
    public List<String> getAllKeywordsList() {
        return this.jobKeywords.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<String> getKeywordsListForType(KeywordType type) {
        return this.jobKeywords.get(type);
    }

    public void addKeyword(KeywordType type, String val) {
        this.jobKeywords.get(type).add(val);
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

    public Map<String, Integer> getMatchingScore() {
        return matchingScore;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJobKeywords(Map<KeywordType, List<String>> jobKeywords) {
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

    public void setMatchingScore(Map<String, Integer> matchingScore) {
        this.matchingScore = matchingScore;
    }

    public void updateMatchingScore(String jobSeekerId, int matchingScore) {
        this.matchingScore.put(jobSeekerId, matchingScore);
    }

    @Override
    public String toString() {
        return "Job{" +
                "uniqueId='" + uniqueId + '\'' +
                ", title='" + title + '\'' +
                ", jobKeywords=" + jobKeywords +
                ", employmentType=" + employmentType +
                ", description='" + description + '\'' +
                ", payCeiling=" + payCeiling +
                ", payFloor=" + payFloor +
                ", company='" + company + '\'' +
                ", uid=" + uid +
                ", dateCreated=" + dateCreated +
                ", advertised=" + advertised +
                ", matchingScore=" + matchingScore +
                "}\n";
    }
}