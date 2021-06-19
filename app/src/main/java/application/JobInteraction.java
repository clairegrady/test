package application;

import data.JobStatus;
import gui.card.CardData;
import gui.card.CardDisplayable;
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

    public String getCardDisplayUniqueId() {
        return job.getUniqueId();
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getUniqueIdId() {
        return uniqueId;
    }

    @Override
    public CardData getCardData() {
        return job.getCardData();
    }

    @Override
    public String toString() {
        return "uniqueId='" + uniqueId + '\'' +
                ", status=" + status +
                ", job=" + job;
    }
}