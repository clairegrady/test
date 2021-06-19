package gui.body.searchBar;

import data.JobStatus;

import javax.swing.*;
import java.awt.*;

public class AppSearchPane extends JPanel {

    private static final String DROPDOWN_DEFAULT = "Job Status";
    private Dimension searchBarSize = new Dimension(800, 45);
    private AppSearchPaneController appSearchPaneController;
    private JTextField searchField;
    private String[] statusKeywords;
    private JComboBox statusDropdown;
    private JButton filterButton;

    public AppSearchPane(AppSearchPaneController appSearchPaneController) {
        super();
        this.appSearchPaneController = appSearchPaneController;
        this.setPreferredSize(searchBarSize);
        this.setBorder(BorderFactory.createEmptyBorder(7, 0, 5, 0));
        this.searchField = new JTextField(40);
        this.searchField.putClientProperty("JTextField.placeholderText", "Search");
        this.statusKeywords = new String[]{DROPDOWN_DEFAULT, "Active", "Closed"};
        this.statusDropdown = new JComboBox(statusKeywords);
        this.filterButton = new JButton("Filter");
        this.add(searchField);
        this.add(statusDropdown);
        this.add(filterButton);

        this.filterButton.addActionListener(e -> {
            filterEvents(searchField.getText());
        });
    }

    public void filterEvents(String searchText) {
        String j = this.statusDropdown.getSelectedItem().toString();
        JobStatus js = j.equals(DROPDOWN_DEFAULT) ?
                JobStatus.NULL : JobStatus.valueOf(j.toUpperCase());

        this.appSearchPaneController.filterEvents(searchText, js);

    }
}

