package controller;

import application.Job;
import data.DataStore;
import data.KeywordType;

import java.awt.*;
import java.util.Map;

public class JobController {

    private Job currentJob;

    public JobController() {

    }

    public void createNewJob(String jobTitle, Map<KeywordType, List> keywordMap, String employmentType, String description, int salaryCeiling, int salaryFloor, String companyName, String status) {
        System.out.println(companyName + " has a new job named " + jobTitle + " which been created. The job is " + employmentType + " with a pay range of " + salaryFloor + " to " + salaryCeiling + ". This job will be " + status);
    }

    // TODO: lives in job controller most likely
    public void setBody(String body, String id) {

        DataStore.getDatastore().getJobById(id).ifPresent(this::setCurrentJob);

//        mainFrame.setBody(body, id);

    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }
}
