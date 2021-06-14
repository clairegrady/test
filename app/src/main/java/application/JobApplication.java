package application;

public class JobApplication extends JobInteraction {

    private int dateApplied;

    public JobApplication(JobStatus status, Job job, int dateApplied) {
        super(status, job);
        this.dateApplied = dateApplied;
    }

    public int getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(int dateApplied) {
        this.dateApplied = dateApplied;
    }
}