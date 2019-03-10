package ui.tabs;

import ui.ButtonNames;
import ui.TubbleApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTab extends Tab {

    private static final String INIT_GREETING = "tubble";
    private JLabel greeting;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(TubbleApp tubbleApp) {
        super(tubbleApp);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeNewTubbleButton();
        placeStatusButton();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting(){
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //EFFECTS: creates New Tubble button
    private void placeNewTubbleButton(){
        JButton b1 = new JButton(ButtonNames.NEW.getValue());

        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if(buttonPressed.equals(ButtonNames.ARRIVE.getValue())) {
                    getController().getSmartHome().arriveHome();
                    greeting.setText("Welcome Home!");
                }

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if(buttonPressed.equals(ButtonNames.LEAVE.getValue())) {
                    getController().getSmartHome().leaveHome();
                    greeting.setText("Goodbye!");
                }
            }
        });

        this.add(buttonRow);
    }

    //EFFECTS: constructs a status button that switches to the report tab on the console
    private void placeStatusButton(){
        JPanel statusBlock = new JPanel();
        JButton statusButton = new JButton(ButtonNames.GO_TO_REPORT.getValue());
        statusBlock.add(formatButtonRow(statusButton));

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if(buttonPressed.equals(ButtonNames.GO_TO_REPORT.getValue())){
                    getController().getTabbedPane().setSelectedIndex(SmartHomeUI.REPORT_TAB_INDEX);
                }
            }
        });

        this.add(statusBlock);
    }
}