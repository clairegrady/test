package application;

public class JobInvitation extends JobInteraction {

    private String message;
    private int dateInvited;

    public JobInvitation() {
        message = "Default";
        dateInvited = -1;
    }

    public JobInvitation(JobStatus jobStatus, Job job, String message) {
        super(jobStatus, job);
        this.message = message;
        this.dateInvited = -1;
    }

    public int getDateInvited() {
        return dateInvited;
    }

    public void setDateInvited(int dateInvited) {
        this.dateInvited = dateInvited;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}