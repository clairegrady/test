package gui.body;

import controller.JobController;
import controller.NavigationController;
import data.EmploymentType;
import data.JobStatus;
import utility.GBC;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//import java.awt.;


public class JobDetailsPane extends JPanel {

    protected final NavigationController navigationController;
    protected final JobController jobController;
    private List<String> skills;
    private List<String> location;
    private List<String> education;
    private JPanel detailsPane;
    private JScrollPane jobDescScrollPane;
    private JEditorPane jobDescriptionPane;
    private JScrollPane skillsListScrollPane;
    private DefaultListModel<String> skillsListModel;
    private JScrollPane qualificationsListScrollPane;
    private DefaultListModel<String> qualificationsListModel;
    private JLabel currentStatus;
    private JPanel jobTitlePane;
    protected JPanel actionPane;
    protected JPanel editPane;
    private String lastUpdatedDate;
    private String jobTitle;
    private String company;
    private String jobDescription;
    private String jobCategory;
    private String employmentType;
    private String payFloor;
    private String payCeiling;

    JobDetailsPane(NavigationController navigationController, JobController jobController) {
        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        this.createComponentPanes();
        this.skills = new ArrayList<>();
        this.location = new ArrayList<>();
        this.education = new ArrayList<>();
        displayJobDetails();
        this.setJobTitlePaneComponents();
        this.setActionPaneComponents();
        this.setEditPaneComponents();
        this.setJobDescriptionPaneComponents();
        this.setQualificationsListPaneComponents();
        this.setSkillsListPaneComponents();
        this.setDetailsPaneLayout();
    }


    private void createComponentPanes() {
        this.setLayout(new FlowLayout());
        detailsPane = new JPanel(new GridBagLayout());
        this.add(detailsPane);

        jobTitlePane = new JPanel();
        jobTitlePane.setBackground(Color.WHITE);

        jobDescriptionPane = new JEditorPane();
        jobDescriptionPane.setEditable(false);
        jobDescriptionPane.setBackground(Color.WHITE);
        jobDescScrollPane = new JScrollPane(jobDescriptionPane);
        jobDescScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        jobDescScrollPane.setPreferredSize(new Dimension(500, 350));

        jobDescScrollPane.setBorder(BorderFactory.createTitledBorder("Job Description"));

        editPane = new JPanel();
        editPane.setBackground(Color.WHITE);

        detailsPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsPane.setPreferredSize(new Dimension(900, 600));
        detailsPane.setBackground(Color.WHITE);

        skillsListModel = new DefaultListModel<>();
        JList<String> skillsList = new JList<>(skillsListModel);
        skillsListScrollPane = setUpScrollPane(skillsList);
        skillsListScrollPane.setPreferredSize(new Dimension(300, 180));
        skillsListScrollPane.setBorder(BorderFactory.createTitledBorder("Required Skills"));

        qualificationsListModel = new DefaultListModel<>();
        JList<String> qualificationsList = new JList<>(qualificationsListModel);
        qualificationsListScrollPane = setUpScrollPane(qualificationsList);
        qualificationsListScrollPane.setPreferredSize(new Dimension(300, 180));
        qualificationsListScrollPane.setBorder(BorderFactory.createTitledBorder("Required Education"));

        actionPane = new JPanel();
        actionPane.setPreferredSize(new Dimension(400, 30));
        actionPane.setBackground(Color.WHITE);
    }

