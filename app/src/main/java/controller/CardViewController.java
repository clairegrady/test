package controller;

import gui.MainFrame;

public class CardViewController {

    private MainFrame mainFrame;

    public CardViewController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void openJobManagement(){
        mainFrame.setBody("JOBMANAGER");
        mainFrame.setHeader("JOBMANAGER");
    }

}


