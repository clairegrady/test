package data;

import application.Job;
import application.JobSeeker;
import application.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataStore {

    private static final DataStore datastore = new DataStore();

    private final ItemStore<User> users;
    private final ItemStore<Job> jobs;

    private DataStore() {
        this.users = new ItemStore<>(DataType.USER.getFilePath());
        this.jobs = new ItemStore<>(DataType.JOB.getFilePath());
    }

    public static DataStore getDatastore() {
        return datastore;
    }

    public List<Job> getJobs() {
        return this.jobs.getAll();
    }

    public List<User> getUsers() {
        return users.getAll();
    }

    public List<JobSeeker> getJobSeekers() {
        return users.getAll().stream().filter(x -> x instanceof JobSeeker).map(JobSeeker.class::cast).collect(Collectors.toList());
    }

    public Optional<Job> getJobById(String uniqueId) {
        return jobs.getByUniqueId(uniqueId);
    }

    public Optional<JobSeeker> getJobSeekerById(String uniqueId) {
        Optional<User> u = users.getByUniqueId(uniqueId);

        Optional<JobSeeker> js = Optional.empty();

        if (u.isPresent()) {
            js = Optional.ofNullable(u.get() instanceof JobSeeker ? (JobSeeker) u.get() : null);
        }

        return js;

    }

    public Optional<User> getUserById(String uniqueId) {
        return users.getByUniqueId(uniqueId);
    }

    public void updateJob(Job job) {
        jobs.updateItem(job);
    }

    public void updateUser(User user) {
        users.updateItem(user);
    }

    public void saveUsers() {
        users.saveData();
    }

    public void saveJobs() {
        jobs.saveData();
    }

    public void load() {

    }

}

