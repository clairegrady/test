package data;

import application.User;
import application.Job;

import java.util.*;

public class DataStore {

    private final ItemStore<User> users;
    private final ItemStore<Job> jobs;


    public DataStore() {
        this.users =  new ItemStore<>(DataType.USER.getFilePath());
        this.jobs = new ItemStore<>(DataType.JOB.getFilePath());
    }

    public List<Job> getJobs() {
        return jobs.getAll();
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

}

