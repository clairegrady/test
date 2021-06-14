package gui.body;

import controller.BodyViewController;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;

public class JobManagementBody extends JPanel {

    BodyViewController bvc;

    public JobManagementBody(BodyViewController bvc) {

        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent panel1 = new JobDetailsPane("JobDetails", bvc);
        panel1.setPreferredSize(tabSize);
        tabbedPane.addTab("Job Details", null, panel1, "Details");

        SearchPane searchBar = new SearchPane(bvc);

        JComponent panel2 = new ScrollPane(bvc, searchBar,"Seekers Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Seeker Search", null, panel2,
                "Find Job Seekers");

        JComponent panel3 = new ScrollPane(bvc, searchBar,"Applicants Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Applicants", null, panel3,
                "Review Applicants");

        JComponent panel4 = new ScrollPane(bvc, searchBar,"Invitees Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel4.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, panel4,
                "Manage Invitations");


        this.add(tabbedPane, BorderLayout.CENTER);
    }

}