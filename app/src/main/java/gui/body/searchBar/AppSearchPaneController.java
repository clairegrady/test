package gui.body.searchBar;

import data.JobStatus;

public interface AppSearchPaneController {

    void filterEvents(String searchText, JobStatus status);

}
