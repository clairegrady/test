package gui.body;

import application.JobListing;
import application.User;
import controller.JobController;
import controller.NavigationController;
import controller.UserController;
import data.DataStore;
import data.JobStatus;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JobCardTab extends Tab implements CardPanelController {

    protected NavigationController navigationController;
    protected UserController userController;
    protected JobController jobController;
    protected CardPanel cardPanel;
    protected JobStatus jobStatus;
    protected List<CardDisplayable> cardPanelData;

    public JobCardTab() {
        super();
    }

    public JobCardTab(NavigationController navigationController, UserController userController, JobController jobController, JobStatus jobStatus) {
        super();

        this.navigationController = navigationController;
        this.userController = userController;
        this.jobController= jobController;

        this.cardPanelData = new ArrayList<>();

        this.jobStatus = jobStatus;

        this.cardPanel = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        this.add(scrollPane, BorderLayout.CENTER);

    }

    @Override
    public void display() {
        loadCardPanelData();
        cardPanel.displayCardsTest(cardPanelData);
    }

    public void loadCardPanelData() {

        String userId = userController.getLoggedInUser();

        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);
        List<CardDisplayable> jiList = new ArrayList<>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobListing && ji.getStatus() == this.jobStatus)
                    .collect(Collectors.toList());
        }
        this.cardPanelData = jiList;
    }

    public gui.body.Button getCardButton(String id) {
        gui.body.Button button = new Button("View", jobController);
        button.addActionListener(ae -> {
            button.jobController.setBody("JOBMANAGER", id);
        });
        return button;
    }

    public String getCardCenterLabel(String id) {
        return "";
    }

}
