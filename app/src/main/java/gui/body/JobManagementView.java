package gui.body;

import application.Job;
import controller.BodyViewController;
import data.DataStore;

import javax.swing.*;
import java.awt.*;

public class JobManagementView extends JPanel implements TabController {

    BodyViewController bvc;
    private String jobId;
    private Job job;

    public JobManagementView(BodyViewController bvc) {

        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());
        this.jobId = "Default";
        addTabs();

    }

    public JobManagementView(BodyViewController bvc, String jobId){
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());
        this.jobId = jobId;
        this.job = DataStore.getDatastore().getJobById(jobId).get();

        addTabs();
        System.out.println(this.getClass() + " - jobId: " + jobId);
    }

    public void addTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent jobDetailsTab = new JobDetailsPane(this.bvc);
        jobDetailsTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Job Details", null, jobDetailsTab, "Details");

        Tab seekerSearch = new UserTab(this.bvc, this.job);
        seekerSearch.setPreferredSize(tabSize);
        tabbedPane.addTab("Seeker Search", null, seekerSearch, "View Potential Candidates");

        Tab applicantsTab = new ApplicantsTab(this.bvc, this.job);
        applicantsTab.setPreferredSize(tabSize);
        tabbedPane.addTab("Applications", null, applicantsTab, "Review Applications");

        Tab inviteesTab = new ApplicantsTab(this.bvc, this.job);
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

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getTabSubjectId() {
        return this.jobId;
    }

}