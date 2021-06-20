package gui.body;


import data.JobStatus;
import controller.JobController;
import controller.NavigationController;
import controller.UserController;
import data.JobCategory;
import data.Location;
import data.Sal;
import gui.body.searchBar.JobSearchPane;
import gui.body.searchBar.JobSearchPaneController;
import gui.modal.JobDetailsFrame;
import search.Search;

import java.awt.*;
import java.util.ArrayList;

public class SearchListingTab extends JobStatusTab implements JobSearchPaneController {

    private JobSearchPane jobSearchPane;

    public SearchListingTab() {
        super();
    }

    public SearchListingTab(NavigationController navigationController, JobController jobController, UserController userController, JobStatus jobStatus) {
        super(navigationController, userController, jobController, jobStatus);

        this.jobSearchPane = new JobSearchPane(this);
        this.add(this.jobSearchPane, BorderLayout.NORTH);

    }

    @Override
    public void loadCardPanelData() {
    }


    @Override
    public String getCardCenterLabel(String id) {
        return String.valueOf(jobController.getJobListingMatchScores(id).get(userController.getLoggedInUser()));
    }

    public Button getCardButton(String id) {
        Button button = new Button("View", jobController);
        button.addActionListener(ae -> {
            button.jobController.setCurrentJob(id);
            new JobDetailsFrame(navigationController, jobController);
        });
        return button;
    }

    @Override
    public void searchData(String searchText, String category, String pay, String location) {
        this.cardPanelData = new ArrayList<>(Search.searchJobs(
                searchText,
                JobCategory.getEnum(category),
                Sal.getEnum(pay),
                Location.getEnum(location)));
        display();

    }
}
