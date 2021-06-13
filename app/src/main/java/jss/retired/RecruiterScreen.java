package jss.retired;

import application.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class RecruiterScreen {
    private final JPanel screen;
    private final JPanel mainDisplayPanel;
    private final JLabel totalJobsLabel;
    public static JFrame frame;

    public static class JReferencingButton extends JButton{
        private int value;

        public int getJobNumber()
        {
            return this.value;
        }

        public void setJobNumber(int value)
        {
            this.value = value;
        }
    }

    RecruiterScreen(String firstName) {
        screen = new JPanel();
        screen.setLayout(new GridLayoutManager(4, 2, new Insets(15, 15, 15, 15), -1, -1));
        screen.setBackground(new Color(-6578528));

        /* Creation of the title pane - need to develop exit/logout buttons */
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));
        titlePanel.setBackground(new Color(-6578528));
        titlePanel.setForeground(new Color(-16777216));
        screen.add(titlePanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JLabel titleLabel = new JLabel();
        Font titleLabelFont = getFont(Font.BOLD, 24, titleLabel.getFont());
        if (titleLabelFont != null) titleLabel.setFont(titleLabelFont);
        titleLabel.setForeground(new Color(-16777216));
        titleLabel.setText("Job Seeker System - Recruiter");
        titlePanel.add(titleLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayoutManager(1, 4, new Insets(5, 15, 5, 15), -1, -1));
        optionsPanel.setBackground(new Color(-6578528));
        titlePanel.add(optionsPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(RecruiterScreen.class.getResource("logoutButton.jpg").getFile()));
        } catch (IOException ignored) {
        }

        JButton logoutButton = new JButton();
        ImageIcon logoutIcon = new ImageIcon(img);
        logoutButton.setIcon(logoutIcon);
        logoutButton.setBorderPainted(false);
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.addActionListener(logout -> {
            frame.dispose();
            LoginScreen.initiate();

        });

        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File(RecruiterScreen.class.getResource("faceButton.jpg").getFile()));
        } catch (IOException ignored) {
        }

        JButton profileButton = new JButton();
        ImageIcon profileIcon = new ImageIcon(img2);
        profileButton.setIcon(profileIcon);
        logoutButton.setBorderPainted(false);
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);

        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        logoutPanel.add(logoutButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        optionsPanel.add(logoutPanel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        profilePanel.add(profileButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        optionsPanel.add(profilePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        welcomePanel.setBackground(new Color(-6578528));
        optionsPanel.add(welcomePanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setForeground(new Color(-16777216));
        welcomeLabel.setText("Welcome " + firstName);
        welcomePanel.add(welcomeLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        optionsPanel.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        /*  Creating the Tabs for Active, Draft and Closed jobs */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 3, new Insets(5, 15, 5, 15), 0, 0));
        buttonPanel.setBackground(new Color(-6578528));
        screen.add(buttonPanel, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel activePanel = new JPanel();
        activePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        activePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton activeButton = new JButton();
        activeButton.setText("Active");
        blackOnWhite(activePanel, activeButton);
        activeButton.setBorderPainted(false);
        activePanel.add(activeButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel draftPanel = new JPanel();
        draftPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        draftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton draftButton = new JButton();
        draftButton.setText("Draft");
        blackOnGray(draftPanel, draftButton);
        draftButton.setBorderPainted(false);
        draftPanel.add(draftButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        JPanel closedPanel = new JPanel();
        closedPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        closedPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton closedButton = new JButton();
        closedButton.setText("Closed");
        blackOnGray(closedPanel, closedButton);
        closedButton.setBorderPainted(false);
        closedPanel.add(closedButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        /* Creating the action listeners to change the tabs and refresh the main panel */
        activeButton.addActionListener(e -> {
            blackOnWhite(activePanel, activeButton);
            blackOnGray(draftPanel, draftButton);
            blackOnGray(closedPanel, closedButton);
            fetchJobs(1);
        });

        draftButton.addActionListener(e -> {
            blackOnGray(activePanel, activeButton);
            blackOnWhite(draftPanel, draftButton);
            blackOnGray(closedPanel, closedButton);
            fetchJobs(2);
        });

        closedButton.addActionListener(e -> {
            blackOnGray(activePanel, activeButton);
            blackOnGray(draftPanel, draftButton);
            blackOnWhite(closedPanel, closedButton);
            fetchJobs(3);
        });

        buttonPanel.add(activePanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonPanel.add(draftPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonPanel.add(closedPanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        /* Initial creation of the main panel that shows the job cards */
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 5, 5));
        mainPanel.setBackground(new Color(-9868178));
        screen.add(mainPanel, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JScrollPane mainScrollPanel = new JScrollPane();
        mainScrollPanel.setBackground(new Color(-9868178));
        mainScrollPanel.setForeground(new Color(-9868178));
        mainScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPanel.setPreferredSize(new Dimension(500, 300));
        mainPanel.add(mainScrollPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        mainDisplayPanel = new JPanel();
        mainDisplayPanel.setLayout(new GridLayoutManager(4, 1, new Insets(5, 15, 5, 15), -1, -1));
        mainDisplayPanel.setBackground(new Color(-9868178));
        mainScrollPanel.setViewportView(mainDisplayPanel);

        /* Creating the total jobs text that goes between the tabs and the main display of job cards */
        JPanel totalJobsPanel = new JPanel();
        totalJobsPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 15, 5, 15), -1, -1));
        totalJobsPanel.setBackground(new Color(-6578528));
        totalJobsPanel.setForeground(new Color(-16777216));
        screen.add(totalJobsPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        totalJobsLabel = new JLabel();
        totalJobsLabel.setForeground(new Color(-16777216));
        totalJobsLabel.setText("You Have 4 Active Job Ads");
        totalJobsPanel.add(totalJobsLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPanel createJobPanel = new JPanel();
        createJobPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 5, 5, 5), -1, -1));
        createJobPanel.setBackground(new Color(-6578528));
        screen.add(createJobPanel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JButton createJobButton = new JButton();
        createJobButton.setBackground(new Color(-4734779));
        createJobButton.setForeground(new Color(-16777216));
        createJobButton.setText("Create Job Ad");
        createJobPanel.add(createJobButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    public static void blackOnGray(JPanel panel, JButton button){
        panel.setBackground(new Color(-9868178));
        button.setForeground(new Color(-16777216));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
    }

    public static void blackOnWhite(JPanel panel, JButton button){
        panel.setBackground(new Color(-1181441));
        button.setForeground(new Color(-16777216));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
    }

    public void createJobCard(String name, int num) { //need to add Job job here for the button purpose
        JPanel[] cards = new JPanel[num];
        JLabel[] labels = new JLabel[num];
        JReferencingButton[] buttons = new JReferencingButton[num];

        for (int i=0;i<num;i++){
            cards[i] = new JPanel();
            labels[i] = new JLabel();
            buttons[i] = new JReferencingButton();

            buttons[i].setText("Details");
            buttons[i].setJobNumber(i);
            buttons[i].addActionListener( ae -> {
                int job = ((JReferencingButton)ae.getSource()).getJobNumber();
                openJobDetails(job);
            });

            cards[i].setLayout(new GridLayoutManager(1, 2, new Insets(5, 15, 5, 15), -1, -1));
            Font jobNameFont = getFont(Font.BOLD | Font.ITALIC, -1, labels[i].getFont());
            if (jobNameFont != null) labels[i].setFont(jobNameFont);
            labels[i].setText(name);

            blackOnWhite(cards[i], buttons[i]);
            cards[i].setPreferredSize(new Dimension(470, 70));
            cards[i].add(labels[i], new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            cards[i].add(buttons[i], new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

            mainDisplayPanel.add(cards[i], new GridConstraints(i, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        }
    }

    /*
fetchJobs(int number) takes 1,2,3 based on tab selected and fetches jobs
fetch job adds a job card each time and adds to a counter
counter is used to know how many are being loaded
changes text in label saying "You have such and such active jobs" */
    public void fetchJobs(int number) {
        String tempStatus = "";
        if (number == 1) {
            tempStatus = "active";
        }
        else if (number == 2) {
            tempStatus = "draft";
        }
        else if (number == 3) {
            tempStatus = "closed";
        }
        int jobCount;

        getMainDisplayPanel().removeAll();
        getMainDisplayPanel().revalidate();
        getMainDisplayPanel().repaint();

        /* TEMP CODE FOR DUMMY DATA */
        if (number == 1) {
            jobCount = 4;
        }
        else if (number == 2) {
            jobCount = 0;
        }
        else {
            jobCount = 1;
        }

        if (jobCount > 0) {
            createJobCard("Software Engineer", jobCount);
        }
    /*
    recruiter.getJobInteractions().forEach((job) -> {
        if (job.getStatus() == tempStatus) {
            createJobCard(job)
            jobCount += 1
            }
        });
        */

        getTotalJobsLabel().setText("You have " + jobCount + " " + tempStatus + " Job Ads");
    }

    public static Font getFont(int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName = currentFont.getName();
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    public JPanel getMainDisplayPanel() {
        return mainDisplayPanel;
    }

    public JPanel getScreen() {
        return screen;
    }

    public JLabel getTotalJobsLabel() {
        return totalJobsLabel;
    }

    public static void initiate(User recruiter){
        frame = new JFrame("Job Seeker System (Recruiter)");
        RecruiterScreen rScreen = new RecruiterScreen(recruiter.getFirstName());
        rScreen.fetchJobs(1);
        frame.setContentPane(rScreen.getScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void openJobDetails(int job) {
        JFrame detailFrame = new JFrame("Job Details " + job);
        LoginScreen lScreen = new LoginScreen();
        detailFrame.setContentPane(lScreen.getScreen());
        detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailFrame.setSize(new Dimension(600,400));
        detailFrame.setLocationRelativeTo(null);
        detailFrame.setVisible(true);
    }
}