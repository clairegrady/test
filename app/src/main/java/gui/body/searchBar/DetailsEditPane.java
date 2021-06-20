package gui.body.searchBar;

import controller.UserController;
import controller.NavigationController;

import javax.swing.*;
import java.awt.*;

public class DetailsEditPane extends JPanel {

    private Dimension searchBarSize = new Dimension(900,45);
    protected NavigationController navigationController;
    private UserController userController;
    protected JPanel centrePanel;
    private JButton homeButton;

    public DetailsEditPane(NavigationController navigationController, UserController userController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.setPreferredSize(searchBarSize);
        this.homeButton = new JButton("Back");
        this.centrePanel = new JPanel();
        this.add(centrePanel);
        this.homeButton.addActionListener(e -> navigationController.loginComplete("RECRUITER"));
        this.centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.LINE_AXIS));
        this.centrePanel.setPreferredSize(searchBarSize);
        this.centrePanel.setBorder(BorderFactory.createEmptyBorder(7,0,15,0));
        this.centrePanel.add(homeButton);
        this.centrePanel.add(Box.createHorizontalGlue());
        this.homeButton.addActionListener(e -> navigationController.setBody("CREATEJOB"));
    }
}