package gui.body;

import application.JobSeeker;
import controller.NavigationController;
import controller.UserController;
import data.KeywordType;
import gui.modal.InvitationFrame;
import gui.modal.SeekerProfileFrame;

import javax.swing.*;
import java.awt.*;

public class SeekerProfileBody {

    private JPanel seekerPanel;
    private SeekerProfileFrame spf;
    private NavigationController navigationController;
    private UserController userController;
    private JobSeeker jobSeeker;

    public SeekerProfileBody(JobSeeker jobSeeker){
        this.jobSeeker = jobSeeker;
    }

    public JPanel createBody(){
        seekerPanel = new JPanel();
        seekerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        seekerPanel.setVisible(true);

        //Main Panel - Card 1

        //Body Title
        JLabel name = new JLabel(jobSeeker.getFirstName());
        setTextPosition(name);
        setPosition(c, 0, 1, 1, 1, 0, 0, 0, 0);
        seekerPanel.add(name, c);

        //Personal Summary
        JLabel summaryTitle = new JLabel("Personal Summary");
        setTextPosition(summaryTitle);
        setPosition(c, 0, 2, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(summaryTitle, c);

        JTextArea summaryText = new JTextArea(jobSeeker.getPersonalSummary());
        setTextAreaPosition(summaryText, 300, 100);
        setPosition(c, 0, 3, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(summaryText, c);

        //Experience
        JLabel experienceTitle = new JLabel("Experience");
        setTextPosition(experienceTitle);
        setPosition(c, 0, 4, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(experienceTitle, c);

        JTextArea experienceText = new JTextArea(jobSeeker.getExperience());
        setTextAreaPosition(experienceText, 300, 100);
        setPosition(c, 0, 5, 1, 3, 0, 10, 0, 10);
        seekerPanel.add(experienceText, c);

        //Skills
        JLabel skillsTitle = new JLabel("Skills");
        setTextPosition(skillsTitle);
        setPosition(c, 1, 2, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(skillsTitle, c);

        JTextArea skillsText = new JTextArea();
        if (jobSeeker.getKeywordsListForType(KeywordType.SKILL) != null) {
            jobSeeker.getKeywordsListForType(KeywordType.SKILL);
            for(int i = 0; i < jobSeeker.getKeywordsListForType(KeywordType.SKILL).size(); i++){
                skillsText.append(jobSeeker.getKeywordsListForType(KeywordType.SKILL).get(i) + "\n");
            }
        }
        setTextAreaPosition(skillsText, 300, 100);
        setPosition(c, 1, 3, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(skillsText, c);

        //Qualifications
        JLabel qualTitle = new JLabel("Qualifications");
        setTextPosition(qualTitle);
        setPosition(c, 1, 4, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(qualTitle, c);

        JTextArea qualText = new JTextArea(jobSeeker.getQualifications());
        setTextAreaPosition(qualText, 300, 70);
        setPosition(c, 1, 5, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(qualText, c);

        //Education
        JLabel educationTitle = new JLabel("Education");
        setTextPosition(educationTitle);
        setPosition(c, 1, 6, 1, 1, 10, 10, 0, 10);
        seekerPanel.add(educationTitle, c);

        JTextArea educationText = new JTextArea();
        if (jobSeeker.getKeywordsListForType(KeywordType.EDUCATION) != null) {
            educationText.setText(jobSeeker.getKeywordsListForType(KeywordType.EDUCATION).get(0));
        }
        setTextAreaPosition(educationText, 300, 20);
        setPosition(c, 1, 7, 1, 1, 0, 10, 0, 10);
        seekerPanel.add(educationText, c);

        return seekerPanel;
    }

    public void displayProfile() {
        SeekerProfileFrame spf = new SeekerProfileFrame(navigationController, userController);
        spf.displayProfile(seekerPanel);
        JButton invite = new JButton("Send Invitation");
        invite.addActionListener(e -> {
            InvitationFrame invitation = new InvitationFrame(navigationController);
        });
    }

    public void setTextAreaPosition(JTextArea textArea, int w, int h){
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(w,h));
        textArea.setEditable(false);
    }

    public void setPosition(GridBagConstraints c, int x, int y, int w, int h, int t, int l, int b, int r){
        c.gridwidth = w;
        c.gridheight = h;
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(t,l,b,r);
    }

    public void setTextPosition(JLabel text){
        text.setHorizontalAlignment(JLabel.LEFT); //set page title left
        text.setVerticalAlignment(JLabel.TOP); //set page title top
    }
}
