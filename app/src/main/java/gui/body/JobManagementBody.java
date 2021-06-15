package gui.body;

import application.CardDisplayable;
import application.JobInteraction;
import controller.BodyViewController;
import gui.body.searchBar.SearchPane;
import gui.body.searchBar.SeekerFilterPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JobManagementBody extends JPanel implements ScrollPaneController {

    BodyViewController bvc;

    public JobManagementBody(BodyViewController bvc) {

        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent jobDetailsTab = new JobDetailsPane(this.bvc);
        tabbedPane.addTab("Job Details", null, jobDetailsTab, "Details");

        SearchPane searchBar = new SearchPane(this.bvc);

        JComponent searchTab = new ScrollPane(this, new SeekerFilterPane(this.bvc));
        tabbedPane.addTab("Seeker Search", null, searchTab, "Find Job Seekers");

        JComponent applicantsTab = new ScrollPane(this, new SeekerFilterPane(this.bvc));
        tabbedPane.addTab("Applicants", null, applicantsTab, "Review Applicants");

        JComponent invitationsTab = new ScrollPane(this, new SeekerFilterPane(this.bvc));
        tabbedPane.addTab("Invitations", null, invitationsTab, "Manage Invitations");

        this.add(tabbedPane, BorderLayout.CENTER);
    }

    public List<? extends CardDisplayable> getScrollPaneData(String pane){
        return new ArrayList<JobInteraction>();
    }

    public Button getCardButton(){
        Button button = new Button();
        button.setProperty("blah");
        button.setText("View");
        button.addActionListener(ae -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of Card" + ", " + button.getProperty());
        });

        return button;
    }

    public String getLoggedInUser() {
        return bvc.getLoggedInUser();
    }

}