package gui.body;

import controller.NavigationController;
import gui.body.searchBar.JobViewPane;
import utility.GBC;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;


public class JobDetailsPane extends JPanel implements ListSelectionListener {

    private final NavigationController navigationController;
    private final ArrayList<String> skills;
    private final ArrayList<String> location;
    private final ArrayList<String> education;
    private JPanel bodyPane;
    private JPanel detailsPane;
    private JScrollPane jobDescScrollPane;
    private JEditorPane jobDescriptionPane;
    private JScrollPane skillsListScrollPane;
    private DefaultListModel<String> skillsListModel;
    private JScrollPane qualificationsListScrollPane;
    private DefaultListModel<String> qualificationsListModel;
    private JPanel jobTitlePane;
    private JPanel actionPane;
    private JPanel editPane;
    private String[] publishedState = {"Active", "Draft", "Closed"};
    private String lastUpdatedDate;
    private String jobTitle;
    private String company;
    private String jobDescription;
    private String jobCategory;
    private String employmentType;
    private String payFloor;
    private String payCeiling;

    JobDetailsPane(NavigationController navigationController) {
        super(new BorderLayout());
        this.navigationController = navigationController;
        this.add(new JobViewPane(navigationController), BorderLayout.NORTH);
        this.createComponentPanes();
        this.skills = new ArrayList<>();
        this.location = new ArrayList<>();
        this.education = new ArrayList<>();
        setPlaceholderStuffs();

        this.setJobTitlePaneComponents();
        this.setActionPaneComponents();
        this.setEditPaneComponents();
        this.setJobDescriptionPaneComponents();
        this.setQualificationsListPaneComponents();
        this.setSkillsListPaneComponents();
        this.setDetailsPaneLayout();
    }


    private void createComponentPanes() {

        this.bodyPane = new JPanel(new FlowLayout());
        detailsPane = new JPanel(new GridBagLayout());

        jobTitlePane = new JPanel();
        jobTitlePane.setBackground(Color.WHITE);

        jobDescriptionPane = new JEditorPane();
        jobDescScrollPane = new JScrollPane(jobDescriptionPane);
        jobDescScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jobDescScrollPane.setPreferredSize(new Dimension(500, 350));
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

        JComboBox<String> publishStatusSelector = new JComboBox<>(publishedState);
        JButton publishButton = new JButton("Update Status");

        actionPane.add(publishStatusSelector);
        actionPane.add(Box.createHorizontalGlue());
        actionPane.add(publishButton);

    }

    protected void setEditPaneComponents() {
        editPane.setLayout(new BoxLayout(editPane, BoxLayout.PAGE_AXIS));

        JLabel lastUpdated = new JLabel(" last updated: " + lastUpdatedDate);
        JButton editButton = new JButton("Edit");

        editPane.add(editButton);
        editPane.add(lastUpdated);

        lastUpdated.setAlignmentX(Box.RIGHT_ALIGNMENT);
        editButton.setAlignmentX(Box.RIGHT_ALIGNMENT);

        editButton.addActionListener(e -> {
            navigationController.setBody("CREATEJOB");
        });
    }

    public void setJobTitlePaneComponents() {
        jobTitlePane.setLayout(new BoxLayout(jobTitlePane, BoxLayout.PAGE_AXIS));

        JLabel jobTitleLabel = new JLabel(jobTitle);
        JLabel companyLabel = new JLabel(company);
        JLabel locationLabel = new JLabel(location.get(0));
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
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
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
        bodyPane.add(detailsPane);

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
        this.add(bodyPane, BorderLayout.CENTER);
    }

