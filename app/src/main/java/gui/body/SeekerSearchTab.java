package gui.body;


import application.Job;
import controller.NavigationController;
import data.DataStore;
import gui.body.searchBar.UserCardTab;
import gui.card.CardDisplayable;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class SeekerSearchTab extends UserCardTab {

    public SeekerSearchTab() {
        super();
    }

    public SeekerSearchTab(NavigationController navigationController, Job job) {
        super(navigationController, job);
    }

    @Override
    public void loadCardPanelData() {

        List<CardDisplayable> jiList = new ArrayList<>();

        if (!Objects.isNull(this.job)) {
            jiList = this.job.getMatchingScore()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(e -> DataStore.getDatastore().getJobSeekerById(e.getKey()).get())
                    .collect(Collectors.toList());
        }

        this.cardPanelData = jiList;

    }

}
