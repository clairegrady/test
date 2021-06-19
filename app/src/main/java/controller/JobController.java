package controller;

import application.Job;
import application.JobListing;
import application.JobStatus;
import data.DataStore;
import data.EmploymentType;
import data.KeywordType;

import java.util.List;
import java.util.Map;

public class JobController {

    private NavigationController navigationController;
    private UserController userController;
    private Job currentJob;

    public JobController(NavigationController navigationController, UserController userController) {
        this.navigationController = navigationController;
        this.userController = userController;
    }

    public void createNewJob(String jobTitle, Map<KeywordType, List<String>> keywordMap, String employmentType, String description, int salaryCeiling, int salaryFloor, String companyName, String status) {

        Job newJob = new Job(
                jobTitle,
                keywordMap,
                EmploymentType.getEnum(employmentType),
                description,
                salaryCeiling,
                salaryFloor,
                companyName
        );

        JobListing listing = new JobListing(
                JobStatus.getEnum(status),
                newJob
        );

        userController.addJobListing(listing);

        newJob.updateMatches();

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
