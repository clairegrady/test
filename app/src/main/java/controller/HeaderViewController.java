package controller;

import gui.MainFrame;

public class HeaderViewController {

    private MainFrame mainFrame;

    public HeaderViewController (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
