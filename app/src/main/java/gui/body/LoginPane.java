package gui.body;

import controller.BodyViewController;
import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginPane extends JPanel {

    private final BodyViewController bvc;
    private final LoginController lc;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginPane(BodyViewController bvc, LoginController lc) {
        super();
        this.setLayout(new BorderLayout());
        this.bvc = bvc;
        this.lc = lc;

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(new GridBagLayout());
        featurePanel.setSize(new Dimension(600, 300));
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

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
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
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
                passwordField.putClientProperty("JComponent.outline", Color.blue);
                loginButton.setEnabled(emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0);
            }
        });
        passwordField.addActionListener(e -> validateUser());

        loginButton.addActionListener(e -> validateUser());

        registerButton.addActionListener(e -> lc.chooseAccount());
    }

    public void validateUser() {

        if (lc.validateLogin(emailField.getText(), String.valueOf(passwordField.getPassword()))) {
            passwordField.setText("");
            emailField.setText("");
            loginButton.setEnabled(false);
            bvc.loginComplete(lc.getUserType());
        }
        else {
            loginDetailsInvalid();
        }
    }

    public void loginDetailsInvalid(){
        System.out.println("invalid credentials");
        passwordField.putClientProperty("JComponent.outline", "error");
        passwordField.setText("");
        emailField.selectAll();
        loginButton.setEnabled(false);
    }
}
