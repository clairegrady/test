package data;

import application.User;
import application.Job;

import java.util.List;
import java.util.Optional;

public class DataStore {

    private static final DataStore datastore = new DataStore();

    private final ItemStore<User> users;
    private final ItemStore<Job> jobs;

    private DataStore() {
        this.users = new ItemStore<>(DataType.USER.getFilePath());
        this.jobs = new ItemStore<>(DataType.JOB.getFilePath());
    }

    public List<Job> getJobs() {
        return this.jobs.getAll();
    }

    public static DataStore getDatastore() {
        return datastore;
    }

    public List<User> getUsers() {
        return users.getAll();
    }

    public Optional<Job> getJobById(String uniqueId) {
        return jobs.getByUniqueId(uniqueId);
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

