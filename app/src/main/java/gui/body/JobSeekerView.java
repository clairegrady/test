package gui.body;

import application.*;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.AppSearchPane;
import gui.body.searchBar.JobSearchPane;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class JobSeekerView extends JPanel implements ScrollPaneController {

    BodyViewController bvc;
    private Map<String, Class<?>> paneCardMapping;

    public JobSeekerView(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        paneCardMapping = new HashMap<>();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent searchTab = new ScrollPane<JobInteraction>(this, new JobSearchPane(this.bvc));
        tabbedPane.addTab("Search", null, searchTab, "Find Jobs");
        paneCardMapping.put("Search", JobListing.class);

        JComponent profileTab = new PersonalProfilePane(bvc);
        tabbedPane.addTab("Profile", null, profileTab, "Profile");
        paneCardMapping.put("Profile", null);

        JComponent applicationsTab = new ScrollPane<JobInteraction>(this, new AppSearchPane(this.bvc));
        tabbedPane.addTab("Applications", null, applicationsTab, "Review Applications");
        paneCardMapping.put("Applications", JobApplication.class);

        JComponent invitationsTab = new ScrollPane<JobInteraction>(this, new AppSearchPane(this.bvc));
        tabbedPane.addTab("Invitations", null, invitationsTab, "Manage Invitations");
        paneCardMapping.put("Invitations", JobInvitation.class);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();

            Component c = tabbedPane.getComponentAt(selectedIndex);

            String pane = tabbedPane.getTitleAt(selectedIndex);

            if (c instanceof ScrollPane) {
                ScrollPane sp = (ScrollPane) c;
                sp.display(tabbedPane.getTitleAt(selectedIndex));
            }

        });


        this.add(tabbedPane, BorderLayout.CENTER);

    }

    public List<? extends CardDisplayable> getScrollPaneData(String pane){

        System.out.println("Pane: " + pane);
        Class<?> classType = paneCardMapping.get(pane);
        System.out.println(classType);

        String userId = bvc.getLoggedInUser();
        // TODO: make the datastore.getinstance invisible to this class
        Optional<User> loggedInUser = DataStore.getDatastore().getUserById(userId);

        List<? extends CardDisplayable> jiList = new ArrayList<JobInteraction>();

        if (loggedInUser.isPresent()) {
            jiList = loggedInUser.get().getJobInteractions()
                    .stream()
                    .filter(classType::isInstance)
                    .collect(Collectors.toList());
        }

        return jiList;

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
