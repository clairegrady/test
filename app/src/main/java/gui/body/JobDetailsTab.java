package gui.body;

import controller.JobController;
import controller.NavigationController;
import gui.body.searchBar.JobViewPane;

import java.awt.*;

public class JobDetailsTab extends Tab {

    private final NavigationController navigationController;
    private final JobController jobController;

    public JobDetailsTab(NavigationController navigationController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.add(new JobViewPane(navigationController, jobController), BorderLayout.NORTH);
        this.add(new JobDetailsPane(navigationController, jobController), BorderLayout.CENTER);
    }




    @Override
    public void display() {

    }
}
