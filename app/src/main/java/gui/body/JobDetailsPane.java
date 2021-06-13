package gui.body;

import controller.BodyViewController;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;

// import javax.swing.JButton;
// import javax.swing.UIManager;


public class JobDetailsPane extends JPanel {

    JobDetailsPane(String text, BodyViewController bvc){
        super(new BorderLayout());
        this.add(new SearchPane(bvc), BorderLayout.NORTH);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(1, 1));
        this.add(filler, BorderLayout.CENTER);
    }
}