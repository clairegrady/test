package gui.body;

import controller.BodyViewController;
import gui.body.searchBar.JobViewPane;

import javax.swing.*;
import java.awt.*;

public class JobDetailsPane extends JPanel {

    JobDetailsPane(BodyViewController bvc){
        super(new BorderLayout());
        this.add(new JobViewPane(bvc), BorderLayout.NORTH);
        JLabel filler = new JLabel("Job Details");
        this.add(filler, BorderLayout.CENTER);
    }
}