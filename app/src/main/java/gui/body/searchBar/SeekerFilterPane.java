package gui.body.searchBar;

import data.JobStatus;
import data.MatchScore;

import javax.swing.*;
import java.awt.*;

public class SeekerFilterPane extends JPanel {


    private final JTextField searchField;
    private Dimension searchBarSize = new Dimension(800, 45);
    private SeekerFilterPaneController seekerFilterPaneController;
    private JComboBox matchScoreDropdown;
    private JButton searchButton;
    private JButton homeButton;

    public SeekerFilterPane(SeekerFilterPaneController seekerFilterPaneController) {
        super();
        this.seekerFilterPaneController = seekerFilterPaneController;
        this.setPreferredSize(searchBarSize);
        this.setBorder(BorderFactory.createEmptyBorder(7, 0, 5, 0));
        this.searchField = new JTextField(40);
        this.searchField.putClientProperty("JTextField.placeholderText", "Search");
        this.matchScoreDropdown = new JComboBox(MatchScore.values());
        this.homeButton = new JButton("Home");
        this.searchButton = new JButton("Filter");
        this.add(searchField);
        this.add(matchScoreDropdown);
        this.add(searchButton);
        this.add(homeButton);
        this.homeButton.addActionListener(e -> {seekerFilterPaneController.navigate();});
        this.searchButton.addActionListener(e -> {
            filterEvents(searchField.getText());
        });
    }

    public void filterEvents(String searchText) {
        this.seekerFilterPaneController.filterEvents(searchText, matchScoreDropdown.getSelectedItem().toString());

    }


}
