package gui;


import controller.BodyViewController;
import controller.HeaderViewController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private HeaderPane header;
    private BodyPane body;
    private BodyViewController bvc;
    private HeaderViewController hvc;
    
    public MainFrame() {
        //Create and set up the window.
        super("JobSeekerSystem");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.bvc = new BodyViewController(MainFrame.this);
        this.hvc = new HeaderViewController();
        this.body = new BodyPane(bvc);
        this.header = new gui.HeaderPane(hvc);


        //Add content to the window.
        this.add(header, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);

        //Display the window.
        this.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    public void setBody(String body) {
        this.body.setBody(body);
    }

    public BodyViewController getBVC() {
        return bvc;
    }

    @Override
    public void pack() {
        super.pack();
    }
}