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
        this.add(pageTitle);

        this.add(Box.createHorizontalGlue());

        ImageIcon faceIcon = new ImageIcon("app/src/main/java/jss/faceButton.jpg");
        Image face = faceIcon.getImage();
        Image newFace = face.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newFaceIcon = new ImageIcon(newFace);
        JButton profileIcon = new JButton();
        profileIcon.setIcon(newFaceIcon);
        profileIcon.setContentAreaFilled(false);
        profileIcon.setBorder(BorderFactory.createEmptyBorder());
        profileIcon.setOpaque(false);
        this.add(profileIcon,2);

        this.add(Box.createRigidArea(new Dimension(10,0)));

        ImageIcon outIcon = new ImageIcon("app/src/main/java/jss/logoutButton.jpg");
        Image out = outIcon.getImage();
        Image newOut = out.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newLogoutIcon = new ImageIcon(newOut);
        JButton logoutIcon = new JButton();
        logoutIcon.setIcon(newLogoutIcon);
        logoutIcon.setContentAreaFilled(false);
        logoutIcon.setBorder(BorderFactory.createEmptyBorder());
        logoutIcon.setOpaque(false);
        this.add(logoutIcon, 4);

    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }

}