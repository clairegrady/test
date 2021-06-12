package gui.header;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import jss.LoginScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class RecruiterHeader extends JPanel {

    public RecruiterHeader(JFrame frame, String firstName){

        /* Title panel */
        setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));
        setBackground(new Color(-6578528));
        setForeground(new Color(-16777216));

        JLabel titleLabel = new JLabel();
        Font titleLabelFont = getFont(Font.BOLD, 24, titleLabel.getFont());
        if (titleLabelFont != null) titleLabel.setFont(titleLabelFont);
        titleLabel.setForeground(new Color(-16777216));
        titleLabel.setText("Job Seeker System - Recruiter");
        add(titleLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayoutManager(1, 4, new Insets(5, 15, 5, 15), -1, -1));
        optionsPanel.setBackground(new Color(-6578528));

        add(optionsPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

        /* Logout button */
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(RecruiterHeader.class.getResource("logoutButton.jpg").getFile()));
        } catch (
                IOException ignored) {
        }
        JButton logoutButton = new JButton();
        ImageIcon logoutIcon = new ImageIcon(img);
        logoutButton.setIcon(logoutIcon);
        logoutButton.setBorderPainted(false);
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.addActionListener(logout -> {
            frame.dispose();
            LoginScreen.initiate();

        });
        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        logoutPanel.add(logoutButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        optionsPanel.add(logoutPanel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));


        /* Face button */
        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File(RecruiterHeader.class.getResource("faceButton.jpg").getFile()));
        } catch (IOException ignored) {
        }
        JButton profileButton = new JButton();
        ImageIcon profileIcon = new ImageIcon(img2);
        profileButton.setIcon(profileIcon);
        logoutButton.setBorderPainted(false);
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        profilePanel.add(profileButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        optionsPanel.add(profilePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        /* Welcome text */
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        welcomePanel.setBackground(new Color(-6578528));
        optionsPanel.add(welcomePanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setForeground(new Color(-16777216));
        welcomeLabel.setText("Welcome " + firstName);
        welcomePanel.add(welcomeLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        optionsPanel.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    public static Font getFont(int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName = currentFont.getName();
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }
}
