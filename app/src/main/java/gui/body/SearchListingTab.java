package gui.body;


import application.*;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.JobSearchPane;
import gui.card.CardDisplayable;
import search.Search;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchListingTab extends Tab implements CardPanelController, JobSearchPaneController {

    private TabController tc;
    private BodyViewController bvc;
    private CardPanel cpo;
    private JobStatus jobStatus;
    private JobSearchPane jsp;
    private List<CardDisplayable> results;

    public SearchListingTab() {
        super();
    }

    public SearchListingTab(BodyViewController bvc, JobStatus jobStatus, JPanel searchBar) {
        super();
        this.bvc = bvc;
        this.jobStatus = jobStatus;
        this.results = new ArrayList<>();

        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(searchBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }

    public SearchListingTab(BodyViewController bvc, JobStatus jobStatus) {
        super();
        this.bvc = bvc;
        this.jobStatus = jobStatus;

        this.jsp = new JobSearchPane(this);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.jsp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void display() {
        cpo.displayCards(this.results);
    }

    public List<CardDisplayable> getCardPanelData() {

        String userId = bvc.getLoggedInUser();

        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);
        List<CardDisplayable> jiList = new ArrayList<>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji instanceof JobListing && ji.getStatus()== this.jobStatus)
                    .collect(Collectors.toList());
        }

        return jiList;

    }

    public Button getCardButton(String id) {
        Button button = new Button("View", bvc);
        button.setProperty("blah");
        button.setText("View");
        button.addActionListener(ae -> {
            button.getBvc().setBody("JOBMANAGER", id);
        });
        return button;
    }

    public void searchData(String text) {
        List<CardDisplayable> jobList = new ArrayList<>(Search.jobDescriptionSearch(text));
        this.results = jobList;
        display();

    }
}
