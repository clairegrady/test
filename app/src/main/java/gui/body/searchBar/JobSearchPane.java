package gui.body.searchBar;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controller.BodyViewController;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.*;

public class JobSearchPane extends JPanel {

    Dimension searchBarSize = new Dimension(800,40);
    BodyViewController bvc;

    public JobSearchPane(BodyViewController bvc) {
        super();
        this.bvc = bvc;
        this.setPreferredSize(searchBarSize);
        this.setLayout(new GridLayoutManager(1, 7, new Insets(5, 15, 5, 15), -1, -1));

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 10, 5, 10), -1, -1));
        JTextField textField = new JTextField(20);
        GhostText ghostText = new GhostText(textField, "Search");
        searchPanel.add(textField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.add(searchPanel, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 10, 5, 10), -1, -1));
        String jobKeywords[] = {"Job Type", "IT", "Engineering", "Finance", "Business"};
        JComboBox filterDropdown = new JComboBox(jobKeywords);
        filterPanel.add(filterDropdown, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.add(filterPanel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

        JPanel payPanel = new JPanel();
        payPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 10, 5, 10), -1, -1));
        String payKeywords[] = {"Salary", "50 - 80K", "80 - 100K", "100K+"};
        JComboBox payDropdown = new JComboBox(payKeywords);
        payPanel.add(payDropdown, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.add(payPanel, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 10, 5, 10), -1, -1));
        String locationKeywords[] = {"Location", "Melbourne", "Canberra", "Sydney"};
        JComboBox locationDropdown = new JComboBox(locationKeywords);
        locationPanel.add(locationDropdown, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.add(locationPanel, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 1, new Insets(5, 10, 5, 10), -1, -1));
        JButton button = new JButton("Search");
        button.addActionListener(e -> {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Test of button: " + textField.getText());
            // IF TEXTFIELD GREATER > 1, search by that, AND keywords, else just keywords
        });
        buttonPanel.add(button, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.add(buttonPanel, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
    }

    public static class GhostText implements FocusListener, DocumentListener, PropertyChangeListener
    {
        private final JTextField textComp;
        private boolean isEmpty;
        private final Color ghostColor;
        private Color foregroundColor;
        private final String ghostText;

        public GhostText(final JTextField textComp, String ghostText)
        {
            super();
            this.textComp = textComp;
            this.ghostText = ghostText;
            this.ghostColor = Color.LIGHT_GRAY;
            textComp.addFocusListener(this);
            registerListeners();
            updateState();
            if (!this.textComp.hasFocus())
            {
                focusLost(null);
            }
        }

        private void registerListeners()
        {
            textComp.getDocument().addDocumentListener(this);
            textComp.addPropertyChangeListener("foreground", this);
        }

        private void unregisterListeners()
        {
            textComp.getDocument().removeDocumentListener(this);
            textComp.removePropertyChangeListener("foreground", this);
        }

        private void updateState()
        {
            isEmpty = textComp.getText().length() == 0;
            foregroundColor = textComp.getForeground();
        }

        @Override
        public void focusGained(FocusEvent e)
        {
            if (isEmpty)
            {
                unregisterListeners();
                try
                {
                    textComp.setText("");
                    textComp.setForeground(foregroundColor);
                }
                finally
                {
                    registerListeners();
                }
            }

        }

        @Override
        public void focusLost(FocusEvent e)
        {
            if (isEmpty)
            {
                unregisterListeners();
                try
                {
                    textComp.setText(ghostText);
                    textComp.setForeground(ghostColor);
                }
                finally
                {
                    registerListeners();
                }
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {
            updateState();
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            updateState();
        }

        @Override
        public void insertUpdate(DocumentEvent e)
        {
            updateState();
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            updateState();
        }

    }

}
