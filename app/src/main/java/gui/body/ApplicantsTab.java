package gui.body;


import application.Job;
import application.JobApplication;
import application.JobInteraction;
import controller.NavigationController;
import controller.UserController;
import data.DataStore;
import gui.body.searchBar.SeekerFilterPane;
import gui.body.searchBar.SeekerFilterPaneController;
import gui.card.CardDisplayable;
import gui.modal.SeekerProfileFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApplicantsTab extends Tab implements CardPanelController, SeekerFilterPaneController {

    private NavigationController navigationController;
    private UserController userController;
    private CardPanel cpo;
    private SeekerFilterPane sfp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<JobInteraction> stringFilter;
    private Predicate<JobInteraction> statusFilter;

    private Job job;

    public ApplicantsTab() {
        super();
    }

    public ApplicantsTab(NavigationController navigationController, Job job) {
        super();
        this.job = job;
        this.navigationController = navigationController;
        this.userController = navigationController.getUserController();
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
        cpo.displayCardsTest(cardPanelData);
    }

    public void displayWithFilter() {
//        cpo.displayCards(this.cardPanelData.stream()
//                .filter(cd -> cd instanceof JobInteraction)
//                .map(cd -> (JobInteraction) cd)
//                .filter(this.stringFilter)
//                .filter(this.statusFilter)
//                .collect(Collectors.toList())
//        );
    }

    public void loadCardPanelData() {

        List<CardDisplayable> jiList = new ArrayList<>();

        if (!Objects.isNull(this.job)) {
            jiList = DataStore.getDatastore().getJobSeekers()
                    .stream()
                    .filter(js -> js.getJobInteractions()
                            .stream()
                            .anyMatch(ji -> ji.getJob().equals(this.job) && ji instanceof JobApplication))
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

    public String getCardCenterLabel(String id) {
        return String.valueOf(job.getMatchingScore().get(id));
    }
}
