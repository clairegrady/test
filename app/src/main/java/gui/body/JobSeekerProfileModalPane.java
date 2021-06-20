package gui.body;

import controller.NavigationController;
import controller.UserController;
import gui.modal.SendInvitationModal;

import javax.swing.*;

public class JobSeekerProfileModalPane extends SeekerProfileBody {

    private JPanel actionPane;

    public JobSeekerProfileModalPane(NavigationController navigationController, UserController userController) {
        super(navigationController, userController);
    }

    @Override
    protected void displayPersonalDetails() {
        userController.setSeekerProfileInformation(this);
    }


    @Override
    protected void setActionPaneComponents() {
        this.actionPane = super.getActionPane();
        actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));
        JButton inviteButton = new JButton("Invite");
        inviteButton.addActionListener(e -> new SendInvitationModal(new JDialog(),userController));
        actionPane.add(Box.createHorizontalGlue());
        actionPane.add(inviteButton);
    }
}
