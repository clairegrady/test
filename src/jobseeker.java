public class JobSeeker extends User {

    private String personalSummary;
    private String qualifications;
    private String experience;
    private List<Keyword> seekerKeywords;

    public JobSeeker() {
        this.personalSummary = "";
        this.qualifications = "";
        this.experience = "";
        this.seekerKeywords = new List<>;
    }

    public JobSeeker(String personalSummary, String qualifications, String experience, List<Keyword> seekerKeywords) {
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

    public List<keywords> getSeekerKeywords() {
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

    public void setSeekerKeywords(List<keywords> seekerKeywords) {
        this.seekerKeywords = seekerKeywords;
    }
}