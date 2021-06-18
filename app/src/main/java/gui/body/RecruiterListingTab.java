package gui.body;


import application.JobInteraction;
import application.JobListing;
import application.JobStatus;
import application.User;
import controller.NavigationController;
import controller.UserController;
import data.DataStore;
import gui.body.searchBar.RecruiterFilterPaneController;
import gui.body.searchBar.RecruiterListingFilterPane;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RecruiterListingTab extends Tab implements CardPanelController, RecruiterFilterPaneController {

    private TabController tc;
    private NavigationController navigationController;
    private UserController userController;
    private CardPanel cpo;
    private JobStatus jobStatus;
    private RecruiterListingFilterPane rfp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<JobInteraction> stringFilter;
    private Predicate<JobInteraction> statusFilter;

    public RecruiterListingTab() {
        super();
    }

    public RecruiterListingTab(NavigationController navigationController, UserController userController, JobStatus jobStatus) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.jobStatus = jobStatus;

        this.rfp = new RecruiterListingFilterPane(this, 1, jobStatus);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.rfp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void display() {
        cpo.displayCards();
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

        this.rfp.setNumJobs(jiList.size());

        return jiList;

    }

    public Button getCardButton(String id) {
//        Button button = new Button("View", navigationController);
//        button.setProperty("blah");
//        button.setText("View");
//        button.addActionListener(ae -> {
//            button.getNavigationController().setBody("JOBMANAGER", id);
//        });
//        return button;
        return new Button();
    }

    @Override
    public void navigate() {
        navigationController.setBody("CREATEJOB");
    }

}
