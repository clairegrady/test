package gui.body;

import controller.BodyViewController;
import gui.body.searchBar.RecruiterFilterPane;

import javax.swing.*;
import java.awt.*;

public class RecruiterView extends JPanel {

    private BodyViewController bvc;

    // refactor this to inherit from Tabbed Pane view
    public RecruiterView(BodyViewController bvc){
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        bvc = this.bvc;


        /* getText*/
        /*
            ArrayList<String[]> activeJobs = new ArrayList<ArrayList<String[]>;
            ArrayList<String[]> draftJobs = new ArrayList<String[]>;
            ArrayList<String[]> closedJobs = new ArrayList<String[]>;

            recruiter.getJobInteractions().forEach((job) -> {   //find how to obtain recruiter object from MainPanel
                if (job.getStatus() == "Active") {
                    activeJobs.add(new String[] {job.getName(), job.getCompany(), job.getUID()});
                    activeCount += 1
                    }
                else if (job.getStatus() == "Draft") {
                    draftJobs.add(new String[] {job.getName(), job.getCompany(), job.getUID()});
                    }
                else if (job.getStatus() == "Closed") {
                    closedJobs.add(new String[] {job.getName(), job.getCompany(), job.getUID()});
                    }
                });

                getText, getCompany, getCardUID should all be dealt with by one putting in the ArrayList of
                jobs instead of the three String parameters. This Array will get split out in CardObjectPanel.
                buttonDetails always "View"
                maxCards = activeJobs.size();
                rows always 1

                if (activeJobs.size() > 0) {RUN THE BELOW METHOD}, etc etc

        */
        RecruiterFilterPane activePane = new RecruiterFilterPane(bvc, 20, "Active");
        JComponent panel1 = new gui.body.ScrollPane(bvc, activePane,"Active Job Example", "Company", "View", 20, "getCardID", 1);
        panel1.setPreferredSize(tabSize);
        tabbedPane.addTab("Active", null, panel1,
                "Active Job ads");

        RecruiterFilterPane draftPane = new RecruiterFilterPane(bvc, 3, "Draft");
        JComponent panel2 = new gui.body.ScrollPane(bvc, draftPane,"Draft Job Example", "Company", "View", 3, "getCardID", 1);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Draft", null, panel2,
                "Draft Job ads");

        RecruiterFilterPane closedPane = new RecruiterFilterPane(bvc, 1, "Closed");
        JComponent panel3 = new ScrollPane(bvc, closedPane,"Closed Job Example", "Company", "View", 1, "getCardID", 1);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Closed", null, panel3,
                "Closed Job ads");

        this.add(tabbedPane, BorderLayout.CENTER);
    }
}
