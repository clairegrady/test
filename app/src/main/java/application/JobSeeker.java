package application;

import data.KeywordType;
import gui.card.CardData;
import gui.card.CardDisplayable;
import search.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class JobSeeker extends User implements Searchable, CardDisplayable {

    private String personalSummary;
    private String qualifications;
    private String experience;
    private Map<KeywordType, List<String>> seekerKeywords;

    public JobSeeker() {
        super("Default", "Default", "Default", "Default", new ArrayList<>());
        this.personalSummary = "Default";
        this.qualifications = "Default";
        this.experience = "Default";
        this.seekerKeywords = newKeywordMap();
    }

    public JobSeeker(String email, String password, String firstName, String lastName) {
        super(email, password, firstName, lastName, new ArrayList<>());
        this.personalSummary = "Default";
        this.qualifications = "Default";
        this.experience = "Default";
        this.seekerKeywords = newKeywordMap();

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

    public void addKeyword(KeywordType type, String val) {
        this.seekerKeywords.get(type).add(val);
    }


    public String getPersonalSummary() {
        return personalSummary;
    }

    public void setPersonalSummary(String personalSummary) {
        this.personalSummary = personalSummary;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Map<KeywordType, List<String>> getSeekerKeywords() {
        return seekerKeywords;
    }

    public void setSeekerKeywords(Map<KeywordType, List<String>> seekerKeywords) {
        this.seekerKeywords = seekerKeywords;
    }

    @Override
    public CardData getCardData() {
        return new CardData(getFirstName() + " " + getLastName(), " ", getEmail());
    }

    @Override
    public String getCardDisplayUniqueId() {
        return getEmail();
    }

    public static Map<KeywordType, List<String>> newKeywordMap() {
        Map<KeywordType, List<String>> kwMap = new HashMap<>();
        for (KeywordType type : KeywordType.values()) {
            kwMap.put(type, new ArrayList<>());
        }

        return kwMap;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                super.toString() +
                ", personalSummary='" + personalSummary + '\'' +
                ", qualifications='" + qualifications + '\'' +
                ", experience='" + experience + '\'' +
                ", seekerKeywords=" + seekerKeywords +
                '}';
    }
}