package gui.body;


import application.*;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.*;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

public class UserTab extends Tab implements CardPanelController, SeekerFilterPaneController {

    private BodyViewController bvc;
    private CardPanel cpo;
    private SeekerFilterPane sfp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<JobInteraction> stringFilter;
    private Predicate<JobInteraction> statusFilter;

    private Job job;

    public UserTab() {
        super();
    }

    public UserTab(BodyViewController bvc, Job job) {
        super();
        this.job = job;
        this.bvc = bvc;
        this.stringFilter = ji -> true;
        this.statusFilter = ji -> true;

        this.sfp = new SeekerFilterPane(this);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.sfp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }
    public void display() {
        cpo.displayCards();
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

    public List<CardDisplayable> getCardPanelData() {

        List<CardDisplayable> jiList = new ArrayList<>();

        if (!Objects.isNull(this.job)) {
            jiList = new ArrayList<>(DataStore.getDatastore().getJobSeekers());
        }

        this.cardPanelData = jiList;

        return jiList;
    }

    public Button getCardButton(String id) {
        return new Button();
    }

    public void filterEvents(String searchText, int matchingScore) {
//        this.stringFilter = ji -> ji.getJob().getTitle().toLowerCase().contains(searchText.toLowerCase());
//
//        if (status == JobStatus.NULL) {
//            this.statusFilter = ji -> true;
//        } else {
//            this.statusFilter =  ji -> ji.getStatus().equals(status);
//        }
//
//        displayWithFilter();
    }
}
