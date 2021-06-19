package application;

import data.JobStatus;

public class JobListing extends JobInteraction {

//    private int closeDate;
    private long publishDate;
    private final long dateCreated = System.currentTimeMillis();
    private long lastUpdated;


    public JobListing(JobStatus status, Job job) {
        super(status, job);
        if (status == JobStatus.ACTIVE) {
            this.publishDate = System.currentTimeMillis();
            this.lastUpdated = System.currentTimeMillis();
        } else {
            this.publishDate = -1;
            this.lastUpdated = -1;
        }
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public void setLastUpdated(long lastUpdated) { this.lastUpdated = lastUpdated; }

    public long getLastUpdated() {
        return this.lastUpdated;
    }

    public long getDateCreated() {
        return this.dateCreated;
    }

    public void updateJobListingStatus(String status) {
        updateJobListingStatus(JobStatus.getEnum(status));
    }

    public void updateJobListingStatus(JobStatus status) {
        if (status.equals(JobStatus.ACTIVE)) {
            setPublishDate(System.currentTimeMillis());
        }
        setStatus(status);
        setLastUpdated(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "JobListing{" +
                super.toString() +
                ", publishDate=" + publishDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

