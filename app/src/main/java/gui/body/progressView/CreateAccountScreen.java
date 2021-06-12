package gui.body.progressView;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;

public class CreateAccountScreen extends JPanel {
    private JProgressBar progressBar;
    private JPanel mainPanel;
    private JLabel bodyTitle;
    private JLabel mandatory;
    private JLabel fName;
    private JLabel lName;
    private JLabel email;
    private JLabel company;
    private JLabel pw;
    private JLabel pwConfirm;
    private JTextField fNameEntry;
    private JTextField lNameEntry;
    private JTextField emailEntry;
    private JTextField companyEntry;
    private JPasswordField pwEntry;
    private JPasswordField pwConfirmEntry;
    private JLabel text2;
    private JLabel bodyTitle2;
    private JPanel mainPanel2;
    private JButton backButton;
    private JButton proceedButton;
    private JButton profileButton;
    private BodyViewController bvc;

    public CreateAccountScreen(BodyViewController bvc) {

        super();
        this.bvc = bvc;

        /* Initial creation of the main panel */
        JPanel mainPanel = new JPanel();
        setFormat(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.add(mainPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        mainPanel.setVisible(true);

        JPanel mainPanel2 = new JPanel();
        setFormat(mainPanel2);
        mainPanel2.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        this.add(mainPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        this.setLayout(new CardLayout());
        this.add(mainPanel, "CREATE");
        this.add(mainPanel2, "SUCCESS");
        this.setPage("LOGIN");

        //Main Panel - Card 1
        //Body Title
        bodyTitle = new JLabel("Account Details");
        setStyle(bodyTitle);
        bodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        setPosition(c,0,0);
        mainPanel.add(bodyTitle, c);

        //Mandatory message
        mandatory = new JLabel("*Denotes mandatory field");
        setStyle(mandatory);
        mandatory.setFont(new Font("Tahoma", Font.ITALIC, 10));
        setPosition(c,0,1);
        mainPanel.add(mandatory, c);

        //First Name
        fName = new JLabel("First Name*:");
        setStyle(fName);
        setPosition(c,0,2);
        mainPanel.add(fName, c);

        //First Name Entry
        fNameEntry = new JTextField(20);
        setPosition(c,1,2);
        mainPanel.add(fNameEntry, c);

        //Last Name
        lName = new JLabel("Last Name*:");
        setStyle(lName);
        setPosition(c,3,2);
        mainPanel.add(lName, c);

        //Last Name Entry
        lNameEntry = new JTextField(20);
        setPosition(c,4,2);
        mainPanel.add(lNameEntry, c);

        //Email
        email = new JLabel("Email Address*:");
        setStyle(email);
        setPosition(c,0,3);
        mainPanel.add(email, c);

        //Email Entry
        emailEntry = new JTextField(20);
        setPosition(c,1,3);
        mainPanel.add(emailEntry, c);

        //Company
        company = new JLabel("Company:");
        setStyle(company);
        setPosition(c,3,3);
        mainPanel.add(company, c);

        //Company Entry
        companyEntry = new JTextField(20);
        setPosition(c,4,3);
        mainPanel.add(companyEntry, c);

        //Password
        pw = new JLabel("Password*:");
        setStyle(pw);
        setPosition(c,0,4);
        mainPanel.add(pw, c);

        //Password Entry
        pwEntry = new JPasswordField(20);
        setPosition(c,1,4);
        mainPanel.add(pwEntry, c);

        //Password Confirm
        pwConfirm = new JLabel("Confirm Password*:");
        setStyle(pwConfirm);
        setPosition(c,3,4);
        mainPanel.add(pwConfirm, c);

        //Password Entry
        pwConfirmEntry = new JPasswordField(20);
        setPosition(c,4,4);
        mainPanel.add(pwConfirmEntry, c);

        //Back Button
        backButton = new JButton("Back");
        backButton.setFocusable(false);
        setPosition(c,0,6);
        c.insets = new Insets(50, 0, 0,0);
        c.anchor = GridBagConstraints.CENTER;
        mainPanel.add(backButton, c);

        //Proceed Button
        proceedButton = new JButton("Create Account");
        proceedButton.setFocusable(false);
        setPosition(c,4,6);
        c.insets = new Insets(50, 0, 0,0);
        c.anchor = GridBagConstraints.CENTER;
        mainPanel.add(proceedButton, c);

        /* Creating the mid section between the tabs and the main display*/
//        JPanel midPanel = new JPanel();
//        midPanel.setLayout(new GridLayoutManager(2, 1, new Insets(5, 15, 5, 15), -1, -1));
//        midPanel.setBackground(new Color(-6578528));
//        midPanel.setForeground(new Color(-16777216));
//        this.add(midPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//        progressBar = new JProgressBar();
//        progressBar.setStringPainted(true);
//        progressBar.setValue(50);
//        midPanel.add(progressBar, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        // //Main Panel - Card 2
        //Body Title
        bodyTitle2 = new JLabel("Success");
        setStyle(bodyTitle2);
        bodyTitle2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        setPosition(c2,0,0);
        mainPanel2.add(bodyTitle2, c2);

        //Success message
        text2 = new JLabel("You have registered as a Recruiter in the Job Seeker System");
        setStyle(text2);
        text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        setPosition(c2,0,2);
        c2.anchor = GridBagConstraints.CENTER;
        mainPanel2.add(text2, c2);

        //Go to Profile Button
        profileButton = new JButton("Go to Profile");
        profileButton.setFocusable(false);
        setPosition(c2,2,3);
        c2.insets = new Insets(50, 0, 0,0);
        c2.anchor = GridBagConstraints.LINE_END;
        mainPanel2.add(profileButton, c2);

        //Creating the action listeners to change the tabs and refresh the main panel
        profileButton.addActionListener(e -> {
//
        });

        backButton.addActionListener(e-> {
            bvc.getMainFrame().setBody("LOGIN");
            bvc.getMainFrame().setHeader("BUTTONS");
        });

        proceedButton.addActionListener(e -> {
            setPage("SUCCESS");
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

    public void setStyle(JLabel text){
        text.setFont(new Font("Tahoma", Font.PLAIN, 15));
        text.setForeground(new Color(0, 0, 0)); //set text colour
        text.setOpaque(false);
        text.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text.setVerticalAlignment(JLabel.TOP); //set page title top
    }

    public void setPosition(GridBagConstraints c, int x, int y){
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
    }

    public void setFormat(JPanel p){
        p.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 5, 5));
        p.setBackground(new Color(0xFFFFFF));
    }

}