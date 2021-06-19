package gui.body.progressView;

import application.Validation;
import com.intellij.uiDesigner.core.GridConstraints;
import controller.NavigationController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateAccountScreen extends JPanel {
    private final JProgressBar progressBar;
    private final JTextField fNameEntry;
    private final JTextField lNameEntry;
    private final JTextField emailEntry;
    private JTextField companyEntry;
    private final JPasswordField pwEntry;
    private final JPasswordField pwConfirmEntry;
    private final JButton proceedButton;

    public CreateAccountScreen(NavigationController navigationController, UserController userController, Boolean recruiter) {

        super();


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
        setPosition(c, 0, 1, 1, 0, 0, 0, 0);
        createPanel.add(bodyTitle, c);

        //Mandatory message
        JLabel mandatory = new JLabel("*Denotes mandatory field");
        setTextPosition(mandatory);
        setPosition(c, 1, 1, 1, 0, 0, 0, 0);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        createPanel.add(mandatory, c);

        //First Name
        JLabel fName = new JLabel("First Name*:");
        setTextPosition(fName);
        setPosition(c, 0, 2, 1, 10, 10, 0, 10);
        createPanel.add(fName, c);

        //First Name Entry
        fNameEntry = new JTextField(20);
        setPosition(c, 0, 3, 1, 0, 10, 0, 10);
        createPanel.add(fNameEntry, c);

        //Last Name
        JLabel lName = new JLabel("Last Name*:");
        setTextPosition(lName);
        setPosition(c, 1, 2, 1, 10, 10, 0, 10);
        createPanel.add(lName, c);

        //Last Name Entry
        lNameEntry = new JTextField(20);
        setPosition(c, 1, 3, 1, 0, 10, 0, 10);
        createPanel.add(lNameEntry, c);

        //Email
        JLabel email = new JLabel("Email Address*:");
        setTextPosition(email);
        setPosition(c, 0, 4, 1, 10, 10, 0, 10);
        createPanel.add(email, c);

        //Email Entry
        emailEntry = new JTextField(20);
        setPosition(c, 0, 5, 1, 0, 10, 0, 10);
        createPanel.add(emailEntry, c);

        if(recruiter) {
            //Company
            JLabel company = new JLabel("Company:");
            setTextPosition(company);
            setPosition(c, 1, 4, 1, 10, 10, 0, 10);
            createPanel.add(company, c);

            //Company Entry
            companyEntry = new JTextField(20);
            companyEntry.setText("");
            setPosition(c, 1, 5, 1, 0, 10, 0, 10);
            createPanel.add(companyEntry, c);
        }

        //Password
        JLabel pw = new JLabel("Password*:");
        setTextPosition(pw);
        setPosition(c, 0, 6, 1, 10, 10, 0, 10);
        createPanel.add(pw, c);

        //Password Entry
        pwEntry = new JPasswordField(20);
        setPosition(c, 0, 7, 1, 0, 10, 0, 10);
        createPanel.add(pwEntry, c);

        //Password Confirm
        JLabel pwConfirm = new JLabel("Confirm Password*:");
        setTextPosition(pwConfirm);
        setPosition(c, 1, 6, 1, 10, 10, 0, 10);
        createPanel.add(pwConfirm, c);

        //Password Entry
        pwConfirmEntry = new JPasswordField(20);
        setPosition(c, 1, 7, 1, 0, 10, 0, 10);
        createPanel.add(pwConfirmEntry, c);

        //Back Button
        JPanel buttonPanel = new JPanel();
        setPosition(c, 0, 9, 2, 50, 0, 0, 0);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        createPanel.add(buttonPanel, c);

        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        buttonPanel.add(backButton);

        buttonPanel.add(Box.createHorizontalGlue());

        //Proceed Button
        proceedButton = new JButton("Create Account");
        proceedButton.setFocusable(false);
        proceedButton.setEnabled(false);
        buttonPanel.add(proceedButton);

        //Mandatory fields
        addMandatory(fNameEntry);
        addMandatory(lNameEntry);
        addMandatory(pwEntry);
        addMandatory(pwConfirmEntry);
        addMandatory(emailEntry);

        //Progress Panel
        progressBar = new JProgressBar();
        progressBar.setStringPainted(false);
        progressBar.setValue(50);
        progressBar.putClientProperty("JProgressBar.square", true);
        progressBar.putClientProperty("JProgressBar.largeHeight", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        setPosition(c, 0, 0, 2, 0, 0, 0, 0);
        createPanel.add(progressBar, c);

        // //Main Panel - Card 2
        //Body Title
        JLabel bodyTitle2 = new JLabel("Success");
        setTextPosition(bodyTitle2);
        setPosition(c2, 0, 1, 1, 0, 0, 0, 0);
        successPanel.add(bodyTitle2, c2);

        //Success message
        JLabel text2 = new JLabel("You have registered as a Recruiter in the Job Seeker System");
        setTextPosition(text2);
        setPosition(c2, 0, 2, 2, 20, 0, 0, 0);
        successPanel.add(text2, c2);

        //Go to Profile Button
        JPanel buttonPanel2 = new JPanel();
        setPosition(c2, 0, 3, 2, 50, 0, 0, 0);
        c2.fill = GridBagConstraints.NONE;
        c2.anchor = GridBagConstraints.LINE_END;
        buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
        successPanel.add(buttonPanel2, c2);

        JButton profileButton = new JButton("Go to Profile");
        profileButton.setFocusable(false);
        buttonPanel2.add(profileButton);

        profileButton.addActionListener(e -> {
            userController.validateLogin(emailEntry.getText(), String.valueOf(pwEntry.getPassword()));
            clearUserDetails(recruiter);
            navigationController.loginComplete(userController.getUserType());
        });

        backButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave without saving?", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                navigationController.setBody("CHOOSE");
                navigationController.setHeader("LOGIN");
                clearUserDetails(recruiter);
            }
        });

        proceedButton.addActionListener(e -> {
            if (!Validation.validName(fNameEntry.getText()) || !Validation.validName(lNameEntry.getText())){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Name entry fields must only contain letters.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!Validation.validEmail(emailEntry.getText())) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Email must be a valid entry.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (Validation.emailExists(emailEntry.getText())) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!String.valueOf(pwEntry.getPassword()).equals(String.valueOf(pwConfirmEntry.getPassword()))) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Password and confirm password must match.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (String.valueOf(pwEntry.getPassword()).length() < 8) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to create this account?", "Message", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.setPage("SUCCESS");
                progressBar.setValue(100);
                successPanel.add(progressBar, c);
                if (recruiter) {
                userController.createRecruiter(
                        emailEntry.getText(),
                        String.valueOf(pwEntry.getPassword()),
                        fNameEntry.getText(),
                        lNameEntry.getText(),
                        companyEntry.getText());
                }
                else {
                    userController.createSeeker(
                            emailEntry.getText(),
                            String.valueOf(pwEntry.getPassword()),
                            fNameEntry.getText(),
                            lNameEntry.getText()
                    );
                }
            }
        });
    }

    public void addMandatory(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e2) { //watch for key strokes
                proceedButton.setEnabled((fNameEntry.getText().length() > 0 && String.valueOf(pwEntry.getPassword()).length() > 0) && (String.valueOf(pwConfirmEntry.getPassword()).length() > 0 && lNameEntry.getText().length() > 0) && emailEntry.getText().length() > 0);
            }
        });
    }

    public void setPage(String page) {
        CardLayout createAccount = (CardLayout) (this.getLayout());
        createAccount.show(this, page);
    }

    public void clearUserDetails(boolean recruiter) {
        fNameEntry.setText("");
        lNameEntry.setText("");
        emailEntry.setText("");
        if(recruiter){
        companyEntry.setText("");
        }
        pwEntry.setText("");
        pwConfirmEntry.setText("");
    }

    public void setTextPosition(JLabel text) {
        text.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text.setVerticalAlignment(JLabel.TOP); //set page title top
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r) {
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(t, l, b, r);
    }

}