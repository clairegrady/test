package gui.body;

import application.*;
import controller.BodyViewController;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class RecruiterView extends JPanel implements TabController {

    private BodyViewController bvc;

    // refactor this to inherit from Tabbed Pane view
    public RecruiterView(BodyViewController bvc){
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        Tab activeTab = new RecruiterListingTab(bvc, JobStatus.ACTIVE);
        tabbedPane.addTab("Active", null, activeTab, "View Active Jobs");

        Tab draftTab = new RecruiterListingTab(bvc, JobStatus.DRAFT);
        tabbedPane.addTab("Draft", null, draftTab, "View Active Jobs");

        Tab closedTab = new RecruiterListingTab(bvc, JobStatus.CLOSED);
        tabbedPane.addTab("Closed", null, closedTab, "View Active Jobs");

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