    private void setPlaceholderStuffs() {


        for (int i = 0; i <= 10; i++) {
            skills.add("skill" + i);
            education.add("education" + i);
        }
        location.add("Sydney");
        lastUpdatedDate = "12 June 2050";
        jobTitle = "Sweet Dev Job";
        company = "The Illustrious Purple Buttons Company";
        jobDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ante in nibh mauris cursus mattis molestie a iaculis. Est lorem ipsum dolor sit amet consectetur adipiscing elit. Vivamus arcu felis bibendum ut tristique et. Et odio pellentesque diam volutpat commodo sed. Vulputate odio ut enim blandit volutpat. Ut aliquam purus sit amet. Vitae justo eget magna fermentum iaculis eu non diam phasellus. Elit scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus. Lacus luctus accumsan tortor posuere. Id neque aliquam vestibulum morbi blandit cursus. Dapibus ultrices in iaculis nunc sed augue. In fermentum posuere urna nec tincidunt praesent semper. Pharetra et ultrices neque ornare. Pharetra sit amet aliquam id diam maecenas ultricies. Est lorem ipsum dolor sit amet consectetur. Dictum at tempor commodo ullamcorper a. Neque sodales ut etiam sit amet.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu. Ac turpis egestas integer eget. Sagittis aliquam malesuada bibendum arcu vitae elementum. Vitae aliquet nec ullamcorper sit amet risus nullam. A pellentesque sit amet porttitor eget. Suspendisse in est ante in nibh mauris cursus mattis. Scelerisque fermentum dui faucibus in ornare. Dignissim convallis aenean et tortor at risus viverra adipiscing at. Diam donec adipiscing tristique risus nec feugiat in fermentum. Gravida cum sociis natoque penatibus et magnis dis. Ultricies tristique nulla aliquet enim tortor at auctor urna. Mattis molestie a iaculis at erat pellentesque adipiscing. Habitant morbi tristique senectus et. Convallis convallis tellus id interdum velit.\n" +
                "\n" +
                "Convallis posuere morbi leo urna molestie at elementum eu. At risus viverra adipiscing at in tellus. Lacus sed turpis tincidunt id aliquet. A diam sollicitudin tempor id eu nisl nunc. Consequat semper viverra nam libero justo. Sit amet dictum sit amet justo donec. Faucibus turpis in eu mi bibendum. Condimentum lacinia quis vel eros donec ac odio tempor. Diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus. Convallis aenean et tortor at risus. Maecenas ultricies mi eget mauris pharetra et ultrices. Cras ornare arcu dui vivamus arcu felis bibendum ut.\n" +
                "\n" +
                "Turpis tincidunt id aliquet risus feugiat in ante metus dictum. Porta nibh venenatis cras sed felis. Felis bibendum ut tristique et egestas quis ipsum. Massa sapien faucibus et molestie ac feugiat sed lectus. Tortor at risus viverra adipiscing at in tellus integer feugiat. Egestas dui id ornare arcu. Congue mauris rhoncus aenean vel. Vulputate mi sit amet mauris commodo quis. Semper eget duis at tellus. Pharetra diam sit amet nisl suscipit adipiscing bibendum est ultricies. Scelerisque eleifend donec pretium vulputate. Neque ornare aenean euismod elementum nisi quis eleifend. Blandit libero volutpat sed cras ornare arcu dui vivamus. Quam viverra orci sagittis eu volutpat. Non enim praesent elementum facilisis leo vel. Sollicitudin tempor id eu nisl nunc mi ipsum. Tincidunt eget nullam non nisi est sit amet facilisis. Turpis tincidunt id aliquet risus feugiat in.\n" +
                "\n" +
                "Magna eget est lorem ipsum dolor. Nibh praesent tristique magna sit amet. Elit scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique. Eget dolor morbi non arcu. Justo eget magna fermentum iaculis. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Mattis molestie a iaculis at erat. Phasellus vestibulum lorem sed risus. Orci phasellus egestas tellus rutrum tellus pellentesque eu. Id consectetur purus ut faucibus pulvinar. Fermentum odio eu feugiat pretium nibh ipsum consequat nisl. Iaculis at erat pellentesque adipiscing commodo. Aliquam sem fringilla ut morbi tincidunt augue interdum velit. Elementum eu facilisis sed odio morbi quis commodo odio aenean. Ante metus dictum at tempor. In dictum non consectetur a erat nam at. Libero justo laoreet sit amet cursus sit amet dictum. Mi ipsum faucibus vitae aliquet.";
        jobCategory = "IT";
        employmentType = "Full Time";
        payFloor = "$130,000";
        payCeiling = "$150,000";

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}