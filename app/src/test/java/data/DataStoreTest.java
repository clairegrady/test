package data;

import application.Job;
import application.JobSeeker;
import application.User;

import java.util.List;

public class DataStoreTest {

    public static void main(String[] args) {

        DataStore ds = new DataStore();

        ds.saveUsers();
        ds.saveJobs();

        List<Job> initJobs = ds.getJobs();
        List<User> initUser = ds.getUsers();

        System.out.println(initJobs);
        System.out.println(initUser);

        ds.updateUser(new JobSeeker());

        ds.saveUsers();

    }
}