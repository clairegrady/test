package application;

public class JobListing extends JobInteraction {

//    private int closeDate;
    private long publishDate;
    private final long dateCreated = System.currentTimeMillis();


    public JobListing(JobStatus status, Job job) {
        super(status, job);
        switch (status) {
            case ACTIVE -> {
                this.publishDate = System.currentTimeMillis();
            }
        }
        this.publishDate = status.equals(JobStatus.ACTIVE) ? System.currentTimeMillis() : -1;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "JobListing{" +
                super.toString() +
                ", publishDate=" + publishDate +
                '}';
    }
}

