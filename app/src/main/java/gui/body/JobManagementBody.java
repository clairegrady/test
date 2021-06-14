package gui.body;

import application.CardDisplayable;
import application.JobInteraction;
import application.User;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobManagementBody extends JPanel implements ScrollPaneController {

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

        JComponent panel2 = new ScrollPane(this, searchBar);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Seeker Search", null, panel2,
                "Find Job Seekers");

        JComponent panel3 = new ScrollPane(this, searchBar);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Applicants", null, panel3,
                "Review Applicants");

        JComponent panel4 = new ScrollPane(this, searchBar);
        panel4.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, panel4,
                "Manage Invitations");


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