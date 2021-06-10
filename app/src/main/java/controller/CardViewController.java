package controller;

import gui.MainFrame;

public class CardViewController {

    MainFrame mf;

    public CardViewController(MainFrame mf){
        this.mf = mf;
    }

    public void openJobManagement(){
        mf.setBody("JOBMANAGER");
    }


}


