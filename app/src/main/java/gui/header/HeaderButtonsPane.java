package gui.header;

import javax.swing.*;
import java.awt.*;

public class HeaderButtonsPane extends JPanel {

    public HeaderButtonsPane() {
        super();
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        JLabel pageTitle = new JLabel("Job Seeker System");
        pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
        pageTitle.setHorizontalAlignment(JLabel.LEFT);
        pageTitle.setOpaque(true);
        this.add(pageTitle);

        this.add(Box.createHorizontalGlue());

        ImageIcon faceIcon = new ImageIcon("app/src/main/java/gui/profile.png");
        Image face = faceIcon.getImage();
        Image newFace = face.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newFaceIcon = new ImageIcon(newFace);
        JButton profileIcon = new JButton();
        profileIcon.setIcon(newFaceIcon);
        profileIcon.setOpaque(false);
        profileIcon.setContentAreaFilled(false);
        profileIcon.setBorder(BorderFactory.createEmptyBorder());
        this.add(profileIcon);

        ImageIcon outIcon = new ImageIcon("app/src/main/java/gui/logout.png");
        Image out = outIcon.getImage();
        Image newOut = out.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newLogoutIcon = new ImageIcon(newOut);
        JButton logoutIcon = new JButton();
        logoutIcon.setIcon(newLogoutIcon);
        logoutIcon.setOpaque(false);
        logoutIcon.setContentAreaFilled(false);
        logoutIcon.setBorder(BorderFactory.createEmptyBorder());
        this.add(logoutIcon);

    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }

}