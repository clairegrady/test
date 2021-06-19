//package gui.modal;
//
//import controller.NavigationController;
//
//import javax.swing.*;
//
//public class InvitationFrame extends JFrame {
//
//    private NavigationController navigationController;
//    private JDialog inviteModal;
//    private JPanel panel;
//
//    public InvitationFrame(NavigationController navigationController) {
//        super();
//
//        inviteModal = new JDialog(this, "Send Invitation",true);
//        inviteModal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        inviteModal.setSize(600, 300);
//        //profileModal.setLayout(null);
//        inviteModal.setVisible(true);
//        panel = new JPanel();
//        inviteModal.add(panel);
//    }
//
//    public void displayProfile(JPanel p){
//        panel.add(p);
//    }
//
//}