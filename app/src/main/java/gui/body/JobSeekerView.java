package gui.body;

import data.JobStatus;
import controller.JobController;
import controller.NavigationController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class JobSeekerView extends JPanel implements TabController {

    private NavigationController navigationController;
    private JobController jobController;
    private UserController userController;

    public JobSeekerView(NavigationController navigationController, UserController userController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.userController = userController;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment", "center");

        Tab searchTab = new SearchListingTab(navigationController, jobController, userController, JobStatus.ACTIVE);
        tabbedPane.addTab("Search", null, searchTab, "Find Jobs");

        Tab profileTab = new PersonalProfileTab(navigationController, userController);
        tabbedPane.addTab("Profile", null, profileTab, "Profile");

        Tab applicationTab = new ApplicationTab(navigationController, userController);
        applicationTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Applications", null, applicationTab, "Review Applications");

        Tab invitationTab = new InvitationTab(navigationController, userController);
        invitationTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, invitationTab, "Manage Invitations");

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();

            Tab tab = (Tab) tabbedPane.getComponentAt(selectedIndex);

            tab.display();

        });

        this.add(tabbedPane, BorderLayout.CENTER);

    }

    public String getTabSubjectId() {
        return userController.getLoggedInUser();
    }

}
