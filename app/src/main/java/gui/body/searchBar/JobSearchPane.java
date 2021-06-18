package gui.body.searchBar;

import data.JobType;
import data.Location;
import data.Salary;
import gui.body.SearchListingTab;

import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;

public class JobSearchPane extends JPanel {

    private Dimension searchBarSize = new Dimension(800, 45);
    private SearchListingTab slt;
    private JTextField searchField;
    private JComboBox filterDropdown;
    private JComboBox payDropdown;
    private JComboBox locationDropdown;
    private String jobKeywords[];
    private String payKeywords[];
    private String locationKeywords[];
    private JButton searchButton;

    public JobSearchPane(SearchListingTab slt) {
        super();
        this.slt = slt;
        this.setSize(searchBarSize);
        this.setLayout(new FlowLayout(CENTER, 5, 5));
        this.setBorder(BorderFactory.createEmptyBorder(7, 0, 5, 0));
        this.searchField = new JTextField(20);
        this.searchField.putClientProperty("JTextField.placeholderText", "Search");
        this.jobKeywords = JobType.getArray();
        this.payKeywords = Salary.getSalaryArray();
        this.locationKeywords = Location.getArray();
        this.filterDropdown = new JComboBox(jobKeywords);
        this.payDropdown = new JComboBox(payKeywords);
        this.locationDropdown = new JComboBox(locationKeywords);
        this.searchButton = new JButton("Search");

        this.add(searchField);
        this.add(filterDropdown);
        this.add(payDropdown);
        this.add(locationDropdown);
        this.add(searchButton);
        this.searchButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of button: " + searchField.getText());
            // IF TEXTFIELD GREATER > 1, search by that, AND keywords, else just keywords
        });
    }
}
