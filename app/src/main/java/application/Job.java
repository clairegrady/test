package application;

import data.EmploymentType;
import data.KeywordType;
import data.Storable;
import gui.card.CardData;
import gui.card.CardDisplayable;
import search.Searchable;
import utility.UniqueId;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Job.
 */
public class Job implements Storable, Searchable, CardDisplayable {

    private final String uniqueId = UniqueId.generate();
    private String title;
    private Map<KeywordType, List<String>> jobKeywords;
    private EmploymentType employmentType;
    private String description;
    private int payCeiling;
    private int payFloor;
    private String company;
    private Map<String, Integer> matchingScore;

    /**
     * Instantiates a new Job.
     */
    public Job() {
        this.title = "title";
        this.jobKeywords = new HashMap<>();
        this.employmentType = EmploymentType.NULL;
        this.description = "description";
        this.payCeiling = -1;
        this.payFloor = -1;
        this.company = "company";
        this.matchingScore = new HashMap<>();
    }

    /**
     * Instantiates a new Job.
     *
     * @param title          the title
     * @param jobKeywords    the job keywords
     * @param employmentType the employment type
     * @param description    the description
     * @param payCeiling     the pay ceiling
     * @param payFloor       the pay floor
     * @param company        the company
     */
    public Job(String title, Map<KeywordType, List<String>> jobKeywords, EmploymentType employmentType,
               String description, int payCeiling, int payFloor, String company) {
        this.title = title;
        this.jobKeywords = jobKeywords;
        this.employmentType = employmentType;
        this.description = description;
        this.payCeiling = payCeiling;
        this.payFloor = payFloor;
        this.company = company;
        this.matchingScore = new HashMap<>();
    }

    /**
     * Instantiates a new Job.
     *
     * @param title          the title
     * @param jobKeywords    the job keywords
     * @param employmentType the employment type
     * @param description    the description
     * @param payCeiling     the pay ceiling
     * @param payFloor       the pay floor
     * @param company        the company
     * @param matchingScore  the matching score
     */
    public Job(String title, Map<KeywordType, List<String>> jobKeywords, EmploymentType employmentType,
               String description, int payCeiling, int payFloor, String company, Map<String, Integer> matchingScore) {
        this.title = title;
        this.jobKeywords = jobKeywords;
        this.employmentType = employmentType;
        this.description = description;
        this.payCeiling = payCeiling;
        this.payFloor = payFloor;
        this.company = company;
        this.matchingScore = matchingScore;
    }

    @Override
    public CardData getCardData() {
        return new CardData(this.title, this.company, this.uniqueId);
    }

    @Override
    public String getCardDisplayUniqueId() {
        return uniqueId;
    }

    @Override
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets job keywords.
     *
     * @return the job keywords
     */
    public Map<KeywordType, List<String>> getJobKeywords() {
        return jobKeywords;
    }

    /**
     * Sets job keywords.
     *
     * @param jobKeywords the job keywords
     */
    public void setJobKeywords(Map<KeywordType, List<String>> jobKeywords) {
        this.jobKeywords = jobKeywords;
    }

    @Override
    public List<String> getAllKeywordsList() {
        return this.jobKeywords.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<String> getKeywordsListForType(KeywordType type) {
        return this.jobKeywords.get(type);
    }

    /**
     * Add keyword.
     *
     * @param type the type
     * @param val  the val
     */
    public void addKeyword(KeywordType type, String val) {
        this.jobKeywords.get(type).add(val);
    }

    /**
     * Gets employment type.
     *
     * @return the employment type
     */
    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    /**
     * Sets employment type.
     *
     * @param employmentType the employment type
     */
    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets pay ceiling.
     *
     * @return the pay ceiling
     */
    public int getPayCeiling() {
        return payCeiling;
    }

    /**
     * Sets pay ceiling.
     *
     * @param payCeiling the pay ceiling
     */
    public void setPayCeiling(int payCeiling) {
        this.payCeiling = payCeiling;
    }

    /**
     * Gets pay floor.
     *
     * @return the pay floor
     */
    public int getPayFloor() {
        return payFloor;
    }

    /**
     * Sets pay floor.
     *
     * @param payFloor the pay floor
     */
    public void setPayFloor(int payFloor) {
        this.payFloor = payFloor;
    }

    /**
     * Gets company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets company.
     *
     * @param company the company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets matching score.
     *
     * @return the matching score
     */
    public Map<String, Integer> getMatchingScore() {
        return matchingScore;
    }

    /**
     * Sets matching score.
     *
     * @param matchingScore the matching score
     */
    public void setMatchingScore(Map<String, Integer> matchingScore) {
        this.matchingScore = matchingScore;
    }

    /**
     * Update matching score.
     *
     * @param jobSeekerId   the job seeker id
     * @param matchingScore the matching score
     */
    public void updateMatchingScore(String jobSeekerId, int matchingScore) {
        this.matchingScore.put(jobSeekerId, matchingScore);
    }

    /**
     * Update matches.
     */
    public void updateMatches() {
        Match.updateJobMatches(this);
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
                ", matchingScore=" + matchingScore +
                "}\n";
    }
}