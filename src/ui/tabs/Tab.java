package ui.tabs;

import model.Tubble;
import ui.TubbleApp;

import javax.swing.*;
import java.awt.*;

abstract class Tab extends JPanel {
    private TubbleApp tubbleApp;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Tab(TubbleApp tubbleApp){
        this.tubbleApp = tubbleApp;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public TubbleApp getTubbleApp(){
        return this.tubbleApp;
    }

}
