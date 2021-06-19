package gui.body.progressView;

import application.Education;
import com.intellij.uiDesigner.core.GridConstraints;
import controller.JobController;
import controller.NavigationController;
import data.*;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateJobForm extends JPanel {
    private final JComboBox<String> locationEntry;
    private final JComboBox<String> categoryEntry;
    private final JProgressBar progressBar;
    private final JComboBox<String> payTypeEntry;
    private final JComboBox<String> employmentTypeEntry;
    private final JButton proceedButton;
    private final JButton proceedButton3;
    private final JComboBox<String> educationEntry;
    private final JTextArea descriptionEntry;
    private final JTextField jobTitleEntry;
    private final JTextField companyEntry;
    private final JComboBox<String> payRangeMinEntry;
    private final JComboBox<String> payRangeMaxEntry;
    private final DefaultListModel<String> skillModel;
    private final DefaultListModel<String> qualModel;
    private JButton proceedButton2;
    private JobController jobController;


    public CreateJobForm(NavigationController navigationController, JobController jobController) {

        super();

        this.jobController = jobController;

        /* Initial panel - Job Details */
        JPanel jobDetailsPanel = new JPanel();
        jobDetailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.add(jobDetailsPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        jobDetailsPanel.setVisible(true);

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        this.add(skillsPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();
        this.add(descriptionPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel publishPanel = new JPanel();
        publishPanel.setLayout(new GridBagLayout());
        GridBagConstraints c4 = new GridBagConstraints();
        this.add(publishPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        this.setLayout(new CardLayout());
        this.add(jobDetailsPanel, "CREATEJOB");
        this.add(skillsPanel, "SKILLS");
        this.add(descriptionPanel, "DESCRIPTION");
        this.add(publishPanel, "PUBLISH");
        this.setPage("CREATEJOB");

        //Job Details panel - Card 1
        //Progress Panel
        progressBar = new JProgressBar();
        progressBar.setStringPainted(false);
        progressBar.setValue(25);
        progressBar.putClientProperty("JProgressBar.square", true);
        progressBar.putClientProperty("JProgressBar.largeHeight", false);
        setPosition(c, 0, 0, 6, 0, 0, 0, 0);
        jobDetailsPanel.add(progressBar, c);

        //Body Title
        JLabel bodyTitle = new JLabel("Job Details");
        setTextPosition(bodyTitle);
        setPosition(c, 0, 1, 1, 10, 10, 0, 0);
        jobDetailsPanel.add(bodyTitle, c);

        //Mandatory message
        JLabel mandatory = new JLabel("*Denotes mandatory field");
        setTextPosition(mandatory);
        setButtonPosition(c, 2, 1, 3, 10, 0, 0, 0);
        jobDetailsPanel.add(mandatory, c);

        //Job Title
        JLabel jobTitle = new JLabel("Job Title*:");
        setTextPosition(jobTitle);
        setPosition(c, 0, 2, 2, 10, 10, 0, 10);
        jobDetailsPanel.add(jobTitle, c);

        //Company
        JLabel company = new JLabel("Company*:");
        setTextPosition(company);
        setPosition(c, 0, 4, 2, 10, 10, 0, 10);
        jobDetailsPanel.add(company, c);

        //Location
        JLabel location = new JLabel("Location*:");
        setTextPosition(location);
        setPosition(c, 0, 6, 1, 10, 10, 0, 10);
        jobDetailsPanel.add(location, c);

        //Category
        JLabel category = new JLabel("Category*:");
        setTextPosition(category);
        setPosition(c, 1, 6, 1, 10, 10, 0, 10);
        jobDetailsPanel.add(category, c);

        //Pay type
        JLabel payType = new JLabel("Pay Type:");
        setTextPosition(payType);
        setPosition(c, 2, 2, 3, 10, 10, 0, 10);
        jobDetailsPanel.add(payType, c);

        //Pay Range
        JLabel payRange = new JLabel("Pay Range ($AUD)*:");
        setTextPosition(payRange);
        setPosition(c, 2, 4, 3, 10, 10, 0, 10);
        jobDetailsPanel.add(payRange, c);

        //Pay Range
        JLabel to = new JLabel("to");
        setTextPosition(to);
        setPosition(c, 3, 5, 1, 10, 10, 0, 10);
        jobDetailsPanel.add(to, c);

        //Employment Type
        JLabel employmentType = new JLabel("Employment Type");
        setTextPosition(employmentType);
        setPosition(c, 2, 6, 3, 10, 10, 0, 10);
        jobDetailsPanel.add(employmentType, c);

        //Job Title Entry
        jobTitleEntry = new JTextField(10);
        setPosition(c, 0, 3, 2, 0, 10, 0, 10);
        jobDetailsPanel.add(jobTitleEntry, c);

        //Company Entry
        companyEntry = new JTextField(10);
        setPosition(c, 0, 5, 2, 0, 10, 0, 10);
        jobDetailsPanel.add(companyEntry, c);

        //Location Entry
        locationEntry = new JComboBox<>(Location.getCreateArray());
        setPosition(c, 0, 7, 1, 0, 10, 0, 10);
        jobDetailsPanel.add(locationEntry, c);

        //Category Entry
        categoryEntry = new JComboBox<>(JobType.getCreateArray());
        setPosition(c, 1, 7, 1, 0, 10, 0, 10);
        jobDetailsPanel.add(categoryEntry, c);

        //Pay Type Entry
        String[] payTypeArray = new String[]{"Salary", "Per Hour"};
        payTypeEntry = new JComboBox<>(payTypeArray);

        setPosition(c, 2, 3, 3, 0, 10, 0, 10);
        jobDetailsPanel.add(payTypeEntry, c);

        //Pay Range Entry min
        String[] salaryArray = Salary.getCreateSalaryArray();
        String[] perHourArray = Salary.getCreatePerHourArray();
        DefaultComboBoxModel<String> salaryModel = new DefaultComboBoxModel<>(salaryArray);
        DefaultComboBoxModel<String> perHourModel = new DefaultComboBoxModel<>(perHourArray);
        DefaultComboBoxModel<String> salaryModel2 = new DefaultComboBoxModel<>(salaryArray);
        DefaultComboBoxModel<String> perHourModel2 = new DefaultComboBoxModel<>(perHourArray);

        payRangeMinEntry = new JComboBox<>();
        payRangeMinEntry.setModel(salaryModel);
        setPosition(c, 2, 5, 1, 0, 10, 0, 10);
        jobDetailsPanel.add(payRangeMinEntry, c);

        //Pay Range Entry max
        payRangeMaxEntry = new JComboBox<>();
        payRangeMaxEntry.setModel(salaryModel2);
        setPosition(c, 4, 5, 1, 0, 10, 0, 10);
        jobDetailsPanel.add(payRangeMaxEntry, c);

        payTypeEntry.addActionListener(ep -> {
            if ("Per Hour".equals(payTypeEntry.getSelectedItem())) {
                payRangeMinEntry.setModel(perHourModel);
                payRangeMaxEntry.setModel(perHourModel2);
            } else {
                payRangeMinEntry.setModel(salaryModel);
                payRangeMaxEntry.setModel(salaryModel2);
            }
        });

        //Employment Type
        employmentTypeEntry = new JComboBox(EmploymentType.getCreateFormEmploymentType());
        setPosition(c, 2, 7, 3, 0, 10, 0, 10);
        jobDetailsPanel.add(employmentTypeEntry, c);

        //Button Panel
        JPanel buttonsPanel = new JPanel();
        setButtonPosition(c, 0, 10, 6, 50, 0, 0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        jobDetailsPanel.add(buttonsPanel, c);

        //Back Button
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        buttonsPanel.add(backButton);

        buttonsPanel.add(Box.createHorizontalGlue());

        //Save Button
//        JButton saveButton = new JButton("Save");
//        saveButton.setFocusable(false);
//        buttonsPanel.add(saveButton);

        buttonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        //Proceed Button
        proceedButton = new JButton("Continue");
        proceedButton.setFocusable(false);
        proceedButton.setEnabled(false);
        buttonsPanel.add(proceedButton);

        payRangeMaxEntry.addActionListener(ep -> proceedButton.setEnabled(companyEntry.getText().length() > 0 && !"-Select".equals(payRangeMinEntry.getSelectedItem()) && !"-Select".equals(payRangeMaxEntry.getSelectedItem()) && jobTitleEntry.getText().length() > 0 && !"-Select job type".equals(categoryEntry.getSelectedItem()) && !"-Select location".equals(locationEntry.getSelectedItem())));
        payRangeMinEntry.addActionListener(ep -> proceedButton.setEnabled(companyEntry.getText().length() > 0 && !"-Select".equals(payRangeMinEntry.getSelectedItem()) && !"-Select".equals(payRangeMaxEntry.getSelectedItem()) && jobTitleEntry.getText().length() > 0 && !"-Select job type".equals(categoryEntry.getSelectedItem()) && !"-Select location".equals(locationEntry.getSelectedItem())));
        categoryEntry.addActionListener(ep -> proceedButton.setEnabled(companyEntry.getText().length() > 0 && !"-Select".equals(payRangeMinEntry.getSelectedItem()) && !"-Select".equals(payRangeMaxEntry.getSelectedItem()) && jobTitleEntry.getText().length() > 0 && !"-Select job type".equals(categoryEntry.getSelectedItem()) && !"-Select location".equals(locationEntry.getSelectedItem())));
        locationEntry.addActionListener(ep -> proceedButton.setEnabled(companyEntry.getText().length() > 0 && !"-Select".equals(payRangeMinEntry.getSelectedItem()) && !"-Select".equals(payRangeMaxEntry.getSelectedItem()) && jobTitleEntry.getText().length() > 0 && !"-Select job type".equals(categoryEntry.getSelectedItem()) && !"-Select location".equals(locationEntry.getSelectedItem())));

        jobTitleEntry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e1) {
                proceedButton.setEnabled(companyEntry.getText().length() > 0 && !"-Select".equals(payRangeMinEntry.getSelectedItem()) && !"-Select".equals(payRangeMaxEntry.getSelectedItem()) && jobTitleEntry.getText().length() > 0 && !"-Select job type".equals(categoryEntry.getSelectedItem()) && !"-Select location".equals(locationEntry.getSelectedItem()));
            }
        });

        companyEntry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e3) {
                proceedButton.setEnabled(companyEntry.getText().length() > 0 && !"-Select".equals(payRangeMinEntry.getSelectedItem()) && !"-Select".equals(payRangeMaxEntry.getSelectedItem()) && jobTitleEntry.getText().length() > 0 && !"-Select job type".equals(categoryEntry.getSelectedItem()) && !"-Select location".equals(locationEntry.getSelectedItem()));
            }
        });

        // Skills Panel - Card 2

        //Body Title
        JLabel bodyTitle2 = new JLabel("Desired Skills and Qualifications");
        setTextPosition(bodyTitle2);
        setPosition(c2, 0, 1, 2, 0, 10, 0, 0);
        skillsPanel.add(bodyTitle2, c2);

        //Mandatory message
        JLabel mandatory2 = new JLabel("*Denotes mandatory field");
        setTextPosition(mandatory2);
        setButtonPosition(c2, 2, 1, 2, 0, 0, 0, 0);
        skillsPanel.add(mandatory2, c2);

        //Skill list
        skillModel = new DefaultListModel<>();
        JLabel skillFieldLabel = new JLabel("Skill*:");
        setTextPosition(skillFieldLabel);
        setPosition(c2, 0, 2, 2, 0, 10, 0, 10);
        skillsPanel.add(skillFieldLabel, c2);
        JTextField skillEntry = new JTextField();
        setPosition(c2, 0, 3, 1, 0, 10, 0, 10);
        skillsPanel.add(skillEntry, c2);
        JButton addButton = new JButton("Add");
        setButtonPosition(c2, 1, 3, 1, 0, 10, 0, 10);
        skillsPanel.add(addButton, c2);


        JList<String> skillList = new JList<>(skillModel);
        JScrollPane skillScrollPane = new JScrollPane(skillList);
        skillScrollPane.setPreferredSize(new Dimension(100, 150));
        setPosition(c2, 0, 4, 2, 10, 10, 0, 10);
        c2.gridheight = 3;
        skillsPanel.add(skillScrollPane, c2);
        JButton removeButton = new JButton("Remove");
        setButtonPosition(c2, 1, 7, 1, 10, 10, 0, 10);
        c2.gridheight = 1;
        skillsPanel.add(removeButton, c2);

        removeButton.addActionListener(e2 -> {
            if (skillList.getModel().getSize() >= 1 && !skillList.isSelectionEmpty()) {
                skillModel.remove(skillList.getSelectedIndex());
                if (skillList.getModel().getSize() < 1) {
                    proceedButton2.setEnabled(false);
                }
            }
        });

        //Education
        JLabel education = new JLabel("Education*:");
        setTextPosition(education);
        setPosition(c2, 2, 2, 2, 10, 10, 0, 10);
        skillsPanel.add(education, c2);

        //Education Entry
        educationEntry = new JComboBox<>(Education.getCreateArray());
        setPosition(c2, 2, 3, 2, 0, 10, 0, 10);
        skillsPanel.add(educationEntry, c2);

        //Qualifications
        qualModel = new DefaultListModel<>();
        JLabel qualFieldLabel = new JLabel("Qualifications*:");
        setTextPosition(qualFieldLabel);
        setPosition(c2, 2, 4, 2, 10, 10, 0, 10);
        skillsPanel.add(qualFieldLabel, c2);

        JTextField qualEntry = new JTextField(50);
        setPosition(c2, 2, 5, 1, 0, 10, 0, 10);
        skillsPanel.add(qualEntry, c2);
        JButton qualAddButton = new JButton("Add");
        setButtonPosition(c2, 3, 5, 1, 0, 10, 0, 10);
        skillsPanel.add(qualAddButton, c2);

        JList<String> qualList = new JList<>(qualModel);
        JScrollPane qualScrollPane = new JScrollPane(qualList);
        qualScrollPane.setPreferredSize(new Dimension(50, 100));
        setPosition(c2, 2, 6, 2, 10, 10, 0, 10);
        skillsPanel.add(qualScrollPane, c2);
        JButton qualRemoveButton = new JButton("Remove");
        setButtonPosition(c2, 3, 7, 1, 10, 10, 0, 10);
        skillsPanel.add(qualRemoveButton, c2);

        qualRemoveButton.addActionListener(e2 -> {
            if (qualList.getModel().getSize() >= 1 && !qualList.isSelectionEmpty()) {
                qualModel.remove(qualList.getSelectedIndex());
                if (qualList.getModel().getSize() < 1) {
                    proceedButton2.setEnabled(false);
                }
            }
        });

        //Mandatory field setting for second page
        educationEntry.addActionListener(e -> proceedButton2.setEnabled(qualList.getModel().getSize() >= 1 && skillList.getModel().getSize() >= 1 && !"-Select highest level of education".equals(educationEntry.getSelectedItem())));

        addButton.addActionListener(e -> {
            if (!"".equals(skillEntry.getText())) {
                String tempSkill = skillEntry.getText();
                skillModel.addElement(tempSkill);
                skillEntry.setText("");
                proceedButton2.setEnabled(qualList.getModel().getSize() >= 1 && skillList.getModel().getSize() >= 1 && !"-Select highest level of education".equals(educationEntry.getSelectedItem()));
            }
        });

        qualAddButton.addActionListener(e -> {
            if (!"".equals(qualEntry.getText())) {
                String tempSkill = qualEntry.getText();
                qualModel.addElement(tempSkill);
                qualEntry.setText("");
                proceedButton2.setEnabled(qualList.getModel().getSize() >= 1 && skillList.getModel().getSize() >= 1 && !"-Select highest level of education".equals(educationEntry.getSelectedItem()));
            }
        });

        //Button Panel 2
        JPanel buttonsPanel2 = new JPanel();
        setButtonPosition(c2, 0, 10, 4, 50, 0, 0, 0);
        c2.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel2.setLayout(new BoxLayout(buttonsPanel2, BoxLayout.X_AXIS));
        skillsPanel.add(buttonsPanel2, c2);

        //Back Button
        JButton backButton2 = new JButton("Back");
        backButton2.setFocusable(false);
        buttonsPanel2.add(backButton2);

        buttonsPanel2.add(Box.createHorizontalGlue());

        //Save Button
//        JButton saveButton2 = new JButton("Save");
//        saveButton2.setFocusable(false);
//        buttonsPanel2.add(saveButton2);

        buttonsPanel2.add(Box.createRigidArea(new Dimension(10, 0)));

        //Proceed Button
        proceedButton2 = new JButton("Continue");
        proceedButton2.setFocusable(false);
        proceedButton2.setEnabled(false);
        buttonsPanel2.add(proceedButton2);

        // Job Description Panel - Card 3

        //Body Title
        JLabel bodyTitle3 = new JLabel("Job Description*");
        setTextPosition(bodyTitle3);
        setPosition(c3, 0, 1, 1, 0, 10, 0, 0);
        descriptionPanel.add(bodyTitle3, c3);

        //Mandatory message
        JLabel mandatory3 = new JLabel("*Denotes mandatory field");
        setTextPosition(mandatory3);
        setButtonPosition(c3, 2, 1, 2, 0, 0, 0, 0);
        descriptionPanel.add(mandatory3, c3);

        //Description entry
        descriptionEntry = new JTextArea();
        descriptionEntry.setLineWrap(true);
        descriptionEntry.setWrapStyleWord(true);
        descriptionEntry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e1) {
                proceedButton3.setEnabled(descriptionEntry.getText().length() > 0);
            }
        });
        JScrollPane descScroll = new JScrollPane(descriptionEntry);
        descScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descScroll.setPreferredSize((new Dimension(500, 100)));
        setPosition(c3, 0, 2, 4, 10, 10, 0, 10);
        descriptionPanel.add(descScroll, c3);

        //Button Panel 3
        JPanel buttonsPanel3 = new JPanel();
        setButtonPosition(c3, 0, 10, 6, 50, 0, 0, 0);
        c3.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel3.setLayout(new BoxLayout(buttonsPanel3, BoxLayout.X_AXIS));
        descriptionPanel.add(buttonsPanel3, c3);

        //Back Button
        JButton backButton3 = new JButton("Back");
        backButton3.setFocusable(false);
        buttonsPanel3.add(backButton3);

        buttonsPanel3.add(Box.createHorizontalGlue());

        //Save Button
