package application;

import data.JobStatus;

public class JobInvitation extends JobInteraction {

    private String message;
    private long dateInvited = System.currentTimeMillis();

    public JobInvitation() {
        message = "Default";
    }

    public JobInvitation(Job job, String message) {
        super(JobStatus.ACTIVE, job);
        this.message = message;
    }

    public long getDateInvited() {
        return dateInvited;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}