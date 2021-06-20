package gui.body;


import application.Job;
import application.JobInteraction;
import application.JobInvitation;
import controller.NavigationController;
import data.DataStore;
import data.MatchScore;
import gui.body.searchBar.SeekerFilterPane;
import gui.body.searchBar.SeekerFilterPaneController;
import gui.card.Card;
import gui.card.CardDisplayable;
import gui.modal.SeekerProfileFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InviteesTab extends Tab implements CardPanelController, SeekerFilterPaneController {

    private NavigationController navigationController;
    private CardPanel cpo;
    private SeekerFilterPane sfp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<Card> stringFilter;
    private Predicate<Card> statusFilter;

    private Job job;

    public InviteesTab() {
        super();
    }

    public InviteesTab(NavigationController navigationController, Job job) {
        super();
        this.job = job;
        this.navigationController = navigationController;
        this.stringFilter = ji -> true;
        this.statusFilter = ji -> true;

        this.sfp = new SeekerFilterPane(this);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.sfp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        display();
    }

    public void display() {
        loadCardPanelData();
        cpo.displayCards(cardPanelData);
    }

    public void displayWithFilter() {
        cpo.applyPredicate(stringFilter.and(statusFilter));
    }

    public void loadCardPanelData() {

        List<CardDisplayable> jiList = new ArrayList<>();

        if (!Objects.isNull(this.job)) {
            jiList = DataStore.getDatastore().getJobSeekers()
                    .stream()
                    .filter(js -> js.getJobInteractions()
                            .stream()
                            .anyMatch(ji -> ji.getJob().equals(this.job) && ji instanceof JobInvitation))
                    .collect(Collectors.toList());
        }

        this.cardPanelData = jiList;

    }

    public Button getCardButton(String id) {
        Button button = new Button("profile", navigationController.getUserController());
        button.addActionListener(ae -> {
            button.userController.setProfileUser(id);
            new SeekerProfileFrame(navigationController, navigationController.getUserController());
        });
        return button;
    }

    public void filterEvents(String searchText, String matchingScore) {

        if (searchText.equals("")) {
            stringFilter = card -> true;
        } else {
            this.stringFilter =
                    card -> card.getMainLabel().toLowerCase().contains(searchText.toLowerCase())
                            || card.getSecondaryLabel().toLowerCase().contains(searchText.toLowerCase());
        }

        this.statusFilter =
                card -> Integer.parseInt(card.getCenterLabel()) >= MatchScore.getEnum(matchingScore).getValue();

        displayWithFilter();
    }

    public String getCardCenterLabel(String id) {
        return String.valueOf(job.getMatchingScore().get(id));
    }

    public void navigate() {
       this.navigationController.setBody("RECRUITER");
    }
}
