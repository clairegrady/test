package gui.body;


import application.JobListing;
import data.JobStatus;
import application.User;
import controller.JobController;
import controller.NavigationController;
import controller.UserController;
import data.JobCategory;
import data.DataStore;
import data.Location;
import data.Sal;
import gui.body.searchBar.JobSearchPane;
import gui.body.searchBar.JobSearchPaneController;
import gui.card.CardDisplayable;
import search.Search;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchListingTab extends Tab implements CardPanelController, JobSearchPaneController {

    private TabController tc;
    private NavigationController navigationController;
    private JobController jobController;
    private UserController userController;
    private CardPanel cpo;
    private JobStatus jobStatus;
    private JobSearchPane jsp;
    private List<CardDisplayable> results;

    public SearchListingTab() {
        super();
    }

    public SearchListingTab(NavigationController navigationController, JobController jobController, UserController userController, JobStatus jobStatus) {
        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.userController = userController;
        this.jobStatus = jobStatus;

        this.jsp = new JobSearchPane(this);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.jsp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void display() {
        cpo.displayCards(this.results);
    }

    public List<CardDisplayable> getCardPanelData() {

        String userId = userController.getLoggedInUser();

        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);
        List<CardDisplayable> jiList = new ArrayList<>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobListing && ji.getStatus() == this.jobStatus)
                    .collect(Collectors.toList());
        }

        return jiList;

    }

    public Button getCardButton(String id) {
//        Button button = new Button("View", jobController);
//        button.setProperty("blah");
//        button.setText("View");
        //TODO: set the button controller
//        button.addActionListener(ae -> {
//            button.getNavigationController().setBody("JOBMANAGER", id);
//        });
        return new Button();
    }

    public void searchData(String searchText, String category, String pay, String location) {

        this.results = new ArrayList<>(Search.searchJobs(
                searchText,
                JobCategory.getEnum(category),
                Sal.getEnum(pay),
                Location.getEnum(location)));
        display();

    }
}
