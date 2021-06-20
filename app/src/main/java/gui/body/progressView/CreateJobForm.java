package gui.body.progressView;

import application.Education;
import controller.JobController;
import controller.NavigationController;
import data.JobCategory;
import data.KeywordType;
import data.Location;
import data.Salary;
import utility.GBC;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class CreateJobForm extends JPanel implements ListSelectionListener {

    private JPanel bodyPane;
    private JPanel formPane;
    private JPanel progressPane;
    private JPanel backgroundPane;
    private JPanel jobDetailsPanel;
    private JPanel skillsAndQualsPage;
    private JPanel descriptionPanel;
    private JPanel publishPanel;
    private JPanel buttonsPanel;
    private CardLayout cardLayout;
    private final NavigationController navigationController;
    private final JobController jobController;

    private JList<String> qualificationsList;
    private JTextField qualificationsTextField;
    private JScrollPane qualificationsListScrollPane;
    private JButton qualificationsAddButton;
    private JButton qualificationsRemoveButton;

    private JList<String> skillsList;
    private JTextField skillTextField;
    private JScrollPane skillsListScrollPane;
    private JButton addSkillButton;
    private JButton removeSkillButton;
    private final ActionListener leave;
    private final ActionListener back;

    private JComboBox<Location> locationEntry;
    private JComboBox<JobCategory> categoryEntry;
    private JProgressBar progressBar;
    private int progressBarValue;
    private JComboBox<String> payTypeEntry;
    private JComboBox<String> employmentTypeEntry;
    private JButton proceedButton;
    private JButton backButton;
    private Integer minInt;
    private Integer maxInt;
    private JButton saveButton;
    private JButton previewButton;
    private JButton publishButton;
    private JComboBox<String> educationEntry;
    private JTextArea descriptionEntry;
    private JTextField jobTitleEntry;
    private JTextField companyEntry;
    private JComboBox<String> payRangeMinEntry;
    private JComboBox<String> payRangeMaxEntry;
    private DefaultListModel<String> skillsListModel;
    private DefaultListModel<String> qualificationsListModel;
    private JPanel pageShown;
    private final String details;
    private final String skills;
    private final String description;
    private final String publish;

    public CreateJobForm(NavigationController navigationController, JobController jobController) {

        super();
        this.navigationController = navigationController;
        this.jobController = jobController;
        JPanel header = new JPanel();
        progressPane = new JPanel();
        progressPane.setLayout(new BoxLayout(progressPane, BoxLayout.PAGE_AXIS));
        progressPane.setPreferredSize(new Dimension(900, 50));
        header.add(progressPane);
        this.setLayout(new BorderLayout());
        backgroundPane = new JPanel(new FlowLayout());
        cardLayout = new CardLayout();
        formPane = new JPanel(cardLayout);
        bodyPane = new JPanel(new BorderLayout());
        buttonsPanel = new JPanel();
        this.add(header, BorderLayout.NORTH);
        this.add(backgroundPane, BorderLayout.CENTER);
        backgroundPane.add(bodyPane);
        bodyPane.add(formPane, BorderLayout.CENTER);
        bodyPane.add(buttonsPanel, BorderLayout.PAGE_END);
        progressBarValue = 25;
        details = "DETAILS";
        skills = "SKILLS";
        description = "DESCRIPTION";
        publish = "PUBLISH";

        jobDetailsPanel = new JPanel(new GridBagLayout());
        jobDetailsPanel.setBackground(Color.WHITE);
        jobDetailsPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        skillsAndQualsPage = new JPanel(new GridBagLayout());
        skillsAndQualsPage.setBackground(Color.WHITE);
        skillsAndQualsPage.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        descriptionPanel = new JPanel(new GridBagLayout());
        descriptionPanel.setBackground(Color.WHITE);
        publishPanel = new JPanel(new GridBagLayout());
        publishPanel.setBackground(Color.WHITE);

        jobDetailsPanel.setName(details);
        skillsAndQualsPage.setName(skills);
        descriptionPanel.setName(description);
        publishPanel.setName(publish);
        pageShown = null;

        formPane.add(jobDetailsPanel, details);
        formPane.add(skillsAndQualsPage, skills);
        formPane.add(descriptionPanel, description);
        formPane.add(publishPanel, publish);
        setPage(details);

        bodyPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bodyPane.setPreferredSize(new Dimension(900,600));
        bodyPane.setBackground(Color.WHITE);
        //Progress Panel
        JPanel progressLabelPane = new JPanel();
        progressLabelPane.setPreferredSize(new Dimension(800, 20));
        progressLabelPane.setLayout(new BoxLayout(progressLabelPane, BoxLayout.LINE_AXIS));
        progressLabelPane.add(Box.createHorizontalGlue());
        progressLabelPane.add(new JLabel("Job Details"));
        progressLabelPane.add(Box.createHorizontalGlue());
        progressLabelPane.add(new JLabel("Skills and \nQualifications"));
        progressLabelPane.add(Box.createHorizontalGlue());
        progressLabelPane.add(new JLabel("Job Description"));
        progressLabelPane.add(Box.createHorizontalGlue());
        progressLabelPane.add(new JLabel("Publish"));

        progressBar = new JProgressBar();
        progressBar.setStringPainted(false);
        progressBar.putClientProperty("JProgressBar.square", false);
        progressBar.putClientProperty("JProgressBar.largeHeight", false);
        progressBar.setPreferredSize(new Dimension(800, 5));
        progressBar.setValue(progressBarValue);
        progressPane.setBorder(BorderFactory.createEmptyBorder(5,60,5,60));
        progressPane.add(progressBar);
        progressPane.add(progressLabelPane);

        leave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leavePage();
            }
        };
        back = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setValue(progressBarValue);
                cardLayout.previous(formPane);
                findPage();
                setNavigationButtonState();
            };
        };

        proceedButton = new JButton("Continue");
        proceedButton.addActionListener(e -> {
            progressBar.setValue(progressBarValue);
            cardLayout.next(formPane);
            findPage();
            setNavigationButtonState();
        });

        backButton = new JButton("Back");
        backButton.addActionListener(leave);

        findPage();
        setNavigationButtonState();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        buttonsPanel.add(backButton);
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(proceedButton);

        createJobDetailsComponents();
        setJobDetailsLayout();
        createSkillsComponents();
        setSkillsLayout();
        createJobDescriptionComponents();
        setJobDescriptionLayout();
        createPublishPanelComponents();
        setPublishPanelLayout();



        saveButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to save this job to your drafts?", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                createJob("DRAFT");
                cardLayout.show(formPane,details);
                clearJobDetails();
                navigationController.setBody("RECRUITER");
            }
        });
        publishButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to publish this job??", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                createJob("ACTIVE");
                cardLayout.show(formPane,details);
                clearJobDetails();
                System.out.println("Here");
                navigationController.setBody("RECRUITER");
            }
        });

        payRangeMaxEntry.addActionListener(e -> payRangeValidation());
        payRangeMinEntry.addActionListener(e -> payRangeValidation());
        payRangeMaxEntry.addActionListener(minpay -> proceedButton.setEnabled(validateDetails()));
        payRangeMinEntry.addActionListener(maxpay -> proceedButton.setEnabled(validateDetails()));
        categoryEntry.addActionListener(category -> proceedButton.setEnabled(validateDetails()));
        locationEntry.addActionListener(location -> proceedButton.setEnabled(validateDetails()));

        jobTitleEntry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e1) {
                proceedButton.setEnabled(validateDetails());
            }
        });
        companyEntry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e3) {
                proceedButton.setEnabled(validateDetails());
            }
        });

        removeSkillButton.addActionListener(e2 -> {
            if (skillsList.getModel().getSize() >= 1 && !skillsList.isSelectionEmpty()) {
                skillsListModel.remove(skillsList.getSelectedIndex());
                if (skillsList.getModel().getSize() < 1) {
                    proceedButton.setEnabled(false);
                }
            }
        });

        qualificationsRemoveButton.addActionListener(e2 -> {
            if (qualificationsList.getModel().getSize() >= 1 && !qualificationsList.isSelectionEmpty()) {
                qualificationsListModel.remove(qualificationsList.getSelectedIndex());
                if (qualificationsList.getModel().getSize() < 1){
                    proceedButton.setEnabled(false);
                }
            }
        });

        educationEntry.addActionListener (e -> proceedButton.setEnabled(validateSkillsAndQuals()));

        addSkillButton.addActionListener(e -> {
            if (!"".equals(skillTextField.getText())) {
                String tempSkill = skillTextField.getText();
                skillsListModel.addElement(tempSkill);
                skillTextField.setText("");
                proceedButton.setEnabled(validateSkillsAndQuals());
            }
        });

        qualificationsAddButton.addActionListener(e -> {
            if (!"".equals(qualificationsTextField.getText())) {
                String tempSkill = qualificationsTextField.getText();
                qualificationsListModel.addElement(tempSkill);
                qualificationsTextField.setText("");
                proceedButton.setEnabled(validateSkillsAndQuals());
            }
        });

        descriptionEntry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e1) { proceedButton.setEnabled(validateDesc());
            }
        });
    }

    private void createJobDetailsComponents() {
        jobTitleEntry = new JTextField(10);
        companyEntry = new JTextField(10);
        locationEntry = new JComboBox<>(Location.getCreateFormLocations());
        categoryEntry = new JComboBox<>(JobCategory.getCreateFormCategories());
        String[] payTypeArray = new String[] {"Salary", "Per Hour"};
        payTypeEntry = new JComboBox<>(payTypeArray);
        String[] salaryArray = Salary.getCreateSalaryArray();
        String[] perHourArray = Salary.getCreatePerHourArray();
        DefaultComboBoxModel<String> minSalaryModel = new DefaultComboBoxModel<>(salaryArray);
        DefaultComboBoxModel<String> minPerHourModel = new DefaultComboBoxModel<>(perHourArray);
        DefaultComboBoxModel<String> maxSalaryModel = new DefaultComboBoxModel<>(salaryArray);
        DefaultComboBoxModel<String> maxPerHourModel = new DefaultComboBoxModel<>(perHourArray);
        payRangeMinEntry = new JComboBox<>();
        payRangeMinEntry.setModel(minSalaryModel);
        payRangeMaxEntry = new JComboBox<>();
        payRangeMaxEntry.setModel(maxSalaryModel);
        payTypeEntry.addActionListener (ep -> {
            if ("Per Hour".equals(payTypeEntry.getSelectedItem())) {
                payRangeMinEntry.setModel(minPerHourModel);
                payRangeMaxEntry.setModel(maxPerHourModel);
            }
            else {
                payRangeMinEntry.setModel(minSalaryModel);
                payRangeMaxEntry.setModel(maxSalaryModel);
            }
        });
        String[] empTypeArray = new String[] {"Full time", "Contract", "Part time", "Casual"};
        employmentTypeEntry = new JComboBox<>(empTypeArray);
    }

    private void setJobDetailsLayout() {
        JLabel detailsSectionTitle = new JLabel("Job Details", SwingConstants.LEFT);
        JLabel mandatory = new JLabel("*Denotes mandatory field", SwingConstants.LEFT);
        JPanel jobTitlePane = createLabeledComponent("Job Title*:", jobTitleEntry);
        JPanel companyPane = createLabeledComponent("Company*:", companyEntry);
        JPanel locationPane = createLabeledComponent("Location*:", locationEntry);
        JPanel categoryPane = createLabeledComponent("Category*:", categoryEntry);
        JPanel payTypePane = createLabeledComponent("Pay Type:", payTypeEntry);
        JPanel employmentTypePane = createLabeledComponent("Employment Type", employmentTypeEntry);

        JPanel payRangeSelection = new JPanel();
        payRangeSelection.setBackground(Color.WHITE);
        BoxLayout payRangeBox = new BoxLayout(payRangeSelection, BoxLayout.LINE_AXIS);
        payRangeSelection.setLayout(payRangeBox);
        payRangeSelection.add(payRangeMinEntry);
        payRangeSelection.add(new JLabel(" to "));
        payRangeSelection.add(payRangeMaxEntry);

        JPanel payRangePane = createLabeledComponent("Pay Range ($AUD)*:", payRangeSelection);

        JPanel locationCategory = new JPanel();
        locationCategory.setBackground(Color.WHITE);
        BoxLayout locationCategoryBox = new BoxLayout(locationCategory, BoxLayout.LINE_AXIS);
        locationCategory.setLayout(locationCategoryBox);
        locationCategory.add(locationPane);
        locationCategory.add(Box.createRigidArea(new Dimension(10, 0)));
        locationCategory.add(categoryPane);

        jobDetailsPanel.add(detailsSectionTitle, new GBC(0,0)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(jobTitlePane, new GBC(0,1)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(companyPane, new GBC(0,2)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(locationCategory, new GBC(0,3)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(mandatory, new GBC(1,0)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(payTypePane, new GBC(1,1)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(payRangePane, new GBC(1,2)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
        jobDetailsPanel.add(employmentTypePane, new GBC(1,3)
                .setWeight(1.0,0)
                .setInsets(5)
                .setFill(GridBagConstraints.HORIZONTAL));
    }

    private void createSkillsComponents() {
        // Skills Panel - Card 2
        educationEntry = new JComboBox<>(Education.getCreateArray());

        skillsListModel = new DefaultListModel<>();
        skillTextField = new JTextField(20);
        skillsList = new JList<>(skillsListModel);
        skillsListScrollPane = setUpScrollPane(skillsList);
        skillsListScrollPane.setPreferredSize(new Dimension(300, 180));
        addSkillButton = new JButton("Add");
        removeSkillButton = new JButton("Remove");
//        skillsListScrollPane.setBorder(BorderFactory.createTitledBorder("Required Skills"));

        qualificationsListModel = new DefaultListModel<>();
        qualificationsTextField = new JTextField(20);
        qualificationsList = new JList<>(qualificationsListModel);
        qualificationsListScrollPane = setUpScrollPane(qualificationsList);
        qualificationsListScrollPane.setPreferredSize(new Dimension(300, 180));
        qualificationsAddButton = new JButton("Add");
        qualificationsRemoveButton = new JButton("Remove");
//        qualificationsListScrollPane.setBorder(BorderFactory.createTitledBorder("Required Qualifications"));

    }

    public void setSkillsLayout() {

        JLabel skillsAndQualsSectionTitle = new JLabel("Desired Skills and Qualifications");
        JLabel mandatory2 = new JLabel("*Denotes mandatory field", SwingConstants.LEFT);
        JPanel qualificationsPane = createListPane("Required Skills*:",qualificationsTextField, qualificationsListScrollPane, qualificationsAddButton, qualificationsRemoveButton);
        JPanel skillsPane = createListPane("Required Qualifications*:",skillTextField, skillsListScrollPane, addSkillButton, removeSkillButton);
        JPanel educationPane = createLabeledComponent("Education*:", educationEntry);

        skillsAndQualsPage.add(skillsAndQualsSectionTitle, new GBC(0,0)
                .setWeight(1,1)
                .setFill(GridBagConstraints.HORIZONTAL)
                .setInsets(5));
        skillsAndQualsPage.add(mandatory2, new GBC(1,0)
                .setWeight(1,1)
                .setFill(GridBagConstraints.HORIZONTAL)
                .setInsets(5));
        skillsAndQualsPage.add(skillsPane, new GBC(1,1)
                .setWeight(1,1)
                .setFill(GridBagConstraints.HORIZONTAL)
                .setInsets(5));
        skillsAndQualsPage.add(qualificationsPane, new GBC(0,1)
                .setWeight(1,1)
                .setFill(GridBagConstraints.HORIZONTAL)
                .setInsets(5));
        skillsAndQualsPage.add(educationPane, new GBC(1,2)
                .setWeight(1,1)
                .setFill(GridBagConstraints.HORIZONTAL)
                .setInsets(5));
    }

    public JPanel createLabeledComponent(String labelText, JComponent component) {
        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.WHITE);
        BoxLayout boxLayout = new BoxLayout(newPanel, BoxLayout.PAGE_AXIS);
        newPanel.setLayout(boxLayout);
        JLabel label = new JLabel(labelText);;
        label.setAlignmentX(LEFT_ALIGNMENT);
        label.setLabelFor(component);
        component.setAlignmentX(LEFT_ALIGNMENT);
        newPanel.add(label);
        newPanel.add(component);
        return newPanel;
    }

    protected JScrollPane setUpScrollPane(JList list) {
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        return new JScrollPane(list);
    }


    public void setPage(String page) {
        CardLayout createJobFlow = (CardLayout) (formPane.getLayout());
        createJobFlow.show(formPane, page);
    }

    public JPanel createListPane(String labelText ,JTextField textField, JScrollPane listScrollPane, JButton addButton, JButton removeButton) {
        JPanel pane = new JPanel();
        BoxLayout skillsLayout = new BoxLayout(pane, BoxLayout.PAGE_AXIS);
        textField.setPreferredSize(new Dimension(100,15));
        JPanel textAdd = new JPanel();
        textAdd.setBackground(Color.WHITE);
        BoxLayout locationCategoryBox = new BoxLayout(textAdd, BoxLayout.LINE_AXIS);
        textAdd.setLayout(locationCategoryBox);
        textAdd.add(textField);
        textAdd.add(Box.createRigidArea(new Dimension(10, 0)));
        textAdd.add(addButton);

        removeButton.setAlignmentX(LEFT_ALIGNMENT);
        textAdd.setAlignmentX(LEFT_ALIGNMENT);
        listScrollPane.setAlignmentX(LEFT_ALIGNMENT);

        pane.setLayout(skillsLayout);
        pane.setBackground(Color.WHITE);
        pane.add(textAdd);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(listScrollPane);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(removeButton);
        pane.add(Box.createVerticalGlue());
        return createLabeledComponent(labelText, pane);
    }

    public void createJob(String status) {

        List<String> loc = new ArrayList<>();
        loc.add(String.valueOf(locationEntry.getSelectedItem()));
        List<String> cat = new ArrayList<>();
        cat.add(String.valueOf(categoryEntry.getSelectedItem()));
        List<String> pay = new ArrayList<>();
        pay.add(String.valueOf(payTypeEntry.getSelectedItem()));
        List<String> edu = new ArrayList<>();
        edu.add(String.valueOf(educationEntry.getSelectedItem()));
        int i;
        List<String> ski = new ArrayList<>();
        int n = skillsList.getModel().getSize();
        for (i = 0; i < n; i++) {
            String temp = String.valueOf(skillsList.getModel().getElementAt(i));
            ski.add(temp);
        }

        List<String> qua = new ArrayList<>();
        int n2 = qualificationsList.getModel().getSize();
        for (i = 0; i < n2; i++) {
            String temp = String.valueOf(qualificationsList.getModel().getElementAt(i));
            qua.add(temp);
        }

        Map<KeywordType, List<String>> keywordMap = new HashMap<>() {
            {
                put(KeywordType.LOCATION, loc);
                put(KeywordType.CATEGORY, cat);
                put(KeywordType.PAYTYPE, pay);
                put(KeywordType.EDUCATION, edu);
                put(KeywordType.SKILL, ski);
                put(KeywordType.QUALIFICATION, qua);
            }
        };

        jobController.createNewJob(jobTitleEntry.getText(), keywordMap, String.valueOf(employmentTypeEntry.getSelectedItem()), descriptionEntry.getText(), maxInt, minInt, companyEntry.getText(), status);

        cardLayout.show(formPane,details);
        clearJobDetails();
        navigationController.setBody("RECRUITER");
        navigationController.setHeader("BUTTONS");
    }

    private void createJobDescriptionComponents() {
        descriptionEntry = new JTextArea();
        descriptionEntry.setLineWrap(true);
        descriptionEntry.setWrapStyleWord(true);
    }

    private void setJobDescriptionLayout() {
        JLabel jobDescriptionTitle = new JLabel("Job Description*", SwingConstants.LEFT);
        JLabel mandatory = new JLabel("*Denotes mandatory field", SwingConstants.LEFT);
        JScrollPane descScroll = new JScrollPane(descriptionEntry);
        descScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descScroll.setPreferredSize((new Dimension(600,300)));

        descriptionPanel.add(jobDescriptionTitle, new GBC(0,1)
                .setSpan(1,1)
                .setInsets(0,10,0,0));

        descriptionPanel.add(mandatory, new GBC(2,1)
                .setSpan(2,1)
                .setInsets(0,0,0,0));

        descriptionPanel.add(descScroll, new GBC(0,2)
                .setSpan(4,1)
                .setInsets(10,10,10,10));
    }

    private void createPublishPanelComponents() {
        saveButton = new JButton("Save as draft");
        previewButton = new JButton("Preview");
        publishButton = new JButton(("Publish"));
    }

    private void setPublishPanelLayout() {
        JLabel publishTitle = new JLabel("What would you like to do next?", SwingConstants.LEFT);
        publishPanel.add(publishTitle, new GBC(0,1)
                .setSpan(5,1)
                .setAnchor(GridBagConstraints.CENTER)
                .setFill(GridBagConstraints.NONE)
                .setInsets(10));
        //Save Button
        publishPanel.add(saveButton, new GBC(1,3)
                .setSpan(1,1)
                .setInsets(10));

        publishPanel.add(publishButton, new GBC(2,3)
                .setSpan(1,1)
                .setFill(GridBagConstraints.HORIZONTAL)
                .setFill(GridBagConstraints.NONE)
                .setInsets(10));
    }

    public void clearJobDetails(){
            jobTitleEntry.setText("");
            companyEntry.setText("");
            locationEntry.setSelectedIndex(0);
            categoryEntry.setSelectedIndex(0);
            payTypeEntry.setSelectedIndex(0);
            payRangeMinEntry.setSelectedIndex(0);
            payRangeMaxEntry.setSelectedIndex(0);
            employmentTypeEntry.setSelectedIndex(0);
            skillsListModel.removeAllElements();
            educationEntry.setSelectedIndex(0);
            qualificationsListModel.removeAllElements();
            descriptionEntry.setText("");
    }

    private boolean validateDetails() {
        if ((companyEntry != null)
                && (jobTitleEntry != null)
                && (companyEntry.getText().length() > 0)
                && (jobTitleEntry.getText().length() > 0)
                && (!"-Select".equals(payRangeMinEntry.getSelectedItem()))
                && (!"-Select".equals(payRangeMaxEntry.getSelectedItem()))
                && (!"Select Categories".equals(String.valueOf(categoryEntry.getSelectedItem())))
                && (!"Select Locations".equals(String.valueOf(locationEntry.getSelectedItem())))){
            return true;
        }
        return false;
    }

    private boolean validateSkillsAndQuals() {
        if ((qualificationsList != null)
                && (skillsList != null)
                && (qualificationsList.getModel().getSize() >= 1)
                && (skillsList.getModel().getSize() >= 1)
                && (!"-Select highest level of education".equals(educationEntry.getSelectedItem()))) {
            return true;
        }
        return false;
    }

    private boolean validateDesc(){
        if ((descriptionEntry != null)
                && (descriptionEntry.getText().length() > 0)) {
            return true;
        }
        return false;
    }
    private void leavePage(){
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave without saving?", "Warning",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            navigationController.setBody("RECRUITER");
            navigationController.setHeader("BUTTONS");
            proceedButton.setVisible(true);
            cardLayout.show(formPane, "DETAILS");
            clearJobDetails();
        }
    }
    private void setNavigationButtonState() {
        switch (pageShown.getName()) {
            case "DETAILS" -> {
                backButton.removeActionListener(back);
                backButton.addActionListener(leave);
                proceedButton.setVisible(true);
                proceedButton.setEnabled(validateDetails());
                progressBar.setValue(20);
            }
            case "SKILLS" -> {
                backButton.removeActionListener(leave);
                backButton.removeActionListener(back);
                backButton.addActionListener(back);
                proceedButton.setVisible(true);
                proceedButton.setEnabled(validateSkillsAndQuals());
                progressBar.setValue(45);
            }
            case "DESCRIPTION" -> {
                backButton.removeActionListener(leave);
                backButton.removeActionListener(back);
                backButton.addActionListener(back);
                proceedButton.setVisible(true);
                proceedButton.setEnabled(validateDesc());
                progressBar.setValue(75);
            }
            case "PUBLISH" -> {
                backButton.removeActionListener(leave);
                backButton.removeActionListener(back);
                backButton.addActionListener(back);
                proceedButton.setEnabled(false);
                proceedButton.setVisible(false);
                progressBar.setValue(100);
            }
            default -> {
                backButton.removeActionListener(leave);
                backButton.removeActionListener(back);
                proceedButton.setEnabled(false);
            }
        }
    }
    private void findPage() {
        for (Component page : formPane.getComponents()) {
            if (page.isVisible()){
                pageShown = (JPanel) page;
            }
        }
    }

    private void payRangeValidation() {
        String minVal = String.valueOf(payRangeMinEntry.getSelectedItem());
        String maxVal = String.valueOf(payRangeMaxEntry.getSelectedItem());
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(minVal);
        while (m.find()) {
            minVal = String.valueOf(m.group());
        }
        m = p.matcher(maxVal);
        while (m.find()) {
            maxVal = String.valueOf(m.group());
        }
        try {
            minInt = parseInt(minVal);
            maxInt = parseInt(maxVal);
            if(minInt >= maxInt) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "The selected Maximum Pay must be equal or higher than the Minimum Pay", "Error", JOptionPane.ERROR_MESSAGE);
                proceedButton.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            //this is intended behaviour
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}