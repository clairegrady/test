package gui.body.searchBar;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class AppSearchPane extends JPanel {

    private Dimension searchBarSize = new Dimension(800,45);
    private BodyViewController bvc;
    private JTextField searchField;
    private String[] statusKeywords;
    private JComboBox statusDropdown;
    private JButton filterButton;

    public AppSearchPane(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.setBorder(BorderFactory.createEmptyBorder(7,0,5,0));
        this.searchField = new JTextField(40);
        this.searchField.putClientProperty("JTextField.placeholderText", "Search");
        this.statusKeywords =new String[]{"Job Status", "Active", "Draft", "Closed"};
        this.statusDropdown = new JComboBox(statusKeywords);
        this.filterButton = new JButton("Filter");
        this.add(searchField);
        this.add(statusDropdown);
        this.add(filterButton);

        this.filterButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of button: " + searchField.getText());
        });
    }
}

