import java.util.List;

public class DataStore {

    private List<User> users;
    private List<JobListing> jobs;
    private List<JobApplication> jobApplications;
    private List<JobInvitation> jobInvitations;
    
    
    public DataStore(List<User> users, List<JobListing> jobs, List<JobApplication> jobApplications,
            List<JobInvitation> jobInvitations) {
        this.users = users;
        this.jobs = jobs;
        this.jobApplications = jobApplications;
        this.jobInvitations = jobInvitations;
    }
    
    public List<User> getUsers() {
        return users;
    }

    public List<JobListing> getJobs() {
        return jobs;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public List<JobInvitation> getJobInvitations() {
        return jobInvitations;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setJobs(List<JobListing> jobs) {
        this.jobs = jobs;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public void setJobInvitations(List<JobInvitation> jobInvitations) {
        this.jobInvitations = jobInvitations;
    }

}
