package gui.body;


import application.Job;
import application.JobApplication;
import controller.NavigationController;
import data.DataStore;
import gui.body.searchBar.UserCardTab;
import gui.card.CardDisplayable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ApplicantsTab extends UserCardTab {

    public ApplicantsTab() {
        super();
    }

    public ApplicantsTab(NavigationController navigationController, Job job) {
        super(navigationController, job);
    }

    @Override
    public void loadCardPanelData() {

        List<CardDisplayable> jiList = new ArrayList<>();

        if (!Objects.isNull(super.job)) {
            jiList = DataStore.getDatastore().getJobSeekers()
                    .stream()
                    .filter(js -> js.getJobInteractions()
                            .stream()
                            .anyMatch(ji -> ji.getJob().equals(super.job) && ji instanceof JobApplication))
                    .collect(Collectors.toList());
        }

        super.cardPanelData = jiList;

    }

}
