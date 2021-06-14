package gui.body;

import application.*;
import controller.BodyViewController;
import data.DataStore;
import gui.body.searchBar.JobSearchPane;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
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
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        SearchPane searchBar = new SearchPane(bvc);

        JComponent panel1 = new ScrollPane<JobInteraction>(this, new JobSearchPane(this.bvc));
        panel1.setPreferredSize(tabSize);
        tabbedPane.addTab("Search", null, panel1,
                "Find Jobs");
        paneCardMapping.put("Search", JobListing.class);

        JComponent panel2 = new PersonalProfilePane("Profile", bvc);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Profile", null, panel2, "Profile");
        paneCardMapping.put("Profile", null);

        JComponent panel3 = new ScrollPane<JobInteraction>(this, searchBar);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Applications", null, panel3,
                "Review Applications");
        paneCardMapping.put("Applications", JobApplication.class);

        JComponent panel4 = new ScrollPane<JobInteraction>(this, searchBar);
        panel4.setPreferredSize(tabSize);
        tabbedPane.addTab("Invitations", null, panel4,
                "Manage Invitations");
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
