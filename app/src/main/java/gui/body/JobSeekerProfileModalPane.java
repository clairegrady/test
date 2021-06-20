package gui.body;

import controller.NavigationController;
import controller.UserController;

public class JobSeekerProfileModalPane extends SeekerProfileBody {

    public JobSeekerProfileModalPane(NavigationController navigationController, UserController userController) {
        super(navigationController, userController);
    }

    @Override
    protected void displayPersonalDetails() {
        userController.setSeekerProfileInformation(this);
    }
}
