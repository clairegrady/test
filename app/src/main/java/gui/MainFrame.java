package gui;


import controller.BodyViewController;
import controller.HeaderViewController;
import controller.LoginController;
import data.DataStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private MainHeaderPane header;
    private MainBodyPane body;
    private BodyViewController bvc;
    private HeaderViewController hvc;
    private LoginController lc;
    
    public MainFrame() {
        //Create and set up the window.
        super("JobSeekerSystem");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200,900));
        this.bvc = new BodyViewController(MainFrame.this);
        this.hvc = new HeaderViewController(MainFrame.this);
        this.lc = new LoginController(MainFrame.this);
        this.body = new MainBodyPane(bvc);
        this.header = new MainHeaderPane(hvc);


        //Add content to the window.
        this.add(header, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);

        //Display the window.
        this.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                DataStore.getDatastore().saveJobs();
                DataStore.getDatastore().saveUsers();
            }
        });

    }

    public void createPanes() {
        this.body.createPanes();
        this.header.createPanes();
    }

    public void setBody(String body) {
        this.body.setBody(body);
    }

    public void setBody(String body, String id) {
        this.body.setBody(body, id);
    }

    public void setHeader(String header) {
        this.header.setHeader(header);
    }

    public BodyViewController getBVC() {
        return bvc;
    }

    public HeaderViewController getHVC() {
        return hvc;
    }

    public LoginController getLC() {return lc; }

}