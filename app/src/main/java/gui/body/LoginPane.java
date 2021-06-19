package gui.body;

import controller.NavigationController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginPane extends JPanel {

    private final NavigationController navigationController;
    private final UserController lc;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginPane(NavigationController navigationController, UserController lc) {
        super();
        this.setLayout(new BorderLayout());
        this.navigationController = navigationController;
        this.lc = lc;

        JPanel featurePanel = new JPanel();
        featurePanel.setSize(new Dimension(600, 200));
        featurePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel username = new JLabel("Username: ");
        setPosition(gbc, 0, 1, 1, 0, 0, 0, 0);
        featurePanel.add(username, gbc);

        emailField = new JTextField(20);
        setPosition(gbc, 0, 2, 3, 0, 0, 0, 0);
        featurePanel.add(emailField, gbc);

        JLabel password = new JLabel("Password: ");
        setPosition(gbc, 0, 3, 1, 10, 0, 0, 0);
        featurePanel.add(password, gbc);

        passwordField = new JPasswordField(20);
        setPosition(gbc, 0, 4, 3, 0, 0, 0, 0);
        featurePanel.add(passwordField, gbc);

        JButton forgotButton = new JButton("Forgot your password?");
        setButtonPosition(gbc, 0, 5, 3, 10, 0, 50, 0);
        forgotButton.setContentAreaFilled(false);
        forgotButton.setBorder(BorderFactory.createEmptyBorder());
        forgotButton.setOpaque(false);
        featurePanel.add(forgotButton, gbc);

        JPanel buttonPanel = new JPanel();
        setPosition(gbc, 0, 6, 3, 0, 0, 0, 0);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        featurePanel.add(buttonPanel, gbc);

        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        loginButton.setEnabled(false);

        buttonPanel.add(Box.createHorizontalGlue());

        registerButton = new JButton("Register");
        buttonPanel.add(registerButton);

        this.add(featurePanel, BorderLayout.CENTER);


        emailField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { //watch for key strokes
                loginButton.setEnabled(emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e2) { //watch for key strokes
                passwordField.putClientProperty("JComponent.outline", null);
                loginButton.setEnabled(emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0);
            }
        });
        passwordField.addActionListener(e -> validateUser());

        forgotButton.addActionListener(e -> {
            forgotButton.setForeground(Color.BLUE);
            JOptionPane.showMessageDialog(null, "Please contact Job Seeker System administrator.");
        });

        loginButton.addActionListener(e -> validateUser());

        registerButton.addActionListener(e -> navigationController.setBody("CHOOSE"));
    }

    public void validateUser() {

        if (lc.validateLogin(emailField.getText(), String.valueOf(passwordField.getPassword()))) {
            passwordField.setText("");
            emailField.setText("");
            loginButton.setEnabled(false);
            navigationController.loginComplete(lc.getUserType());
        } else {
            loginDetailsInvalid();
        }
    }

    public void loginDetailsInvalid() {
        System.out.println("invalid credentials");
        passwordField.putClientProperty("JComponent.outline", "error");
        passwordField.setText("");
        emailField.selectAll();
        loginButton.setEnabled(false);
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
