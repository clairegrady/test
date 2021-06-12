package jss;

import gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GUILauncher {

    public GUILauncher() {
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        try {
            // Set cross-platform Java L&F
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            UIManager.put( "TabbedPane.selectedBackground", Color.white );
            UIManager.put( "TabbedPane.showTabSeparators", true );
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     *
     * This is borrowed from the oracle java tutorials - Mitch
     */
    private void createAndShowGUI() {
        MainFrame main = new MainFrame();
    }
}
