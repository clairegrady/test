package application;

import utility.UniqueId;

import java.io.Serializable;

public class JobInteraction implements Serializable, CardDisplayable {

    private final String uniqueId = UniqueId.generate();
    private JobStatus status;
    private Job job;

    public JobInteraction() {
        this.status = JobStatus.NULL;
        this.job = new Job();
    }

    public JobInteraction(JobStatus status, Job job) {
        this.status = status;
        this.job = job;
    }

    public JobStatus getStatus() {
        return status;
    }

    public Job getJob() {
        return job;
    }

    public String getUniqueIdId() {
        return uniqueId;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public CardData getCardData() {
        return new CardData(this.job.getTitle(), this.job.getCompany());
    }

    @Override
    public String toString() {
        return "uniqueId='" + uniqueId + '\'' +
                ", status=" + status +
                ", job=" + job;
    }
}