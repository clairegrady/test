package gui.body.searchBar;

import data.JobStatus;

public interface SeekerFilterPaneController {

    void filterEvents(String searchText, String matchingScore);
    void navigate();

}
