package gui.body;

import application.Job;
import controller.JobController;
import controller.NavigationController;
import data.DataStore;

import javax.swing.*;
import java.awt.*;

public class JobManagementView extends JPanel implements TabController {

    private NavigationController navigationController;
    private JobController jobController;
    private Job job;

    public JobManagementView(NavigationController navigationController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.setLayout(new BorderLayout());

        this.job = this.jobController.getCurrentJob();

        addTabs();
    }

    public void addTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment", "center");

        JComponent jobDetailsTab = new JobDetailsPane(this.navigationController);
        jobDetailsTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Job Details", null, jobDetailsTab, "Details");

        Tab seekerSearch = new UserTab(this.navigationController, this.job);
        seekerSearch.setPreferredSize(tabSize);
        tabbedPane.addTab("Seeker Search", null, seekerSearch, "View Potential Candidates");

        Tab applicantsTab = new ApplicantsTab(this.navigationController, this.job);
        applicantsTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Applications", null, applicantsTab, "Review Applications");

        Tab inviteesTab = new ApplicantsTab(this.navigationController, this.job);
        inviteesTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, inviteesTab, "Manage Invitations");

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();

            Tab tab = (Tab) tabbedPane.getComponentAt(selectedIndex);

            tab.display();

        });

        this.add(tabbedPane, BorderLayout.CENTER);

        System.out.println(job);
    }


    public String getTabSubjectId() {
        return this.job.getUniqueId();
    }

}