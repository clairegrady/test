public class JobListing extends JobInteraction {

    private int closeDate;
    private int publishDate;

    public JobListing(int closeDate, int publishDate) {
        this.closeDate = closeDate;
        this.publishDate = publishDate;
    }

    public int getCloseDate() {
        return closeDate;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setCloseDate(int closeDate) {
        this.closeDate = closeDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }
}

