package ui;

import model.Task;
import ui.tabs.HomeTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TubbleAppUI extends JFrame {

    public static final int HOME_TAB_INDEX = 0;
    public static final int SETTINGS_TAB_INDEX = 1;
    public static final int REPORT_TAB_INDEX = 2;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private Task task;

    public Task getTask() {
        return task;
    }

    //launch program
    public static void main(String[] args) {
        new TubbleAppUI();
    }

    //MODIFIES: this
    //EFFECTS: creates SmartHomeUI, loads SmartHome appliances, displays sidebar and tabs
    private TubbleAppUI() {
        super("TubbleApp Console");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        task = new Task();

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
//        sidebar.add(settingsTab, SETTINGS_TAB_INDEX);
//        sidebar.setTitleAt(SETTINGS_TAB_INDEX, "Settings");
//        sidebar.add(reportTab, REPORT_TAB_INDEX);
//        sidebar.setTitleAt(REPORT_TAB_INDEX, "Report");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane(){
        return sidebar;
    }

    // EFFECTS: initializes the input panel and returns it
    private JPanel initInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        JTextField moveXTextField = initTextField("Move X By: ", inputPanel);
        JTextField moveYTextField = initTextField("Move Y By: ", inputPanel);

        addTubbleButton(inputPanel, moveXTextField, moveYTextField);

        return inputPanel;
    }

    // MODIFIES: inputPanel
    // EFFECTS: adds test field with given label to input panel and returns the textfield
    private JTextField initTextField(String lbl, JPanel inputPanel) {
        JTextField textField = new JTextField(10);
        inputPanel.add(new JLabel(lbl));
        inputPanel.add(textField);
        return textField;
    }

    // MODIFIES: inputPanel
    // EFFECTS: adds button to change spaceship coordinates to input panel
    private void addTubbleButton(JPanel inputPanel, final JTextField nameTextField, final JTextField hoursTextField) {
        JButton button = new JButton("Create Tubble!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameStr = nameTextField.getText();
                String hoursStr = hoursTextField.getText();
                try {
                    double hours = Integer.parseInt(hoursStr);
                    new Task(nameStr, hours);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TubbleAppUI.this, "Not integer input(s)!");
                }
            }
        });

        inputPanel.add(button);
    }
}
