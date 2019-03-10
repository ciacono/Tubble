package ui;

import model.Task;
import ui.tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TubbleAppUI2 extends JFrame {
    JPanel inputPanel = new JPanel();
    JLabel greeting = new JLabel();
    JTextField nameTextField = new JTextField("Enter tubble name");
    JTextField hoursTextField = new JTextField("Enter target hours");

    private static final String INIT_GREETING = "tubble: a time bubble to get you out of trouble!";
    private JTabbedPane sidebar;
    public static final int HOME_TAB_INDEX = 0;


    TubbleAppUI2() {
        super("TubbleApp Console");
        setVisible(true);
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inputPanel.add(nameTextField);
        inputPanel.add(hoursTextField);
        addTubbleButton(inputPanel, nameTextField, hoursTextField);

        add(inputPanel);

    }

    // MODIFIES: inputPanel
    // EFFECTS: adds button to change spaceship coordinates to input panel
    private void addTubbleButton(JPanel inputPanel, final JTextField nameTextField, final JTextField hoursTextField) {
        JButton button = new JButton(ButtonNames.NEW.getValue());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // TODO: create tubble wen press button
                String nameStr = nameTextField.getText();
                String hoursStr = hoursTextField.getText();
                try {
                    double hours = Integer.parseInt(hoursStr);
                    new Task(nameStr, hours);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TubbleAppUI2.this, "Not integer input!");
                }
            }
        });
        inputPanel.add(button);
    }

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public void HomeTab(TubbleAppUI2 tubbleAppUI2) {
        setLayout(new GridLayout(3, 1));
        placeGreeting();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting(){
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

//    //MODIFIES: this
//    //EFFECTS: adds home tab, settings tab and report tab to this UI
//    private void loadTabs() {
//        JPanel homeTab = new HomeTab(this);
//
//        sidebar.add(homeTab, HOME_TAB_INDEX);
//        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
////        sidebar.add(settingsTab, SETTINGS_TAB_INDEX);
////        sidebar.setTitleAt(SETTINGS_TAB_INDEX, "Settings");
////        sidebar.add(reportTab, REPORT_TAB_INDEX);
////        sidebar.setTitleAt(REPORT_TAB_INDEX, "Report");
//    }

    //launch program
    public static void main(String[] args) {
        new TubbleAppUI2();
    }

}