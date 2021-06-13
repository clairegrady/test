package gui.body;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class JobSeekerView extends JPanel {

    BodyViewController bvc;

    public JobSeekerView(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent panel1 = new ScrollPane(bvc, "Job Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel1.setPreferredSize(tabSize);
        tabbedPane.addTab("Search", null, panel1,
                "Find Jobs");

        JComponent panel2 = new PersonalProfilePane("Profile", bvc);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Profile", null, panel2, "Profile");


        JComponent panel3 = new ScrollPane(bvc, "Job Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Applications", null, panel3,
                "Review Applications");

        JComponent panel4 = new ScrollPane(bvc, "Job Name", "Matching Score: 95%", "Profile", 14, "UID for User", 1);
        panel4.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, panel4,
                "Manage Invitations");


        this.add(tabbedPane, BorderLayout.CENTER);

    }

}
