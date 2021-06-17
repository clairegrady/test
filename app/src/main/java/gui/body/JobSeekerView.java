package gui.body;

import application.*;
import controller.BodyViewController;
import gui.body.searchBar.JobSearchPane;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class JobSeekerView extends JPanel implements TabController {

    BodyViewController bvc;

    public JobSeekerView(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        Tab searchTab = new SearchListingTab(bvc, JobStatus.ACTIVE);
        tabbedPane.addTab("Search", null, searchTab, "Find Jobs");

        Tab profileTab = new PersonalProfileTab(bvc);
        tabbedPane.addTab("Profile", null, profileTab, "Profile");

        Tab applicationTab = new ApplicationTab(bvc);
        applicationTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Applications", null, applicationTab, "Review Applications");

        Tab invitationTab = new InvitationTab(bvc);
        invitationTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, invitationTab, "Manage Invitations");

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();

            Tab tab = (Tab) tabbedPane.getComponentAt(selectedIndex);

            tab.display();

        });

        this.add(tabbedPane, BorderLayout.CENTER);

    }

    public String  getTabSubjectId() {
        return bvc.getLoggedInUser();
    }

}
