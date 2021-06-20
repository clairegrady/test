package gui.body.searchBar;

import application.Job;
import application.JobApplication;
import controller.NavigationController;
import controller.UserController;
import data.DataStore;
import data.MatchScore;
import gui.body.Button;
import gui.body.CardPanel;
import gui.body.CardPanelController;
import gui.body.Tab;
import gui.card.Card;
import gui.card.CardDisplayable;
import gui.modal.SeekerProfileFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.function.Predicate;

public abstract class UserCardTab extends Tab implements CardPanelController, SeekerFilterPaneController {

    protected NavigationController navigationController;
    protected UserController userController;
    protected CardPanel cardPanel;
    protected SeekerFilterPane sfp;
    protected List<CardDisplayable> cardPanelData;
    protected Predicate<Card> stringFilter;
    protected Predicate<Card> statusFilter;

    protected Job job;

    public UserCardTab() {
        super();
    }

    public UserCardTab(NavigationController navigationController, Job job) {
        super();
        this.job = job;
        this.navigationController = navigationController;
        this.userController = navigationController.getUserController();
        this.stringFilter = ji -> true;
        this.statusFilter = ji -> true;

        this.sfp = new SeekerFilterPane(this);
        this.cardPanel = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        this.add(this.sfp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        display();
    }

    public void display() {
        loadCardPanelData();
        cardPanel.displayCards(cardPanelData);
    }

    public void displayWithFilter() {
        cardPanel.applyPredicate(stringFilter.and(statusFilter));
    }

    public abstract void loadCardPanelData();

    public gui.body.Button getCardButton(String id) {
        gui.body.Button button = new Button("Profile", navigationController.getUserController());
        button.addActionListener(ae -> {
            button.userController.setProfileUser(id);
            new SeekerProfileFrame(navigationController, navigationController.getUserController());
        });
        return button;
    }

    public String getCardCenterLabel(String id) {
        return String.valueOf(job.getMatchingScore().get(id));
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

    public void navigate() {
        this.navigationController.setBody("RECRUITER");
    }

}
