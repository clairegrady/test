package gui.body.progressView;

import com.intellij.uiDesigner.core.GridConstraints;
import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class CreateAccountScreen extends JPanel {
    private JProgressBar progressBar;
    private JTextField fNameEntry;
    private JTextField lNameEntry;
    private JTextField emailEntry;
    private JTextField companyEntry;
    private JPasswordField pwEntry;
    private JPasswordField pwConfirmEntry;
    private BodyViewController bvc;

    public CreateAccountScreen(BodyViewController bvc) {

        super();
        this.bvc = bvc;

        /* Initial creation of the main panel */
        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.add(createPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        createPanel.setVisible(true);

        JPanel successPanel = new JPanel();
        successPanel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        this.add(createPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        this.setLayout(new CardLayout());
        this.add(createPanel, "CREATE");
        this.add(successPanel, "SUCCESS");
        this.setPage("LOGIN");

        //Main Panel - Card 1

        //Body Title
        JLabel bodyTitle = new JLabel("Account Details");
        setTextPosition(bodyTitle);
        setPosition(c,0,1);
        createPanel.add(bodyTitle, c);

        //Mandatory message
        JLabel mandatory = new JLabel("*Denotes mandatory field");
        setTextPosition(mandatory);
        setPosition(c,0,2);
        createPanel.add(mandatory, c);

        //First Name
        JLabel fName = new JLabel("First Name*:");
        setTextPosition(fName);
        setPosition(c,0,3);
        createPanel.add(fName, c);

        //First Name Entry
        fNameEntry = new JTextField(20);
        setPosition(c,1,3);
        createPanel.add(fNameEntry, c);

        //Last Name
        JLabel lName = new JLabel("Last Name*:");
        setTextPosition(lName);
        setPosition(c,3,3);
        createPanel.add(lName, c);

        //Last Name Entry
        lNameEntry = new JTextField(20);
        setPosition(c,4,3);
        createPanel.add(lNameEntry, c);

        //Email
        JLabel email = new JLabel("Email Address*:");
        setTextPosition(email);
        setPosition(c,0,4);
        createPanel.add(email, c);

        //Email Entry
        emailEntry = new JTextField(20);
        setPosition(c,1,4);
        createPanel.add(emailEntry, c);

        //Company
        JLabel company = new JLabel("Company:");
        setTextPosition(company);
        setPosition(c,3,4);
        createPanel.add(company, c);

        //Company Entry
        companyEntry = new JTextField(20);
        setPosition(c,4,4);
        createPanel.add(companyEntry, c);

        //Password
        JLabel pw = new JLabel("Password*:");
        setTextPosition(pw);
        setPosition(c,0,5);
        createPanel.add(pw, c);

        //Password Entry
        pwEntry = new JPasswordField(20);
        setPosition(c,1,5);
        createPanel.add(pwEntry, c);

        //Password Confirm
        JLabel pwConfirm = new JLabel("Confirm Password*:");
        setTextPosition(pwConfirm);
        setPosition(c,3,5);
        createPanel.add(pwConfirm, c);

        //Password Entry
        pwConfirmEntry = new JPasswordField(20);
        setPosition(c,4,5);
        createPanel.add(pwConfirmEntry, c);

        //Back Button
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        setPosition(c,0,6);
        c.insets = new Insets(50, 0, 0,0);
        c.anchor = GridBagConstraints.CENTER;
        createPanel.add(backButton, c);

        //Proceed Button
        JButton proceedButton = new JButton("Create Account");
        proceedButton.setFocusable(false);
        setPosition(c,4,6);
        c.insets = new Insets(50, 0, 0,0);
        c.anchor = GridBagConstraints.CENTER;
        createPanel.add(proceedButton, c);

        //Progress Panel
        progressBar = new JProgressBar();
        progressBar.setStringPainted(false);
        progressBar.setValue(50);
        progressBar.putClientProperty("JProgressBar.square", true);
        progressBar.putClientProperty("JProgressBar.largeHeight", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 5;
        setPosition(c,0,0);
        createPanel.add(progressBar, c);

        // //Main Panel - Card 2
        //Body Title
        JLabel bodyTitle2 = new JLabel("Success");
        setTextPosition(bodyTitle2);
        setPosition(c2,0,1);
        successPanel.add(bodyTitle2, c2);

        //Success message
        JLabel text2 = new JLabel("You have registered as a Recruiter in the Job Seeker System");
        setTextPosition(text2);
        setPosition(c2,0,2);
        c2.anchor = GridBagConstraints.CENTER;
        successPanel.add(text2, c2);

        //Go to Profile Button
        JButton profileButton = new JButton("Go to Profile");
        profileButton.setFocusable(false);
        setButtonPosition(c2,4,3);
        c2.insets = new Insets(50, 0, 0,0);
        c2.anchor = GridBagConstraints.LINE_END;
        successPanel.add(profileButton, c2);

        //Creating the action listeners to change the tabs and refresh the main panel
        profileButton.addActionListener(e -> {
            bvc.getMainFrame().setBody("RECRUITER");
            bvc.getMainFrame().setHeader("RECRUITER");
            // need to implement logic based on account type
        });

        backButton.addActionListener(e-> {
            bvc.getMainFrame().setBody("CHOOSE");
            bvc.getMainFrame().setHeader("LOGIN");
            clearUserDetails();
        });

        proceedButton.addActionListener(e -> {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to create this account?", "Message",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.setPage("SUCCESS");
                    progressBar.setValue(100);
                    successPanel.add(progressBar, c);
                    bvc.createRecruiter(
                            emailEntry.getText(),
                            String.valueOf(pwEntry.getPassword()),
                            fNameEntry.getText(),
                            lNameEntry.getText(),
                            companyEntry.getText()
                    );
                }
            });
    }

    public void setPage(String page) {
        CardLayout createAccount = (CardLayout) (this.getLayout());
        createAccount.show(this, page);
    }

    public void getUserDetails(){
        String fNameValue = fNameEntry.getText();
        String lNameValue = lNameEntry.getText();
        String emailValue = emailEntry.getText();
        String companyValue = companyEntry.getText();
        String pwValue = String.valueOf(pwEntry.getPassword());
        String pwConfirmValue = String.valueOf(pwConfirmEntry.getPassword());
    }

    public void clearUserDetails(){
        fNameEntry.setText("");
        lNameEntry.setText("");
        emailEntry.setText("");
        companyEntry.setText("");
        pwEntry.setText("");
        pwConfirmEntry.setText("");
    }

    public void setTextPosition(JLabel text){
        text.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text.setVerticalAlignment(JLabel.TOP); //set page title top
    }

    public void setPosition(GridBagConstraints c, int x, int y){
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
    }

    public void setButtonPosition(GridBagConstraints c, int x, int y){
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(50, 0, 0,0);
        c.anchor = GridBagConstraints.CENTER;
    }

}