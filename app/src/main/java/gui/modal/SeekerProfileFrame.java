package gui.modal;

import application.JobSeeker;
import controller.NavigationController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class SeekerProfileFrame extends JFrame {

    private NavigationController navigationController;
    private UserController userController;
    private JobSeeker jobSeeker;
    private JDialog profileModal;
    private JPanel panel;
    private JTextArea messageText;

    public SeekerProfileFrame(NavigationController navigationController, UserController userController) {
        super();
        this.userController = userController;

        profileModal = new JDialog(this, "Job Seeker Profile",true);
        profileModal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        profileModal.setSize(900, 600);
        profileModal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        panel = new JPanel();
        setPosition(c,0,0,2,0,0,0,0);
        profileModal.add(panel,c);

        //Back Button
        JPanel buttonPanel = new JPanel();
        setPosition(c,1,1,1,30,0,0,0);
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        profileModal.add(buttonPanel, c);

        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        buttonPanel.add(backButton);

        buttonPanel.add(Box.createHorizontalGlue());

        JButton invite = new JButton("Send Invitation");
        invite.setFocusable(false);
        buttonPanel.add(invite);

        backButton.addActionListener(e-> profileModal.dispose());

        invite.addActionListener(e-> {
            SendInvitationModal modal = new SendInvitationModal(profileModal, jobSeeker, this.userController);
            modal.createInviteModal();
        });

    }

    public void displayProfile(JobSeeker jobSeeker){

    }


    public void setPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r){
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(t,l,b,r);
        c.anchor = GridBagConstraints.LINE_START;
    }

}