//        JButton saveButton3 = new JButton("Save");
//        saveButton3.setFocusable(false);
//        buttonsPanel3.add(saveButton3);

        buttonsPanel3.add(Box.createRigidArea(new Dimension(10, 0)));

        //Proceed Button
        proceedButton3 = new JButton("Continue");
        proceedButton3.setFocusable(false);
        proceedButton3.setEnabled(false);
        buttonsPanel3.add(proceedButton3);

        // Publish Panel - Card 4

        //Body Title
        JLabel bodyTitle4 = new JLabel("What would you like to do next?");
        setTextPosition(bodyTitle4);
        setPosition(c4, 0, 1, 5, 0, 0, 0, 0);
        c4.anchor = GridBagConstraints.CENTER;
        c4.fill = GridBagConstraints.NONE;
        publishPanel.add(bodyTitle4, c4);

        //Save Button
        JButton saveButton4 = new JButton("Save as draft");
        saveButton4.setFocusable(false);
        setButtonPosition(c4, 1, 3, 1, 20, 10, 10, 10);
        publishPanel.add(saveButton4, c4);

        //Preview Button
        JButton previewButton4 = new JButton("Preview");
        previewButton4.setFocusable(false);
        setButtonPosition(c4, 2, 3, 1, 20, 10, 10, 10);
        c4.anchor = GridBagConstraints.LINE_START;
        c4.fill = GridBagConstraints.NONE;
        publishPanel.add(previewButton4, c4);

        //Proceed Button
        JButton proceedButton4 = new JButton("Publish");
        proceedButton4.setFocusable(false);
        setButtonPosition(c4, 1, 4, 2, 10, 10, 10, 10);
        c4.fill = GridBagConstraints.NONE;
        c4.anchor = GridBagConstraints.CENTER;
        publishPanel.add(proceedButton4, c4);

        //Button Panel 4
        JPanel buttonsPanel4 = new JPanel();
        setButtonPosition(c4, 0, 5, 5, 50, 0, 0, 0);
        //c4.fill = GridBagConstraints.NONE;
        c4.anchor = GridBagConstraints.LINE_START;
        buttonsPanel4.setLayout(new BoxLayout(buttonsPanel4, BoxLayout.X_AXIS));
        publishPanel.add(buttonsPanel4, c4);

        //Back Button
        JButton backButton4 = new JButton("Back");
        backButton4.setFocusable(false);
        buttonsPanel4.add(backButton4);

        //Creating the action listeners
        backButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave without saving?", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                navigationController.setBody("RECRUITER");
                navigationController.setHeader("BUTTONS");
                clearJobDetails();
            }
        });

        AtomicInteger minInt = new AtomicInteger();
        AtomicInteger maxInt = new AtomicInteger();

        proceedButton.addActionListener(e -> {
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
            minInt.set(Integer.parseInt(minVal));
            maxInt.set(Integer.parseInt(maxVal));

            if (minInt.get() <= maxInt.get()) {
                setPage("SKILLS");
                progressBar.setValue(50);
                setPosition(c2, 0, 0, 4, 0, 0, 0, 0);
                skillsPanel.add(progressBar, c2);
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "The selected Maximum Pay must be equal or higher than the Minimum Pay", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton2.addActionListener(e -> {
            setPage("CREATEJOB");
            progressBar.setValue(25);
            setPosition(c, 0, 0, 6, 0, 0, 0, 0);
            jobDetailsPanel.add(progressBar, c);
        });

        proceedButton2.addActionListener(e -> {
            setPage("DESCRIPTION");
            progressBar.setValue(75);
            setPosition(c3, 0, 0, 6, 0, 0, 0, 0);
            descriptionPanel.add(progressBar, c3);
        });

        backButton3.addActionListener(e -> {
            setPage("SKILLS");
            progressBar.setValue(50);
            setPosition(c2, 0, 0, 4, 0, 0, 0, 0);
            skillsPanel.add(progressBar, c2);
        });

        proceedButton3.addActionListener(e -> {
            setPage("PUBLISH");
            progressBar.setValue(100);
            setPosition(c4, 0, 0, 4, 0, 0, 0, 0);
            publishPanel.add(progressBar, c4);
        });

        backButton4.addActionListener(e -> {
            setPage("DESCRIPTION");
            setPosition(c3, 0, 0, 6, 0, 0, 0, 0);
            descriptionPanel.add(progressBar, c3);
        });

        saveButton4.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to save this job to your drafts?", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

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
                int n = skillList.getModel().getSize();
                for (i = 0; i < n; i++) {
                    String temp = String.valueOf(skillList.getModel().getElementAt(i));
                    ski.add(temp);
                }

                List<String> qua = new ArrayList<>();
                int n2 = qualList.getModel().getSize();
                for (i = 0; i < n2; i++) {
                    String temp = String.valueOf(qualList.getModel().getElementAt(i));
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

                jobController.createNewJob(jobTitleEntry.getText(), keywordMap, String.valueOf(employmentTypeEntry.getSelectedItem()), descriptionEntry.getText(), maxInt.get(), minInt.get(), companyEntry.getText(), "Draft");

                navigationController.setBody("RECRUITER");
                navigationController.setHeader("BUTTONS");
                clearJobDetails();
            }
        });

        proceedButton4.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to publish this job??", "Warning",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

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
                int n = skillList.getModel().getSize();
                for (i = 0; i < n; i++) {
                    String temp = String.valueOf(skillList.getModel().getElementAt(i));
                    ski.add(temp);
                }

                List<String> qua = new ArrayList<>();
                int n2 = qualList.getModel().getSize();
                for (i = 0; i < n2; i++) {
                    String temp = String.valueOf(qualList.getModel().getElementAt(i));
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

                jobController.createNewJob(jobTitleEntry.getText(), keywordMap, String.valueOf(employmentTypeEntry.getSelectedItem()), descriptionEntry.getText(), maxInt.get(), minInt.get(), companyEntry.getText(), "Active");

                navigationController.setBody("RECRUITER");
                navigationController.setHeader("BUTTONS");
                clearJobDetails();
            }
        });
    }

    public void setPage(String page) {
        CardLayout createJob = (CardLayout) (this.getLayout());
        createJob.show(this, page);
    }

    public void setTextPosition(JLabel text) {
        text.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text.setVerticalAlignment(JLabel.TOP); //set page title top
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r) {
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(t, l, b, r);
    }

    public void setButtonPosition(GridBagConstraints c, int x, int y, int w, int t, int l, int b, int r) {
        c.gridwidth = w;
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(t, l, b, r);
    }

    public void clearJobDetails() {
        jobTitleEntry.setText("");
        companyEntry.setText("");
        locationEntry.setSelectedIndex(0);
        categoryEntry.setSelectedIndex(0);
        payTypeEntry.setSelectedIndex(0);
        payRangeMinEntry.setSelectedIndex(0);
        payRangeMaxEntry.setSelectedIndex(0);
        employmentTypeEntry.setSelectedIndex(0);
        skillModel.removeAllElements();
        educationEntry.setSelectedIndex(0);
        qualModel.removeAllElements();
        descriptionEntry.setText("");
    }
}