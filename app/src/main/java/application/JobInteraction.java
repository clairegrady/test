package application;

import java.io.Serializable;

public class JobInteraction implements Serializable {

    private String status;
    private Job job;
    private String id;

    public JobInteraction(String status, Job job, String id) {
        this.status = status;
        this.job = job;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public Job getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setId(String id) {
        this.id = id;
    }
}