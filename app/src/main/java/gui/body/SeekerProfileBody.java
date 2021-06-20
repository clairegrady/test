package gui.body;

import controller.NavigationController;
import controller.UserController;
import data.JobStatus;
import utility.GBC;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SeekerProfileBody extends JPanel {

    protected final NavigationController navigationController;
    protected final UserController userController;
    private java.util.List<String> skills;
    private java.util.List<String> location;
    private java.util.List<String> education;
    private JPanel detailsPane;
    private JScrollPane personalSummaryScrollPane;
    private JEditorPane personalSummaryPane;
    private JScrollPane skillsListScrollPane;
    private DefaultListModel<String> skillsListModel;
    private JScrollPane qualificationsListScrollPane;
    private DefaultListModel<String> qualificationsListModel;
//    private JLabel currentStatus;
    private JPanel personalDetailsPane;
    protected JPanel actionPane;
    protected JPanel editPane;
//    private String lastUpdatedDate;
    private String name;
//    private String byLine;
    private String personalSummary;
//    private String jobCategory;
//    private String employmentType;
//    private String payFloor;
//    private String payCeiling;


    public SeekerProfileBody(NavigationController navigationController, UserController userController) {
        super();
        this.navigationController = navigationController;
        this.userController = userController;
        this.createComponentPanes();
        this.skills = new ArrayList<>();
        this.location = new ArrayList<>();
        this.education = new ArrayList<>();
        displayPersonalDetails();
        this.setPersonalHeaderPaneComponents();
        this.setActionPaneComponents();
        this.setEditPaneComponents();
        this.setPersonalSummaryPaneComponents();
        this.setQualificationsListPaneComponents();
        this.setSkillsListPaneComponents();
        this.setDetailsPaneLayout();
    }


    private void createComponentPanes() {
        this.setLayout(new FlowLayout());
        detailsPane = new JPanel(new GridBagLayout());
        this.add(detailsPane);

        personalDetailsPane = new JPanel();
        personalDetailsPane.setBackground(Color.WHITE);

        personalSummaryPane = new JEditorPane();
        personalSummaryPane.setEditable(false);
        personalSummaryPane.setBackground(Color.WHITE);
        personalSummaryScrollPane = new JScrollPane(personalSummaryPane);
        personalSummaryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        personalSummaryScrollPane.setPreferredSize(new Dimension(500, 350));

        personalSummaryScrollPane.setBorder(BorderFactory.createTitledBorder("Job Description"));

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

    }

    protected void setEditPaneComponents() {
        editPane.setLayout(new BoxLayout(editPane, BoxLayout.PAGE_AXIS));

    }

    public void setPersonalHeaderPaneComponents() {
        personalDetailsPane.setLayout(new BoxLayout(personalDetailsPane, BoxLayout.PAGE_AXIS));

        JLabel nameLabel = new JLabel(name);
//        JLabel companyLabel = new JLabel(byLine);
        JLabel locationLabel = new JLabel(String.join(", ", location));
//        JLabel categoryLabel = new JLabel(jobCategory);
//        JLabel paymentLabel = new JLabel(payFloor + " - " + payCeiling + "  |  " + employmentType);

        nameLabel.setFont(new Font(null, Font.BOLD, 35));
//        companyLabel.setFont(new Font(null, Font.BOLD, 18));
        locationLabel.setFont(new Font(null, Font.PLAIN, 14));
//        categoryLabel.setFont(new Font(null, Font.PLAIN, 14));
//        paymentLabel.setFont(new Font(null, Font.PLAIN, 14));

        personalDetailsPane.add(nameLabel);
//        personalDetailsPane.add(companyLabel);
        personalDetailsPane.add(locationLabel);
//        personalDetailsPane.add(categoryLabel);
//        personalDetailsPane.add(paymentLabel);

    }

    protected void setPersonalSummaryPaneComponents() {
        personalSummaryPane.setText(personalSummary);
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

        detailsPane.add(personalDetailsPane,
                new GBC(0, 0)
                        .setWeight(0.6, 0)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(5));

        detailsPane.add(personalSummaryScrollPane,
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

    protected void displayPersonalDetails() {
        userController.setPersonalDetailsPaneInformation(this);
    }

    public void addPersonalDetials(String jobTitle, String company, String jobDescription, String jobCategory,
                              String employmentType, String payFloor, String payCeiling, java.util.List<String> locations,
                              java.util.List<String> skills, List<String> educationAndQualifications) {
        this.name = jobTitle;
        this.byLine = company;
        this.personalSummary = jobDescription;
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
