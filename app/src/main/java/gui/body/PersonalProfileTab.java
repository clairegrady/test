package gui.body;

import gui.modal.InvitationFrame;
import gui.modal.SeekerProfileFrame;
import controller.NavigationController;
import controller.UserController;
import gui.body.searchBar.DetailsEditPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonalProfileTab extends Tab {

    NavigationController navigationController;
    private UserController userController;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String personalSummary;
    private String qualifications;
    private String experience;
    private HashMap seekerKeywords;
    private JButton editButton;
    private JPanel seekerPanel;
    private SeekerProfileFrame spf;

    public PersonalProfileTab(NavigationController navigationController, UserController userController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.seekerKeywords = new HashMap<>();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;

        /* Initial creation of the main panel */
        seekerPanel = new JPanel();
        seekerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        seekerPanel.setVisible(true);
        this.add(seekerPanel, gbc);

        //Main Panel - Card 1

        //Body Title
        JLabel name = new JLabel("Full Name");
        setTextPosition(name);
        setPosition(c, 0, 1, 1, 1, 0, 0, 0, 0);
        seekerPanel.add(name, c);

        //Personal Summary
        JLabel summaryTitle = new JLabel("Personal Summary");
        setTextPosition(summaryTitle);
        setPosition(c, 0, 2, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(summaryTitle, c);

        JTextArea summaryText = new JTextArea("Personal Summary TEXT Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        setTextAreaPosition(summaryText, 300, 100);
        setPosition(c, 0, 3, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(summaryText, c);

        //Experience
        JLabel experienceTitle = new JLabel("Experience");
        setTextPosition(experienceTitle);
        setPosition(c, 0, 4, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(experienceTitle, c);

        JTextArea experienceText = new JTextArea("Experience TEXT Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        setTextAreaPosition(experienceText, 300, 100);
        setPosition(c, 0, 5, 1, 3, 0, 10, 0, 10);
        seekerPanel.add(experienceText, c);

        //Skills
        JLabel skillsTitle = new JLabel("Skills");
        setTextPosition(skillsTitle);
        setPosition(c, 1, 2, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(skillsTitle, c);

        JTextArea skillsText = new JTextArea("Skills TEXT Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        setTextAreaPosition(skillsText, 300, 100);
        setPosition(c, 1, 3, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(skillsText, c);

        //Qualifications
        JLabel qualTitle = new JLabel("Qualifications");
        setTextPosition(qualTitle);
        setPosition(c, 1, 4, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(qualTitle, c);

        JTextArea qualText = new JTextArea("Qualifications TEXT Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        setTextAreaPosition(qualText, 300, 70);
        setPosition(c, 1, 5, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(qualText, c);

        //Education
        JLabel educationTitle = new JLabel("Education");
        setTextPosition(educationTitle);
        setPosition(c, 1, 6, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(educationTitle, c);

        JTextArea educationText = new JTextArea("Education TEXT ");
        setTextAreaPosition(educationText, 300, 20);
        setPosition(c, 1, 7, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(educationText, c);

        //Edit Button
        JPanel buttonPanel = new JPanel();
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(20, 0, 0, 0);
        this.add(buttonPanel, gbc);

        editButton = new JButton("Edit");
        editButton.setFocusable(false);
        buttonPanel.add(editButton);

        editButton.addActionListener(e -> displayProfile());

    }

    public void display() {

    }

    public void displayProfile() {
        SeekerProfileFrame spf = new SeekerProfileFrame(navigationController);
        spf.displayProfile(seekerPanel);
        JButton invite = new JButton("Send Invitation");
        invite.addActionListener(e -> {
            InvitationFrame invitation = new InvitationFrame(navigationController);
        });
    }

    public void setTextAreaPosition(JTextArea textArea, int w, int h){
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(w,h));
        textArea.setEditable(false);
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w, int h, int t, int l, int b, int r){
        c.gridwidth = w;
        c.gridheight = h;
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(t,l,b,r);
    }

    public void setTextPosition(JLabel text){
        text.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text.setVerticalAlignment(JLabel.TOP); //set page title top
    }

}