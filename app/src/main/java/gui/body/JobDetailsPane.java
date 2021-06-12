package gui.body;

import controller.BodyViewController;
import gui.body.searchBar.SearchPane;

import javax.swing.*;
import java.awt.*;

// import javax.swing.JButton;
// import javax.swing.UIManager;


public class JobDetailsPane extends JPanel {

    JobDetailsPane(String text, BodyViewController bvc){
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(1, 1));
        this.add(filler);
        this.add(new SearchPane(bvc));

    }
}