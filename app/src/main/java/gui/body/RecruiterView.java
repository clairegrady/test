package gui.body;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class RecruiterView extends JPanel {

    private BodyViewController bvc;

    // refactor this to inherit from Tabbed Pane view
    public RecruiterView(BodyViewController bvc){
        super();
        this.bvc = bvc;
        this.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        Dimension tabSize = new Dimension(800, 500);
        tabbedPane.putClientProperty("JTabbedPane.tabAreaAlignment","center");

        JComponent panel1 = new gui.body.ScrollPane("Active Job", bvc);
        panel1.setPreferredSize(tabSize);
        tabbedPane.addTab("Active", null, panel1,
                "Active Job ads");

        JComponent panel2 = new gui.body.ScrollPane("Draft Job", bvc);
        panel2.setPreferredSize(tabSize);
        tabbedPane.addTab("Draft", null, panel2,
                "Draft Job ads");

        JComponent panel3 = new ScrollPane("Closed Job", bvc);
        panel3.setPreferredSize(tabSize);
        tabbedPane.addTab("Closed", null, panel3,
                "Closed Job ads");

        //Add the tabbed pane to this panel.
//        this.add(searchBar, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
    }

}
