package gui.body.searchBar;

import data.*;

import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;

public class JobSearchPane extends JPanel {

    private Dimension searchBarSize = new Dimension(800, 45);
    private JobSearchPaneController jobSearchPaneController;
    private JTextField searchField;
    private JComboBox categoryDropdown;
    private JComboBox payDropdown;
    private JComboBox locationDropdown;
    private JButton searchButton;

    public JobSearchPane(JobSearchPaneController jobSearchPaneController) {
        super();
        this.jobSearchPaneController = jobSearchPaneController;
        this.setSize(searchBarSize);
        this.setLayout(new FlowLayout(CENTER, 5, 5));
        this.setBorder(BorderFactory.createEmptyBorder(7, 0, 5, 0));
        this.searchField = new JTextField(20);
        this.searchField.putClientProperty("JTextField.placeholderText", "Search");
        this.categoryDropdown = new JComboBox(JobCategory.getSearchFormCategories());
        this.payDropdown = new JComboBox(Sal.getSearchFormSalaries());
        this.locationDropdown = new JComboBox(Location.getSearchFormLocations());
        this.searchButton = new JButton("Search");

        this.add(searchField);
        this.add(categoryDropdown);
        this.add(payDropdown);
        this.add(locationDropdown);
        this.add(searchButton);
        this.searchButton.addActionListener(e -> search());
    }

    public void search() {
        jobSearchPaneController.searchData(
                searchField.getText(),
                categoryDropdown.getSelectedItem().toString(),
                payDropdown.getSelectedItem().toString(),
                locationDropdown.getSelectedItem().toString()
        );
    }
}
