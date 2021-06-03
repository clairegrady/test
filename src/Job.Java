import java.util.List;

public class Job {

    private List<Keyword> jobKeywords; 
    private EmploymentType employmentType;
    private String description;
    private int payCeiling;
    private int payFloor;
    private String company;
    private int uid;
    private int creationDate;
    private int advertised;
    private HashMap<String, int> matchingScore;
    
    
    public Job(List<Keyword> jobKeywords, EmploymentType employmentType, String description, int payCeiling,
            int payFloor, String company, int uid, int creationDate, int advertised) {
        this.jobKeywords = jobKeywords;
        this.employmentType = employmentType;
        this.description = description;
        this.payCeiling = payCeiling;
        this.payFloor = payFloor;
        this.company = company;
        this.uid = uid;
        this.creationDate = creationDate;
        this.advertised = advertised;
    }
    
    
}