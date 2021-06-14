package gui.header;

import application.User;
import controller.HeaderViewController;
import data.DataStore;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

public class HeaderPane extends JPanel {

    private JLabel pageTitle;
    private HeaderViewController hvc;

    public HeaderPane(HeaderViewController hvc, boolean showButtons, String title) {
        super();
        this.hvc = hvc;
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(800,100));

        ImageIcon logo = new ImageIcon();

        try {
            BufferedImage logoImage = ImageIO.read(getClass().getResource("/logo.png")); // ADD ICON
            Image scaledLogoImage = logoImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
            logo = new ImageIcon(scaledLogoImage);
        } catch (IOException ex){
            System.out.println(ex);
        }

        pageTitle = new JLabel(title, logo, JLabel.LEFT);
        pageTitle.setHorizontalAlignment(JLabel.LEFT);

        this.add(Box.createRigidArea(new Dimension(30,0)));

        this.add(pageTitle);

        this.add(Box.createHorizontalGlue());

        if (showButtons){
//            this.add(getButtons(this.hvc));
            this.add(getButtons());
        }
    }

    public void changeTitle(String newTitle){
        pageTitle.setText(newTitle);
    }

//    public JPanel getButtons(HeaderViewController hvc){
    public JPanel getButtons(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        JLabel welcomeLabel = new JLabel();

        Optional<User> u = DataStore.getDatastore().getUserById(hvc.getMainFrame().getBVC().getLoggedInUser());
        welcomeLabel.setText("Welcome " + (u.isPresent() ? u.get().getFirstName() : "User"));

        JButton profileButton = new JButton();
        try {
            BufferedImage profileImage = ImageIO.read(getClass().getResource("/user.png"));
            Image scaledProfileImage = profileImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon profileIcon = new ImageIcon(scaledProfileImage);
            profileButton.setIcon(profileIcon);
            profileButton.setContentAreaFilled(false);
            profileButton.setBorder(BorderFactory.createEmptyBorder());
            profileButton.setOpaque(false);
            profileButton.setBorder(BorderFactory.createRaisedBevelBorder());
        } catch (IOException ex){
            System.out.println(ex);
        }

        JButton logoutButton = new JButton();
        try {
            BufferedImage logoutImage = ImageIO.read(getClass().getResource("/exit.png"));
            Image scaledLogoutImage = logoutImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon LogoutIcon = new ImageIcon(scaledLogoutImage);
            logoutButton.setIcon(LogoutIcon);
            logoutButton.setContentAreaFilled(false);
            logoutButton.setBorder(BorderFactory.createEmptyBorder());
            logoutButton.setOpaque(false);
            logoutButton.setBorder(BorderFactory.createRaisedBevelBorder());
            logoutButton.addActionListener(e -> {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Message",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) hvc.logOut(true);
            });

        } catch (IOException ex){
            System.out.println(ex);
        }
        buttonPanel.add(welcomeLabel);
        buttonPanel.add(Box.createRigidArea(new Dimension(30,0)));
        buttonPanel.add(profileButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(15,0)));
        buttonPanel.add(logoutButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(15,0)));

        return buttonPanel;
    }
}