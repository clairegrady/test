package gui.body;

import application.*;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.RecruiterFilterPane;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecruiterView extends JPanel implements ScrollPaneController {

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

        for (JobStatus jobStatus : JobStatus.values()) {
            if (jobStatus != JobStatus.NULL) {
                RecruiterFilterPane filterPane = new RecruiterFilterPane(bvc, 1, jobStatus.toString());
                ScrollPane<JobInteraction> scrollPane = new ScrollPane<>(this, filterPane);
                tabbedPane.addTab(jobStatus.toString(), null, scrollPane);
                scrollPane.display(jobStatus.toString());
            }
        }

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            ScrollPane j =
                    (ScrollPane) tabbedPane.getComponentAt(selectedIndex);
            j.display(tabbedPane.getTitleAt(selectedIndex));
        });

        this.add(tabbedPane, BorderLayout.CENTER);

    }

    public List<? extends CardDisplayable> getScrollPaneData(String pane){

        String userId = bvc.getLoggedInUser();
        // TODO: make the datastore.getinstance invisible to this class
        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);

        List<? extends CardDisplayable> jiList = new ArrayList<JobInteraction>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(ji -> ji.getStatus().toString().equals(pane))
                    .collect(Collectors.toList());
        }

        return jiList;
    }

    public Button getCardButton(){
        Button button = new Button("View", bvc);
        button.setProperty("blah");
        button.setText("View");
        button.addActionListener(ae -> {
            button.getBvc().setBody("JOBMANAGER");
        });

        return button;
    }

}
