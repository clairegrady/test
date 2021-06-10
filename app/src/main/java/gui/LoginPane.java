package gui;

import controller.BodyViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginPane extends JPanel {

    private final BodyViewController bvc;

    public LoginPane(BodyViewController bvc) {
        super();
        this.setLayout(new BorderLayout());
        this.bvc = bvc;

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(new GridBagLayout());
        featurePanel.setSize(new Dimension(600, 300));
        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.EAST;
        featurePanel.add(new JLabel("Username: "), gbc);
        gbc.gridy++;
        featurePanel.add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        featurePanel.add(emailField, gbc);
        gbc.gridy++;
        featurePanel.add(passwordField, gbc);

        this.add(featurePanel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        loginButton.setEnabled(false);
        this.add(buttonPanel,BorderLayout.CENTER);

        JPanel forgotLoginPanel = new JPanel();
        forgotLoginPanel.add(new JLabel("Forgot your password?"));
        this.add(forgotLoginPanel, BorderLayout.SOUTH);

        //TODO fix the layout management on the Login Page -> Probably needs a box

        emailField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { //watch for key strokes
                loginButton.setEnabled(emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e2) { //watch for key strokes
                loginButton.setEnabled(emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0);
            }
        });
        loginButton.addActionListener(e -> validateUser(emailField.getText(), String.valueOf(passwordField.getPassword())));
    }

    public void validateUser(String email, String password) {
        /*
        DataStore check = new DataStore();
        List<User> users = check.getAllUsers();
        users.forEach(user -> {
           if (user.getEmail().equals(email)){
               if (user.getPassword().equals(password)){
                   if (user instanceof Recruiter){
                       RecruiterScreen.initiate(user);
                       frame.dispose();
                   }
               }
           }
           else {
               // FailScreen.initiate();
               frame.dispose();
               initiate();
           }
        });
        */
        // User recruiter = new Recruiter(email, password, password, "Smith", "MacroSoft");
        bvc.loginComplete(true);
    }
}