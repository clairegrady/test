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

public class InvitationTab extends JobInteractionTab {

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
        super(navigationController, userController, jobController);
        display();
    }

    @Override
    public void loadCardPanelData() {
        String userId = super.userController.getLoggedInUser();
        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);
        List<CardDisplayable> jiList = new ArrayList<>();
        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobInvitation && ji.getStatus() != JobStatus.DRAFT)
                    .collect(Collectors.toList());
        }
        super.cardPanelData = jiList;
    }

    @Override
    public void displayWithFilter() {
        cpo.displayCards(super.cardPanelData.stream()
                .filter(cd -> cd instanceof JobInteraction)
                .map(cd -> (JobInteraction) cd)
                .filter(super.stringFilter)
                .filter(super.statusFilter)
                .collect(Collectors.toList())
        );
    }

}
