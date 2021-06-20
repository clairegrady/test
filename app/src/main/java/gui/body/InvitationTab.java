package gui.body;


import application.JobInteraction;
import application.JobInvitation;
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

public class InvitationTab extends Tab implements CardPanelController, AppSearchPaneController {

    private NavigationController navigationController;
    private UserController userController;
    private JobController jobController;
    private CardPanel cpo;
    private AppSearchPane asp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<JobInteraction> stringFilter;
    private Predicate<JobInteraction> statusFilter;

    public InvitationTab() {
        super();
    }

    public InvitationTab(NavigationController navigationController, UserController userController, JobController jobController) {
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

    public void loadCardPanelData() {

        String userId = userController.getLoggedInUser();

        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);
        List<CardDisplayable> jiList = new ArrayList<>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobInvitation && ji.getStatus() != JobStatus.DRAFT)
                    .collect(Collectors.toList());
        }

        this.cardPanelData = jiList;

    }

    public Button getCardButton(String id) {
        Button button = new Button("View", jobController);
        button.addActionListener(ae -> {
            button.jobController.setCurrentJob(id);
            new JobDetailsFrame(navigationController, jobController);
        });
        return button;
    }

    public void displayWithFilter() {
        cpo.displayCards(this.cardPanelData.stream()
                .filter(cd -> cd instanceof JobInteraction)
                .map(cd -> (JobInteraction) cd)
                .filter(this.stringFilter)
                .filter(this.statusFilter)
                .collect(Collectors.toList())
        );
    }

    public void filterEvents(String searchText, JobStatus status) {
        this.stringFilter = ji -> ji.getJob().toString().toLowerCase().contains(searchText.toLowerCase());

        if (status == JobStatus.NULL) {
            this.statusFilter = ji -> true;
        } else {
            this.statusFilter = ji -> ji.getStatus().equals(status);
        }

        displayWithFilter();
    }

}