    protected void setActionPaneComponents() {
        actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));

        JComboBox<EmploymentType> publishStatusSelector = new JComboBox<>();
        publishStatusSelector.setSelectedIndex(JobStatus.getIndexOfValue(jobController.getJobListingStatus()));
        JButton publishButton = new JButton("Update Status");
        publishButton.addActionListener(e -> jobController.updateJobListingStatus(this, publishStatusSelector.getSelectedItem().toString()));

        actionPane.add(publishStatusSelector);
        actionPane.add(Box.createHorizontalGlue());
        actionPane.add(publishButton);

    }

    public void updateCurrentStatus(String currentStatus, Color colour) {
        this.currentStatus.setText(currentStatus);
        this.currentStatus.setForeground(colour);
    }

    protected void setEditPaneComponents() {
        editPane.setLayout(new BoxLayout(editPane, BoxLayout.PAGE_AXIS));

        JLabel lastUpdated = new JLabel(" last updated: " + lastUpdatedDate);
        this.currentStatus = new JLabel(jobController.getJobListingStatus());
        this.currentStatus.setForeground(jobController.getStatusColour());
        this.currentStatus.setFont(new Font(null, Font.ITALIC, 20));
        this.currentStatus.setBorder(new EmptyBorder(0,0,20,0));
        JButton editButton = new JButton("Edit");

        editPane.add(this.currentStatus);
        editPane.add(editButton);
        editPane.add(lastUpdated);


        lastUpdated.setAlignmentX(Box.RIGHT_ALIGNMENT);
        editButton.setAlignmentX(Box.RIGHT_ALIGNMENT);
        this.currentStatus.setAlignmentX(Box.RIGHT_ALIGNMENT);

        editButton.addActionListener(e -> {
            navigationController.setBody("CREATEJOB");
        });
    }

    public void setJobTitlePaneComponents() {
        jobTitlePane.setLayout(new BoxLayout(jobTitlePane, BoxLayout.PAGE_AXIS));

        JLabel jobTitleLabel = new JLabel(jobTitle);
        JLabel companyLabel = new JLabel(company);
        JLabel locationLabel = new JLabel(String.join(", ", location));
        JLabel categoryLabel = new JLabel(jobCategory);
        JLabel paymentLabel = new JLabel(payFloor + " - " + payCeiling + "  |  " + employmentType);

        jobTitleLabel.setFont(new Font(null, Font.BOLD, 35));
        companyLabel.setFont(new Font(null, Font.BOLD, 18));
        locationLabel.setFont(new Font(null, Font.PLAIN, 14));
        categoryLabel.setFont(new Font(null, Font.PLAIN, 14));
        paymentLabel.setFont(new Font(null, Font.PLAIN, 14));

        jobTitlePane.add(jobTitleLabel);
        jobTitlePane.add(companyLabel);
        jobTitlePane.add(locationLabel);
        jobTitlePane.add(categoryLabel);
        jobTitlePane.add(paymentLabel);

    }

    protected void setJobDescriptionPaneComponents() {
        jobDescriptionPane.setText(jobDescription);
    }

    protected JScrollPane setUpScrollPane(JList list) {
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setFocusable(false);
        return new JScrollPane(list);
    }

    protected void setQualificationsListPaneComponents() {
        for (String eduElement : education) {
            qualificationsListModel.addElement(eduElement);
        }
    }

    protected void setSkillsListPaneComponents() {
        for (String skill : skills) {
            skillsListModel.addElement(skill);
        }
    }

    private void setDetailsPaneLayout() {

        detailsPane.add(jobTitlePane,
                new GBC(0, 0)
                        .setWeight(0.6, 0)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));

        detailsPane.add(jobDescScrollPane,
                new GBC(0, 1)
                        .setWeight(0.6, 3.0)
                        .setSpan(1, 3)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));

        detailsPane.add(editPane,
                new GBC(1, 0)
                        .setWeight(0.3, 0)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));

        detailsPane.add(skillsListScrollPane,
                new GBC(1, 1)
                        .setWeight(0.3, 1.0)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));

        detailsPane.add(qualificationsListScrollPane,
                new GBC(1, 2)
                        .setWeight(0.3, 1.0)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));

        detailsPane.add(actionPane,
                new GBC(1, 3)
                        .setWeight(0.3, 0)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));
    }

    protected void displayJobDetails() {
        jobController.setJobDetailsPaneInformation(this);
        jobController.setViewLastUpdatedDate(this);
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void addJobDetails(String jobTitle, String company, String jobDescription, String jobCategory,
                              String employmentType, String payFloor, String payCeiling, List<String> locations,
                              List<String> skills, List<String> educationAndQualifications) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.jobDescription = jobDescription;
        this.jobCategory = jobCategory;
        this.employmentType = employmentType;
        this.payFloor = payFloor;
        this.payCeiling = payCeiling;
        this.location = locations;
        this.skills = skills;
        this.education = educationAndQualifications;
    }

    protected JPanel getActionPane() {
        return actionPane;
    }

    protected JPanel getEditPane() {
        return editPane;
    }

}