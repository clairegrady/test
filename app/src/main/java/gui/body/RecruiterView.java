package gui.body;

import data.JobStatus;
import controller.JobController;
import controller.NavigationController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class RecruiterView extends JPanel implements TabController {

    private NavigationController navigationController;
    private UserController userController;

    // refactor this to inherit from Tabbed Pane view
    public RecruiterView(NavigationController navigationController, UserController userController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment", "center");

        Tab activeTab = new RecruiterListingTab(navigationController, userController,  jobController, JobStatus.ACTIVE);
        tabbedPane.addTab("Active", null, activeTab, "View Active Jobs");

        Tab draftTab = new RecruiterListingTab(navigationController, userController, jobController, JobStatus.DRAFT);
        tabbedPane.addTab("Draft", null, draftTab, "View Active Jobs");

        Tab closedTab = new RecruiterListingTab(navigationController, userController, jobController, JobStatus.CLOSED);
        tabbedPane.addTab("Closed", null, closedTab, "View Active Jobs");

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
