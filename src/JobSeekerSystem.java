public class JobSeekerSystem {

    private User loggedInUser;
    private UserInterface currentScreen;
    private Datastore dataStore;


    public JobSeekerSystem(User loggedInUser, UserInterface currentScreen, Datastore dataStore) {
        this.loggedInUser = loggedInUser;
        this.currentScreen = currentScreen;
        this.dataStore = dataStore;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public UserInterface getCurrentScreen() {
        return currentScreen;
    }

    public Datastore getDataStore() {
        return dataStore;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setCurrentScreen(UserInterface currentScreen) {
        this.currentScreen = currentScreen;
    }

    public void setDataStore(Datastore dataStore) {
        this.dataStore = dataStore;
    }
}