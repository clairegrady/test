package gui;


import controller.JobController;
import controller.NavigationController;
import controller.UserController;
import data.DataStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private final NavigationController navigationController;
    private final UserController userController;
    private final JobController jobController;
    private MainHeaderPane header;
    private MainBodyPane body;

    public MainFrame() {
        //Create and set up the window.
        super("JobSeekerSystem");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1080, 920));
        this.navigationController = new NavigationController(this);
        this.userController = new UserController(navigationController);
        this.jobController = new JobController(navigationController, userController);
//        this.lc = new UserController( this);
        this.body = new MainBodyPane(navigationController, userController, jobController);
        this.header = new MainHeaderPane(navigationController, userController);

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

    public UserController getUserController() {
        return this.userController;
    }

    public JobController getJobController() {
        return this.jobController;
    }

    public void setBody(String body) {
        this.body.setBody(body);
    }

    public void setHeader(String header) {
        this.header.setHeader(header);
    }

}