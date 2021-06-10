package jss;

import gui.*;

import javax.swing.*;


public class MitchTestMain {
    
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     *
     * This is borrowed from the oracle java tutorials - Mitch
     */

    private static void createAndShowGUI() {
        MainFrame main = new MainFrame();
    }


    public MitchTestMain() {

        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        try {
            // Set cross-platform Java L&F
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
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
}
