package gui.body;

import com.intellij.uiDesigner.core.GridConstraints;
import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class ChooseAccount extends JPanel {
    private BodyViewController bvc;

    public ChooseAccount(BodyViewController bvc) {

        super();
        this.bvc = bvc;

        /* Initial creation of the main panel */
        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.add(createPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        createPanel.setVisible(true);

        this.setLayout(new CardLayout());
        this.add(createPanel, "CREATE");
        this.setPage("LOGIN");

        //Main Panel

        //Body Title
        JLabel bodyTitle = new JLabel("Which account would you like to create?");
        setPosition(c,0,0, 2);
        createPanel.add(bodyTitle, c);

        //Seeker Button
        JButton seekerButton = new JButton("Job Seeker");
        seekerButton.setFocusable(false);
        setButtonPosition(c,0,6,1);
        createPanel.add(seekerButton, c);

        //Recruiter Button
        JButton recruiterButton = new JButton("Recruiter");
        recruiterButton.setFocusable(false);
        setButtonPosition(c,1,6,1);
        createPanel.add(recruiterButton, c);

        //Back Button
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        setButtonPosition(c,0,8, 2);
        createPanel.add(backButton, c);


        //Creating the action listeners to change the tabs and refresh the main panel

        seekerButton.addActionListener(e-> {
            bvc.getMainFrame().setBody("LOGIN");
            bvc.getMainFrame().setHeader("LOGIN");
        });

        recruiterButton.addActionListener(e -> {
            bvc.getMainFrame().setBody("CREATEACCOUNT");
            bvc.getMainFrame().setHeader("LOGIN");
        });

        backButton.addActionListener(e-> {
            bvc.getMainFrame().setBody("LOGIN");
            bvc.getMainFrame().setHeader("LOGIN");
        });
    }

    public void setPage(String page) {
        CardLayout createAccount = (CardLayout) (this.getLayout());
        createAccount.show(this, page);
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w){
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.CENTER;
    }

    public void setButtonPosition(GridBagConstraints c, int x, int y, int w){
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(50, 20, 20,20);
        c.anchor = GridBagConstraints.CENTER;
    }

}
