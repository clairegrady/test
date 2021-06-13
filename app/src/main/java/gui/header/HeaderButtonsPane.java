package gui.header;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HeaderButtonsPane extends JPanel {

    public HeaderButtonsPane() {
        super();
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(800,100));

        JLabel pageTitle = new JLabel("Job Seeker System");
        pageTitle.setHorizontalAlignment(JLabel.LEFT);

        this.add(Box.createRigidArea(new Dimension(40,0)));

        this.add(pageTitle);

        this.add(Box.createHorizontalGlue());

        
        JButton profileButton = new JButton();
        try {
            BufferedImage profileImage = ImageIO.read(getClass().getResource("/user.png"));
            Image scaledProfileImage = profileImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon profileIcon = new ImageIcon(scaledProfileImage);
            profileButton.setIcon(profileIcon);
            profileButton.setContentAreaFilled(false);
            profileButton.setBorder(BorderFactory.createEmptyBorder());
            profileButton.setOpaque(false);
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
        } catch (IOException ex){
            System.out.println(ex);
        }

        this.add(profileButton);
        
        this.add(Box.createRigidArea(new Dimension(15,0)));
        
        this.add(logoutButton);
        
        this.add(Box.createRigidArea(new Dimension(15,0)));

    }
}