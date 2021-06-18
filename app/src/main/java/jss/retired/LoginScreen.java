package jss.retired;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gui.MainFrame;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;

public class LoginScreen {
    public static MainFrame frame;
    private final JPanel screen;

    public LoginScreen() {
        screen = new JPanel();
        screen.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        screen.setBackground(new Color(-6578528));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        titlePanel.setBackground(new Color(-6578528));
        screen.add(titlePanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JLabel titleText = new JLabel();
        titleText.setBackground(new Color(-6578528));
        Font titleTextFont = this.getFont(Font.BOLD, 20, titleText.getFont());
        if (titleTextFont != null) titleText.setFont(titleTextFont);
        titleText.setForeground(new Color(-16777216));
        titleText.setText("Job Seeker Service");
        titlePanel.add(titleText, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(new GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        featurePanel.setBackground(new Color(-6578528));
        screen.add(featurePanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JLabel emailLabel = new JLabel();
        emailLabel.setBackground(new Color(-6578528));
        emailLabel.setForeground(new Color(-16777216));
        emailLabel.setText("Email:");
        featurePanel.add(emailLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBackground(new Color(-6578528));
        passwordLabel.setForeground(new Color(-16777216));
        passwordLabel.setText("Password:");
        featurePanel.add(passwordLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JTextField emailField = new JTextField();
        emailField.setBackground(new Color(-1181441));
        emailField.setForeground(new Color(-16777216));
        featurePanel.add(emailField, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(new Color(-1181441));
        passwordField.setForeground(new Color(-16777216));
        featurePanel.add(passwordField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));

        final Spacer spacer1 = new Spacer();
        featurePanel.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        featurePanel.add(spacer2, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        featurePanel.add(spacer3, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        featurePanel.add(spacer4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        featurePanel.add(spacer5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        featurePanel.add(spacer6, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        buttonPanel.setBackground(new Color(-6578528));
        screen.add(buttonPanel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JButton loginButton = new JButton();
        loginButton.setBackground(new Color(-1181441));
        loginButton.setForeground(new Color(-16777216));
        loginButton.setText("Login");
        buttonPanel.add(loginButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JButton registerButton = new JButton();
        registerButton.setBackground(new Color(-1181441));
        registerButton.setForeground(new Color(-16777216));
        registerButton.setText("Register");
        buttonPanel.add(registerButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final Spacer spacer7 = new Spacer();
        buttonPanel.add(spacer7, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        buttonPanel.add(spacer8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        JPanel forgotLoginPanel = new JPanel();
        forgotLoginPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        forgotLoginPanel.setBackground(new Color(-6578528));

        Font forgotLoginPanelFont = this.getFont(Font.ITALIC, 8, forgotLoginPanel.getFont());
        if (forgotLoginPanelFont != null) forgotLoginPanel.setFont(forgotLoginPanelFont);
        screen.add(forgotLoginPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JLabel forgotLoginText = new JLabel();
        forgotLoginText.setBackground(new Color(-6578528));

        Font forgotLoginTextFont = this.getFont(Font.ITALIC, 8, forgotLoginText.getFont());
        if (forgotLoginTextFont != null) forgotLoginText.setFont(forgotLoginTextFont);
        forgotLoginText.setForeground(new Color(-16772165));
        forgotLoginText.setHorizontalAlignment(0);
        forgotLoginText.setHorizontalTextPosition(0);
        forgotLoginText.setText("Forgot your password?");
        forgotLoginPanel.add(forgotLoginText, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final Spacer spacer9 = new Spacer();
        forgotLoginPanel.add(spacer9, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        loginButton.setEnabled(false);

        emailField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { //watch for key strokes
                if (emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0) {
                    loginButton.setEnabled(true);
                } else loginButton.setEnabled(false);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e2) { //watch for key strokes
                if (emailField.getText().length() > 0 && String.valueOf(passwordField.getPassword()).length() > 0) {
                    loginButton.setEnabled(true);
                } else loginButton.setEnabled(false);
            }
        });

        loginButton.addActionListener(e -> {
            validateUser(emailField.getText(), String.valueOf(passwordField.getPassword()));
        });
    }

    public static void initiate() {
        LoginScreen login = new LoginScreen();
        frame.setContentPane(login.getScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void validateUser(String email, String password) {
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
//        User recruiter = new Recruiter(email, password, password, "Smith", "MacroSoft");
//        RecruiterScreen.initiate(recruiter);
//        frame.dispose();
    }

    private Font getFont(int style, int size, Font currentFont) {
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
}