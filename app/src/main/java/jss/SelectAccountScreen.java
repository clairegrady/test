package jss;

import application.JobSeeker;
import application.Recruiter;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.naming.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SelectAccountScreen {
    private JPanel screen;
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
    private Recruiter recruiter;
    private JLabel text2;
    private JLabel bodyTitle2;
    private JPanel mainPanel2;
    private JButton backButton;
    private JButton proceedButton;
    private JButton profileButton;
    private JPanel buttonPanel;
    public static JFrame frame;

    SelectAccountScreen() {
        screen = new JPanel();
        screen.setLayout(new GridLayoutManager(4, 2, new Insets(15, 15, 15, 15), -1, -1));
        screen.setBackground(new Color(-6578528));

        /* Creation of the title pane - need to develop exit/logout buttons */
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.X_AXIS));
        screen.add(titlePanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        //Header Panel Contents
        //Page Title

        JLabel pageTitle = new JLabel("Job Seeker System");
        pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
        pageTitle.setHorizontalAlignment(JLabel.LEFT);
        pageTitle.setOpaque(true);
        titlePanel.add(pageTitle);

        titlePanel.add(Box.createHorizontalGlue());

        ImageIcon faceIcon = new ImageIcon("app/src/main/java/gui/profile.png");
        Image face = faceIcon.getImage();
        Image newFace = face.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newFaceIcon = new ImageIcon(newFace);
        JButton profileIcon = new JButton();
        profileIcon.setIcon(newFaceIcon);
        profileIcon.setOpaque(false);
        profileIcon.setContentAreaFilled(false);
        profileIcon.setBorder(BorderFactory.createEmptyBorder());
        titlePanel.add(profileIcon);

        ImageIcon outIcon = new ImageIcon("app/src/main/java/gui/logout.png");
        Image out = outIcon.getImage();
        Image newOut = out.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newLogoutIcon = new ImageIcon(newOut);
        JButton logoutIcon = new JButton();
        logoutIcon.setIcon(newLogoutIcon);
        logoutIcon.setOpaque(false);
        logoutIcon.setContentAreaFilled(false);
        logoutIcon.setBorder(BorderFactory.createEmptyBorder());
        titlePanel.add(logoutIcon);


        /* Initial creation of the main panel */
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 5, 5));
        mainPanel.setBackground(new Color(0xFFFFFF));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        screen.add(mainPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel mainPanel2 = new JPanel();
        mainPanel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 5, 5));
        mainPanel2.setBackground(new Color(0xFFFFFF));
        mainPanel2.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        mainPanel.setVisible(true);

        //Main contents 1
        //Body Title
        bodyTitle = new JLabel();
        bodyTitle.setText("Account Details"); //set text of page title
        bodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bodyTitle.setForeground(new Color(0, 0, 0)); //set text colour
        bodyTitle.setOpaque(false);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(bodyTitle, c);

        //Mandatory message
        mandatory = new JLabel();
        mandatory.setText("*Denotes mandatory field"); //set text of page title
        mandatory.setFont(new Font("Tahoma", Font.ITALIC, 10));
        mandatory.setForeground(new Color(0, 0, 0)); //set text colour
        mandatory.setOpaque(false);
        mandatory.setHorizontalAlignment(JLabel.LEFT); //set page title left
        mandatory.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(mandatory, c);

        //First Name
        fName = new JLabel();
        fName.setText("First Name*:"); //set text of page title
        fName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        fName.setForeground(new Color(0, 0, 0)); //set text colour
        fName.setOpaque(false);
        fName.setHorizontalAlignment(JLabel.LEFT); //set page title left
        fName.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(fName, c);

        //First Name Entry
        fNameEntry = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(fNameEntry, c);

        //Last Name
        lName = new JLabel();
        lName.setText("Last Name*:"); //set text of page title
        lName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lName.setForeground(new Color(0, 0, 0)); //set text colour
        lName.setOpaque(false);
        lName.setHorizontalAlignment(JLabel.LEFT); //set page title left
        lName.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(lName, c);

        //Last Name Entry
        lNameEntry = new JTextField(20);
        c.gridx = 4;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(lNameEntry, c);

        //Email
        email = new JLabel();
        email.setText("Email Address*:"); //set text of page title
        email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        email.setForeground(new Color(0, 0, 0)); //set text colour
        email.setOpaque(false);
        email.setHorizontalAlignment(JLabel.LEFT); //set page title left
        email.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(email, c);

        //Email Entry
        emailEntry = new JTextField(20);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(emailEntry, c);

        //Company
        company = new JLabel();
        company.setText("Company:"); //set text of page title
        company.setFont(new Font("Tahoma", Font.PLAIN, 15));
        company.setForeground(new Color(0, 0, 0)); //set text colour
        company.setOpaque(false);
        company.setHorizontalAlignment(JLabel.LEFT); //set page title left
        company.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 3;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(company, c);

        //Company Entry
        companyEntry = new JTextField(20);
        c.gridx = 4;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(companyEntry, c);

        //Password
        pw = new JLabel();
        pw.setText("Password*:"); //set text of page title
        pw.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pw.setForeground(new Color(0, 0, 0)); //set text colour
        pw.setOpaque(false);
        pw.setHorizontalAlignment(JLabel.LEFT); //set page title left
        pw.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(pw, c);

        //Password Entry
        pwEntry = new JPasswordField(20);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(pwEntry, c);

        //Password Confirm
        pwConfirm = new JLabel();
        pwConfirm.setText("Confirm password*:"); //set text of page title
        pwConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pwConfirm.setForeground(new Color(0, 0, 0)); //set text colour
        pwConfirm.setOpaque(false);
        pwConfirm.setHorizontalAlignment(JLabel.LEFT); //set page title left
        pwConfirm.setVerticalAlignment(JLabel.TOP); //set page title top
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(pwConfirm, c);

        //Password Entry
        pwConfirmEntry = new JPasswordField(20);
        c.gridx = 4;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(pwConfirmEntry, c);

        /* Creating the mid section between the tabs and the main display*/
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayoutManager(2, 1, new Insets(5, 15, 5, 15), -1, -1));
        midPanel.setBackground(new Color(-6578528));
        midPanel.setForeground(new Color(-16777216));
        screen.add(midPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setValue(50);
        midPanel.add(progressBar, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        //Main contents 2
        //Body Title
        bodyTitle2 = new JLabel();
        bodyTitle2.setText("Success!"); //set text of page title
        bodyTitle2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bodyTitle2.setForeground(new Color(0, 0, 0)); //set text colour
        bodyTitle2.setOpaque(false);
        c2.gridx = 0;
        c2.gridy = 0;
        c2.insets = new Insets(10, 10, 10, 10);
        c2.anchor = GridBagConstraints.LINE_START;
        mainPanel2.add(bodyTitle2, c2);

        //Success message
        text2 = new JLabel();
        text2.setText("You have registered as a Recruiter in the Job Seeker System"); //set text of page title
        text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        text2.setForeground(new Color(0, 0, 0)); //set text colour
        text2.setOpaque(false);
        text2.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text2.setVerticalAlignment(JLabel.TOP); //set page title top
        c2.gridx = 0;
        c2.gridy = 2;
        c2.insets = new Insets(10, 10, 10, 10);
        c2.anchor = GridBagConstraints.CENTER;
        mainPanel2.add(text2, c2);

        /*  Creating buttons*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 3, new Insets(5, 15, 5, 15), 0, 0));
        buttonPanel.setBackground(new Color(-6578528));
        screen.add(buttonPanel, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        backButton = new JButton("Back");
        //backButton.setActionCommand("Back");
        backButton.setFocusable(false);
        buttonPanel.add(backButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        proceedButton = new JButton("Create Account");
        //proceedButton.setActionCommand("Create Account");
        proceedButton.setFocusable(false);
        buttonPanel.add(proceedButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new GridLayoutManager(1, 3, new Insets(5, 15, 5, 15), 0, 0));
        buttonPanel2.setBackground(new Color(-6578528));

        JButton profileButton = new JButton("Go to Profile");
        //profileButton.setActionCommand("Go to Profile");
        profileButton.setFocusable(false);
        buttonPanel2.add(profileButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        //Creating the action listeners to change the tabs and refresh the main panel
        profileButton.addActionListener(e -> {
            screen.remove(mainPanel);
            screen.remove(midPanel);
            screen.remove(buttonPanel);
            screen.revalidate();
            screen.repaint();
        });
        proceedButton.addActionListener(e -> {
            screen.remove(mainPanel);
            screen.remove(buttonPanel);
            screen.add(mainPanel2, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
            screen.add(buttonPanel2, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
            progressBar.setValue(100);
            screen.revalidate();
            screen.repaint();
        });
    }

    public static Font getFont(int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName = currentFont.getName();
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    public JPanel getScreen() {
        return screen;
    }

    public void hideButtons(){
        backButton.setVisible(false);
        proceedButton.setVisible(false);
    }

    public static void initiate(){
        frame = new JFrame("Job Seeker System");
        SelectAccountScreen select = new SelectAccountScreen();
        frame.setContentPane(select.getScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400,300));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /*
    fetchJobs(int number) takes 1,2,3 based on tab selected and fetches jobs
    fetch job adds a job card each time and adds to a counter
    counter is used to know how many are being loaded
    changes text in label saying "You have such and such active jobs" */
    public static void openJobDetails(int job) {
        JFrame detailFrame = new JFrame("Job Details " + job);
        LoginScreen lScreen = new LoginScreen();
        detailFrame.setContentPane(lScreen.getScreen());
        detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailFrame.setSize(new Dimension(600,400));
        detailFrame.setLocationRelativeTo(null);
        detailFrame.setVisible(true);
    }

    public class JReferencingButton extends JButton{
        private int value;

        public int getJobNumber()
        {
            return this.value;
        }

        public void setJobNumber(int value)
        {
            this.value = value;
        }
    }

}