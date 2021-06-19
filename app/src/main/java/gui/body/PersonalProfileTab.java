package gui.body;

import controller.NavigationController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PersonalProfileTab extends Tab {

    NavigationController navigationController;
    private UserController userController;
    private HashMap seekerKeywords;
    private JButton editButton;
    private JPanel blankPanel;

    public PersonalProfileTab(NavigationController navigationController, UserController userController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.seekerKeywords = new HashMap<>();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        /* Initial creation of the main panel */
        blankPanel = new JPanel();
        gbc.gridy = 0;
        blankPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        blankPanel.setVisible(true);
        this.add(blankPanel, gbc);

        insertBody();

        //Edit Button
        JPanel buttonPanel = new JPanel();
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(20, 0, 0, 0);
        this.add(buttonPanel, gbc);

        editButton = new JButton("Edit");
        editButton.setFocusable(false);
        buttonPanel.add(editButton);

        //editButton.addActionListener(e -> displayProfile());

    }

    public void display() {
//TODO: use this method
    }

    public void insertBody(){
        SeekerProfileBody spb = new SeekerProfileBody(userController.getJobSeekerById(userController.getLoggedInUser()));
        blankPanel.add(spb.createBody());
    }

}