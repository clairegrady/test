package controller;

import gui.MainFrame;

public class HeaderViewController {

    MainFrame mainFrame;

    public HeaderViewController (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
