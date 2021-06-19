package controller;

import application.Job;
import application.JobListing;
import application.User;
import data.DataStore;
import data.EmploymentType;
import data.JobStatus;
import data.KeywordType;
import gui.body.JobDetailsPane;

import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobController {

    private NavigationController navigationController;
    private UserController userController;
    private Job currentJob;
    private JobListing currentJobListing;

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
    }

    public void setBody(String body, String id) {
        DataStore.getDatastore().getJobById(id).ifPresent(this::setCurrentJob);
        navigationController.setBody(body);
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        System.out.println(currentJob);
        this.currentJob = currentJob;
        this.currentJobListing = getJobListingByJobId(this.currentJob.getUniqueId());
        System.out.println(currentJobListing);

    }

    public void setCurrentJob(String id) {
        System.out.println(id);
        this.currentJob = DataStore.getDatastore().getJobById(id).orElseThrow();
    }

    public String getJobListingPublishDate() {
        return formatJobListingDate(currentJobListing.getPublishDate());
    }

    public Map<String, Integer> getJobListingMatchScores(String id) {
        return DataStore.getDatastore().getJobById(id).get().getMatchingScore();
    }

    public void setJobDetailsPaneInformation(JobDetailsPane jobDetailsPane) {
        jobDetailsPane.addJobDetails(
                currentJob.getTitle(),
                currentJob.getCompany(),
                currentJob.getDescription(),
                String.join(", ", currentJob.getKeywordsListForType(KeywordType.CATEGORY)),
                currentJob.getEmploymentType().toString(),
                formatJobPayValue(currentJob.getPayFloor()),
                formatJobPayValue(currentJob.getPayCeiling()),
                currentJob.getKeywordsListForType(KeywordType.LOCATION),
                currentJob.getKeywordsListForType(KeywordType.SKILL),
                Stream.of(currentJob.getKeywordsListForType(KeywordType.EDUCATION),
                        currentJob.getKeywordsListForType(KeywordType.QUALIFICATION))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
        );
    }

    public void setViewLastUpdatedDate(JobDetailsPane jobDetailsPane) {
        jobDetailsPane.setLastUpdatedDate(formatJobListingDate(currentJobListing.getLastUpdated()));
    }

    public String formatJobListingDate(long dateLong) {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date(dateLong));
    }

    public String formatJobPayValue(int payValue) {
        return NumberFormat.getCurrencyInstance().format(payValue).replace(".00", "");
    }

    public String getJobListingStatus() {
        return currentJobListing.getStatus().toString();
    }

    public Color getStatusColour() {
        switch (currentJobListing.getStatus()) {
            case ACTIVE -> {
                return Color.GREEN;
            }
            case DRAFT -> {
                return Color.ORANGE;
            }
            case CLOSED -> {
                return Color.RED;
            }
            default -> {
                return Color.BLACK;
            }
        }
    }

    public void updateJobListingStatus(JobDetailsPane jobDetailsPane, String status) {
        currentJobListing.updateJobListingStatus(status);
        jobDetailsPane.updateCurrentStatus(status, getStatusColour());
    }

    public JobListing getJobListingByJobId(String id) {

        Optional<User> u = DataStore.getDatastore().getUserById(userController.getLoggedInUser());
        Optional<JobListing> jl = Optional.empty();
        if (u.isPresent()) {
            jl = u.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobListing && ji.getJob().getUniqueId().equals(id))
                    .findFirst()
                    .map(ji -> (JobListing) ji);
        }

        assert jl.isPresent();
        return jl.get();

    }
}
