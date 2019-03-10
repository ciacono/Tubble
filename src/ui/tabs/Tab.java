package ui.tabs;

import ui.TubbleAppUI;

import javax.swing.*;
import java.awt.*;

abstract class Tab extends JPanel {
    private TubbleAppUI tubbleAppUI;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Tab(TubbleAppUI tubbleAppUI){
        this.tubbleAppUI = tubbleAppUI;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public TubbleAppUI getTubbleAppUI(){
        return this.tubbleAppUI;
    }

}
