package gui.body;


import application.*;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.*;
import gui.card.CardDisplayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RecruiterListingTab extends Tab implements CardPanelController, RecruiterFilterPaneController {

    private TabController tc;
    private BodyViewController bvc;
    private CardPanel cpo;
    private JobStatus jobStatus;
    private RecruiterListingFilterPane rfp;
    private List<CardDisplayable> cardPanelData;
    private Predicate<JobInteraction> stringFilter;
    private Predicate<JobInteraction> statusFilter;

    public RecruiterListingTab() {
        super();
    }

    public RecruiterListingTab(BodyViewController bvc, JobStatus jobStatus) {
        super();
        this.bvc = bvc;
        this.jobStatus = jobStatus;

        this.rfp = new RecruiterListingFilterPane(this, 1, jobStatus);
        this.cpo = new CardPanel(this);
        JScrollPane scrollPane = new JScrollPane(cpo);
        this.add(this.rfp, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void display() {
        cpo.displayCards();
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

        this.rfp.setNumJobs(jiList.size());

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

    @Override
    public void createJob() {
        bvc.createJob();
    }

}
