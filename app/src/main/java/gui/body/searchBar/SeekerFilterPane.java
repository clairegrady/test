package gui.body.searchBar;

import javax.swing.*;
import java.awt.*;

public class SeekerFilterPane extends JPanel {


    private final JTextField searchField;
    private Dimension searchBarSize = new Dimension(800, 45);
    private SeekerFilterPaneController seekerFilterPaneController;
    private String[] matchScoreBuckets;
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
        this.matchScoreBuckets = new String[]{"Match Score", "50+", "60+", "70+", "80+", "90+"};
        this.matchScoreDropdown = new JComboBox(matchScoreBuckets);
        this.homeButton = new JButton("Home");
        this.searchButton = new JButton("Filter");
        this.add(searchField);
        this.add(matchScoreDropdown);
        this.add(searchButton);
        this.add(homeButton);
//                this.homeButton.addActionListener(e -> {navigationController.setBody("RECRUITER");});
        this.searchButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of button: " + searchField.getText());
        });
    }
}
