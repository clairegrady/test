package application;

import data.DataStore;

public class JobSeekerSystem {

    private User loggedInUser;
    private UserInterface currentScreen;
    private DataStore dataStore;


    public JobSeekerSystem(User loggedInUser, UserInterface currentScreen, DataStore dataStore) {
        this.loggedInUser = loggedInUser;
        this.currentScreen = currentScreen;
        this.dataStore = dataStore;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public UserInterface getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(UserInterface currentScreen) {
        this.currentScreen = currentScreen;
    }

    public DataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(DataStore dataStore) {
        this.dataStore = dataStore;
    }
}
