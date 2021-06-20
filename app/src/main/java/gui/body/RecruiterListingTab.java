package gui.body;


import data.JobStatus;
import controller.JobController;
import controller.NavigationController;
import controller.UserController;
import gui.body.searchBar.RecruiterFilterPaneController;
import gui.body.searchBar.RecruiterListingFilterPane;

import java.awt.*;

public class RecruiterListingTab extends JobStatusTab implements RecruiterFilterPaneController {

    private RecruiterListingFilterPane recruiterViewFilterPane;

    public RecruiterListingTab() {
        super();
    }

    public RecruiterListingTab(NavigationController navigationController, UserController userController, JobController jobController, JobStatus jobStatus) {
        super(navigationController, userController, jobController, jobStatus);

        this.recruiterViewFilterPane = new RecruiterListingFilterPane(this, 1, jobStatus);
        this.add(this.recruiterViewFilterPane, BorderLayout.NORTH);

        display();
    }

    @Override
    public void display() {
        super.display();
        updateJobCount();
    }

    @Override
    public void navigate() {
        super.navigationController.setBody("CREATEJOB");
    }

    public void updateJobCount() {
        recruiterViewFilterPane.setNumJobs(cardPanelData.size());
    }

}
