package controller;

import application.Job;
import data.DataStore;
import data.KeywordType;

import java.awt.*;
import java.util.Map;

public class JobController {

    private NavigationController navigationController;
    private Job currentJob;

    public JobController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public void createNewJob(String jobTitle, Map<KeywordType, List> keywordMap, String employmentType, String description, int salaryCeiling, int salaryFloor, String companyName, String status) {
        System.out.println(companyName + " has a new job named " + jobTitle + " which been created. The job is " + employmentType + " with a pay range of " + salaryFloor + " to " + salaryCeiling + ". This job will be " + status);
    }

    // TODO: lives in job controller most likely
    public void setBody(String body, String id) {

        System.out.println(id);

        DataStore.getDatastore().getJobById(id).ifPresent(this::setCurrentJob);

        navigationController.setBody(body);

    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }
}
