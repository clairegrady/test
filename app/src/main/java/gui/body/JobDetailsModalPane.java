package gui.body;

import controller.JobController;
import controller.NavigationController;

import javax.swing.*;

public class JobDetailsModalPane extends JobDetailsPane {

    private JButton applyButton;

    public JobDetailsModalPane(NavigationController navigationController, JobController jobController) {
        super(navigationController, jobController);


    }

    @Override
    protected void setActionPaneComponents() {

        this.actionPane = super.getActionPane();
        actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));
        applyButton = new JButton("Apply");

        applyButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,"Congratulations, you've applied for a job!");
        });
        actionPane.add(Box.createHorizontalGlue());
        actionPane.add(applyButton);
    }

    @Override
    protected void setEditPaneComponents() {


    }

    @Override
    protected void displayJobDetails() {
        this.jobController.setJobDetailsPaneInformation(this);
    }

}
