package gui.body.searchBar;

import application.JobStatus;

public interface AppSearchPaneController {

    void filterEvents(String searchText, JobStatus status);

}
