package gui.body;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class TabbedPaneView extends JPanel {

    BodyViewController bvc;

    public TabbedPaneView(BodyViewController bvc) {

        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent panel1 = new JobDetailsPane("JobDetails", bvc);
        panel1.setPreferredSize(tabSize);
        tabbedPane.addTab("Job Details", null, panel1, "Details");


        JComponent panel2 = new gui.body.ScrollPane(bvc, "Seekers Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Seeker Search", null, panel2,
                "Find Job Seekers");

        JComponent panel3 = new gui.body.ScrollPane(bvc, "Applicants Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Applicants", null, panel3,
                "Review Applicants");

        JComponent panel4 = new ScrollPane(bvc, "Invitees Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel4.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, panel4,
                "Manage Invitations");


        //Add the tabbed pane to this panel.
//        this.add(searchBar, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }


}