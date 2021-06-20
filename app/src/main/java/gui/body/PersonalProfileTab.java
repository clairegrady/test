package gui.body;

import controller.NavigationController;
import controller.UserController;
import gui.body.searchBar.DetailsEditPane;

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

        this.navigationController = navigationController;
        this.userController = userController;
        this.add(new DetailsEditPane(navigationController, userController), BorderLayout.NORTH);
        this.add(new SeekerProfileBody(navigationController, userController), BorderLayout.CENTER);
    }


    @Override
    public void display() {

    }
}