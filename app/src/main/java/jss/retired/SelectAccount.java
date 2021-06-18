package jss.retired;

import javax.swing.*;
import java.awt.*;

public class SelectAccount extends JFrame /*implements ActionListener*/ {

    public static CardLayout card = new CardLayout(40, 30);
    private JPanel headerPanel;
    private JPanel midPanel;
    private JPanel bodyPanel;
    //private JPanel buttonPanel;
    private JLabel pageTitle;
    private JLabel midTitle;
    private JLabel bodyTitle;
    //private JLabel buttonTitle;
    private JButton rightButton;
    private JButton leftButton;
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
    private JProgressBar progressBar;
    private JButton profileIcon;
    private JButton logoutIcon;

    public SelectAccount() {
        JFrame frame = new JFrame();
        frame.setTitle("Job Seeker System"); //sets title of frame
        //frame.setSize(1000, 500); //sets x, y dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit app
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        //frame.getContentPane().setBackground(new Color(255,255,255)); //changes colour of b/g

        //panels
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1000, 50);
        headerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 10, 10, 10);
        frame.add(headerPanel, c);
        //headerPanel.setBackground(Color.RED);

        midPanel = new JPanel();
        //midPanel.setBounds(0,50,1000,50);
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        frame.add(midPanel, c);
        //midPanel.setBackground(Color.BLUE);

        bodyPanel = new JPanel();
        //bodyPanel.setBounds(0,100,1000,350);
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 10;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        frame.add(bodyPanel, c);
        //bodyPanel.setBackground(Color.GREEN);
        //bodyPanel.setOpaque(true);
        bodyPanel.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();

        //Header Panel Contents
        //Page Title
        pageTitle = new JLabel();
        pageTitle.setText("Job Seeker System"); //set text of page title
        pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
        pageTitle.setForeground(new Color(0, 0, 0)); //set text colour
        pageTitle.setOpaque(true);
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weightx = 5;
        c1.anchor = GridBagConstraints.LINE_START;
        c1.insets = new Insets(10, 10, 10, 100);
        headerPanel.add(pageTitle, c1);

        //Profile Icon
        profileIcon = new JButton();
        profileIcon.setText("Profile");
        profileIcon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        profileIcon.setForeground(new Color(0, 0, 0)); //set text colour
        profileIcon.setOpaque(true);
        profileIcon.setFocusable(false);
        c1.gridx = 15;
        c1.gridy = 0;
        c1.weightx = 0.1;
        c1.insets = new Insets(10, 10, 10, 10);
        headerPanel.add(profileIcon, c1);

        //Logout Icon
        logoutIcon = new JButton();
        logoutIcon.setText("Logout");
        logoutIcon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        logoutIcon.setForeground(new Color(0, 0, 0)); //set text colour
        logoutIcon.setOpaque(true);
        logoutIcon.setFocusable(false);
        c1.gridx = 16;
        c1.gridy = 0;
        c1.weightx = 0.1;
        c1.insets = new Insets(10, 10, 10, 10);
        headerPanel.add(logoutIcon, c1);

        //Mid Panel Contents
        progressBar = new JProgressBar();
        progressBar.setValue(50); //set initial value
        progressBar.setStringPainted(true);
        //progressBar.add(new JLabel("Account Details"));
        midPanel.add(progressBar);

        //Body Panel Contents
        //Body Title
        bodyTitle = new JLabel();
        bodyTitle.setText("Account Details"); //set text of page title
        bodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bodyTitle.setForeground(new Color(0, 0, 0)); //set text colour
        bodyTitle.setOpaque(true);
        c3.gridx = 0;
        c3.gridy = 0;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(bodyTitle, c3);

        //Mandatory message
        mandatory = new JLabel();
        mandatory.setText("*Denotes mandatory field"); //set text of page title
        mandatory.setFont(new Font("Tahoma", Font.ITALIC, 15));
        mandatory.setForeground(new Color(0, 0, 0)); //set text colour
        mandatory.setOpaque(true);
        mandatory.setHorizontalAlignment(JLabel.LEFT); //set page title left
        mandatory.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 4;
        c3.gridy = 0;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_END;
        bodyPanel.add(mandatory, c3);

        //First Name
        fName = new JLabel();
        fName.setText("First Name*:"); //set text of page title
        fName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        fName.setForeground(new Color(0, 0, 0)); //set text colour
        fName.setOpaque(true);
        fName.setHorizontalAlignment(JLabel.LEFT); //set page title left
        fName.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 0;
        c3.gridy = 2;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(fName, c3);

        //First Name Entry
        fNameEntry = new JTextField(20);
        c3.gridx = 1;
        c3.gridy = 2;
        c3.insets = new Insets(10, 10, 10, 10);
        bodyPanel.add(fNameEntry, c3);

        //Last Name
        lName = new JLabel();
        lName.setText("Last Name*:"); //set text of page title
        lName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lName.setForeground(new Color(0, 0, 0)); //set text colour
        lName.setOpaque(true);
        lName.setHorizontalAlignment(JLabel.LEFT); //set page title left
        lName.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 3;
        c3.gridy = 2;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(lName, c3);

        //Last Name Entry
        lNameEntry = new JTextField(20);
        c3.gridx = 4;
        c3.gridy = 2;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(lNameEntry, c3);

        //Email
        email = new JLabel();
        email.setText("Email Address*:"); //set text of page title
        email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        email.setForeground(new Color(0, 0, 0)); //set text colour
        email.setOpaque(true);
        email.setHorizontalAlignment(JLabel.LEFT); //set page title left
        email.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 0;
        c3.gridy = 3;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(email, c3);

        //Email Entry
        emailEntry = new JTextField(20);
        c3.gridx = 1;
        c3.gridy = 3;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(emailEntry, c3);

        //Company
        company = new JLabel();
        company.setText("Company:"); //set text of page title
        company.setFont(new Font("Tahoma", Font.PLAIN, 15));
        company.setForeground(new Color(0, 0, 0)); //set text colour
        company.setOpaque(true);
        company.setHorizontalAlignment(JLabel.LEFT); //set page title left
        company.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 3;
        c3.gridy = 3;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(company, c3);

        //Company Entry
        companyEntry = new JTextField(20);
        c3.gridx = 4;
        c3.gridy = 3;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(companyEntry, c3);

        //Password
        pw = new JLabel();
        pw.setText("Password*:"); //set text of page title
        pw.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pw.setForeground(new Color(0, 0, 0)); //set text colour
        pw.setOpaque(true);
        pw.setHorizontalAlignment(JLabel.LEFT); //set page title left
        pw.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 0;
        c3.gridy = 4;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(pw, c3);

        //Password Entry
        pwEntry = new JPasswordField(20);
        c3.gridx = 1;
        c3.gridy = 4;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(pwEntry, c3);

        //Password Confirm
        pwConfirm = new JLabel();
        pwConfirm.setText("Confirm password*:"); //set text of page title
        pwConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pwConfirm.setForeground(new Color(0, 0, 0)); //set text colour
        pwConfirm.setOpaque(true);
        pwConfirm.setHorizontalAlignment(JLabel.LEFT); //set page title left
        pwConfirm.setVerticalAlignment(JLabel.TOP); //set page title top
        //bodyTitle.setBounds(0,300, 100, 100);
        //bodyTitle.setLayout(new GridBagLayout());
        c3.gridx = 3;
        c3.gridy = 4;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(pwConfirm, c3);

        //Password Entry
        pwConfirmEntry = new JPasswordField(20);
        c3.gridx = 4;
        c3.gridy = 4;
        c3.insets = new Insets(10, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(pwConfirmEntry, c3);

        frame.pack();
        frame.setVisible(true); //make frame visible

        //Buttons
        leftButton = new JButton("Back");
        //leftButton.addActionListener(this);
        //leftButton.setBounds(0,900, 50, 30);
        leftButton.setSize(50, 30);
        leftButton.setFocusable(false);
        c3.gridx = 0;
        c3.gridy = 6;
        c3.gridwidth = 1;
        c3.insets = new Insets(50, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_START;
        bodyPanel.add(leftButton, c3);

        rightButton = new JButton("Continue");
        //rightButton.addActionListener(this);
        //rightButton.setBounds(950,900, 50, 30);
        rightButton.setSize(50, 30);
        rightButton.setFocusable(false);
        c3.gridx = 4;
        c3.gridy = 6;
        c3.gridwidth = 1;
        c3.insets = new Insets(50, 10, 10, 10);
        c3.anchor = GridBagConstraints.LINE_END;
        bodyPanel.add(rightButton, c3);

        // CardLayout la

    }

        /*

    public void actionPerformed(ActionEvent e) {
        card.next(bodyPanel);


    } */


//    public static void main (String[] args) {
//
//        SelectAccount account = new SelectAccount();
//    }
}