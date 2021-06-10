package gui;

import controller.HeaderViewController;

import javax.swing.*;
import java.awt.*;

public class HeaderPane extends JPanel {

    private HeaderViewController hvc;

    public HeaderPane(HeaderViewController hvc) {
        super();
        this.hvc = hvc;
        //TODO Implement card layout on header
        this.add(new HeaderButtonsPane());
//        JLabel filler = new JLabel("Job Seeker System");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        this.setPreferredSize((new Dimension(800, 100)));
//        this.setLayout(new GridLayout(1, 1));
//        this.add(filler);
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }

}