package gui.body;

import com.intellij.uiDesigner.core.GridConstraints;
import controller.NavigationController;

import javax.swing.*;
import java.awt.*;

public class ChooseAccount extends JPanel {
    private NavigationController navigationController;

    public ChooseAccount(NavigationController navigationController) {

        super();
        this.navigationController = navigationController;

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
        setPosition(c, 0, 0, 2, 0, 0, 0, 0);
        createPanel.add(bodyTitle, c);

        //Seeker Button
        JButton seekerButton = new JButton("Job Seeker");
        seekerButton.setFocusable(false);
        setButtonPosition(c, 0, 6, 1, 30, 10, 0, 10);
        createPanel.add(seekerButton, c);

        //Recruiter Button
        JButton recruiterButton = new JButton("Recruiter");
        recruiterButton.setFocusable(false);
        setButtonPosition(c, 1, 6, 1, 30, 10, 0, 10);
        createPanel.add(recruiterButton, c);

        //Back Button
        JPanel buttonPanel = new JPanel();
        setButtonPosition(c, 0, 8, 2, 50, 0, 0, 0);
        c.anchor = GridBagConstraints.LINE_START;
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        createPanel.add(buttonPanel, c);

        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        //backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.add(backButton);


        //Creating the action listeners to change the tabs and refresh the main panel

        seekerButton.addActionListener(e -> {
            navigationController.setBody("CREATESEEKER");
            navigationController.setHeader("LOGIN");
        });

        recruiterButton.addActionListener(e -> {
            navigationController.setBody("CREATEACCOUNT");
            navigationController.setHeader("LOGIN");
        });

        backButton.addActionListener(e -> {
            navigationController.setBody("LOGIN");
            navigationController.setHeader("LOGIN");
        });
    }

    public void setPage(String page) {
        CardLayout createAccount = (CardLayout) (this.getLayout());
        createAccount.show(this, page);
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r) {
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(t, l, b, r);
    }

    public void setButtonPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r) {
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(t, l, b, r);
    }

}
