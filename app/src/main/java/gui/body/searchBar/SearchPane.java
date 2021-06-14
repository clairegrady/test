package gui.body.searchBar;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class SearchPane extends JPanel {

    Dimension searchBarSize = new Dimension(800,40);
    BodyViewController bvc;

    public SearchPane(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        JButton logoutButton = new JButton("logout");
        logoutButton.addActionListener(e -> bvc.logOut());
        this.add(logoutButton, gbc);
    }



}