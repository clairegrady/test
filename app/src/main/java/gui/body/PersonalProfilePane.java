package gui.body;

import controller.BodyViewController;
import gui.body.searchBar.DetailsEditPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonalProfilePane extends JPanel {

    BodyViewController bvc;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String personalSummary;
    private String qualifications;
    private String experience;
    private HashMap seekerKeywords;

    PersonalProfilePane(BodyViewController bvc) {
        super(new BorderLayout());
        this.bvc = bvc;
        this.add(new DetailsEditPane(bvc), BorderLayout.NORTH);
        fetchUserDetails();
        this.seekerKeywords = new HashMap();
        JLabel filler = new JLabel("personal details" + email + password + firstName + lastName + personalSummary + qualifications + experience);
        filler.setHorizontalAlignment(JLabel.CENTER);
        this.add(filler, BorderLayout.CENTER);
    }

    private void fetchUserDetails() {
        try {
            ArrayList<String> details = this.bvc.getMainFrame().getLC().getLoggedInUserDetails();
            this.email = details.get(0);
            this.password = details.get(1);
            this.firstName = details.get(2);
            this.lastName = details.get(3);
            this.personalSummary = details.get(4);
            this.qualifications = details.get(5);
            this.experience = details.get(6);
        } catch (Exception e){
            System.out.println("Arraylist Error");
        }
    }

    private void createPanels() {

    }

    private void addPanels() {

    }
}