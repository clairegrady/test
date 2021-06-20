package gui.modal;

import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class SendInvitationModal {

    private JDialog profileModal;
    private JTextArea messageText;
    private UserController userController;

    public SendInvitationModal(JDialog profileModal, UserController userController) {
        this.profileModal = profileModal;
        this.userController = userController;
        createInviteModal();
    }

    public void createInviteModal() {
        JDialog inviteModal = new JDialog(profileModal, "Invitation",true);
        inviteModal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        inviteModal.setLocationRelativeTo(this.profileModal.getParent());
        inviteModal.setSize(600, 300);
        inviteModal.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        //Body Title
        JLabel bodyTitle = new JLabel("Job Seeker System");
        setPosition(c2,0,0, 3,0,0,0,0);
        inviteModal.add(bodyTitle, c2);

        JLabel sendTo = new JLabel("Send invitation to: " + userController.getProfileUserName());
        setPosition(c2,0,1, 2,10,0,0,0);
        inviteModal.add(sendTo, c2);

        JLabel forJob = new JLabel("For: ");
        setPosition(c2,0,3, 2,10,0,0,0);
        inviteModal.add(forJob, c2);

        JLabel message = new JLabel("Message: ");
        setPosition(c2,0,4, 1,10,0,0,0);
        c2.anchor = GridBagConstraints.PAGE_START;
        inviteModal.add(message, c2);

        messageText = new JTextArea();
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        JScrollPane msgScroll = new JScrollPane(messageText);
        msgScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        msgScroll.setPreferredSize((new Dimension(200,100)));
        setPosition(c2,1,4, 2,10,10,0,0);
        inviteModal.add(msgScroll, c2);

        //Back Button
        JPanel buttonPanel2 = new JPanel();
        setPosition(c2, 0, 8, 3,30,0,0,0);
        c2.anchor = GridBagConstraints.LINE_START;
        c2.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
        inviteModal.add(buttonPanel2, c2);

        JButton backButton2 = new JButton("Back");
        backButton2.setFocusable(false);
        buttonPanel2.add(backButton2);

        buttonPanel2.add(Box.createHorizontalGlue());

        JButton sendButton = new JButton("Send");
        sendButton.setFocusable(false);
        buttonPanel2.add(sendButton);

        backButton2.addActionListener(e-> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave without sending?", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                inviteModal.dispose();
            }
        });

        sendButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to send this invitation?", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                this.userController.sendInvitation(message.getText());
                inviteModal.dispose();
                profileModal.dispose();
                JOptionPane.showInternalMessageDialog(null, "Your invitation has been sent!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            };
        });

        inviteModal.setVisible(true);
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r){
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(t,l,b,r);
        c.anchor = GridBagConstraints.LINE_START;
    }
}
