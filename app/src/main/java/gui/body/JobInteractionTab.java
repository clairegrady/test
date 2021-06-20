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
import gui.modal.JobDetailsFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class JobInteractionTab extends Tab implements CardPanelController, AppSearchPaneController {

    protected NavigationController navigationController;
    protected UserController userController;
    protected JobController jobController;
    protected CardPanel cpo;
    protected AppSearchPane asp;
    protected List<CardDisplayable> cardPanelData;
    protected Predicate<JobInteraction> stringFilter;
    protected Predicate<JobInteraction> statusFilter;

    public JobInteractionTab() {
        super();
    }

    public JobInteractionTab(NavigationController navigationController, UserController userController, JobController jobController) {
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
        cpo.displayCards(this.cardPanelData);
    }

    public String getCardCenterLabel(String id) {
        return String.valueOf(jobController.getJobListingMatchScores(id).get(userController.getLoggedInUser()));
    }

    public abstract void displayWithFilter();

    public abstract void loadCardPanelData();

    public Button getCardButton(String id) {
        Button button = new Button("View", jobController);
        button.addActionListener(ae -> {
            button.jobController.setCurrentJob(id);
            new JobDetailsFrame(navigationController, jobController);
        });
        return button;
    }

    @Override
    public void filterEvents(String searchText, JobStatus status) {
        stringFilter = ji -> ji.getJob().getTitle().toLowerCase().contains(searchText.toLowerCase());

        if (status == JobStatus.NULL) {
            statusFilter = ji -> true;
        } else {
            statusFilter = ji -> ji.getStatus().equals(status);
        }

        displayWithFilter();
    }
}
