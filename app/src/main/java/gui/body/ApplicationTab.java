package gui.body;


import application.JobApplication;
import application.JobInteraction;
import controller.JobController;
import data.JobStatus;
import application.User;
import controller.NavigationController;
import controller.UserController;
import data.DataStore;
import gui.body.searchBar.AppSearchPane;
import gui.body.searchBar.AppSearchPaneController;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApplicationTab extends Tab implements CardPanelController, AppSearchPaneController {

    private NavigationController navigationController;
    private UserController userController;
    private JobController jobController;
    private CardPanel cpo;
    private AppSearchPane asp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<JobInteraction> stringFilter;
    private Predicate<JobInteraction> statusFilter;

    public ApplicationTab() {
        super();
    }

    public ApplicationTab(NavigationController navigationController, UserController userController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.jobController = jobController;
        this.stringFilter = ji -> true;
        this.statusFilter = ji -> true;

        this.asp = new AppSearchPane(this);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.asp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        display();

    }

    public void display() {
        loadCardPanelData();
        cpo.displayCardsTest(this.cardPanelData);
    }

    public String getCardCenterLabel(String id) {
        return String.valueOf(jobController.getJobListingMatchScores(id).get(userController.getLoggedInUser()));
    }

    public void displayWithFilter() {
        cpo.displayCardsTest(this.cardPanelData.stream()
                .filter(cd -> cd instanceof JobInteraction)
                .map(cd -> (JobInteraction) cd)
                .filter(this.stringFilter)
                .filter(this.statusFilter)
                .collect(Collectors.toList())
        );
    }

    public void loadCardPanelData() {
        String userId = userController.getLoggedInUser();

        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);
        List<CardDisplayable> jiList = new ArrayList<>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobApplication && ji.getStatus() != JobStatus.DRAFT)
                    .collect(Collectors.toList());
        }

        this.cardPanelData = jiList;

    }

    public gui.body.Button getCardButton(String id) {
        // TODO: set up the button controller
//        Button button = new Button("View", navigationController);
//        button.setProperty("blah");
//        button.setText("View");
//        button.addActionListener(ae -> {
//            button.getNavigationController().setBody("JOBMANAGER", id);
//        });
//
//        return button;
        return new Button();
    }

    public void filterEvents(String searchText, JobStatus status) {
        this.stringFilter = ji -> ji.getJob().getTitle().toLowerCase().contains(searchText.toLowerCase());

        if (status == JobStatus.NULL) {
            this.statusFilter = ji -> true;
        } else {
            this.statusFilter = ji -> ji.getStatus().equals(status);
        }

        displayWithFilter();
    }

}
