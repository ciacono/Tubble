package ui;

import model.Task;
import ui.tabs.HomeTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TubbleAppUI extends JFrame{

    public static final int HOME_TAB_INDEX = 0;
    public static final int SETTINGS_TAB_INDEX = 1;
    public static final int REPORT_TAB_INDEX = 2;

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    private JTabbedPane sidebar;
    private Task task;
    private HomeTab homeTab;

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

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);
        setVisible(true);
        initFrame();
        add(initInputPanel());
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

    // MODIFIES: this
    // EFFECTS: adds components to frame, do layout and make frame visible
    private void initFrame() {
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setResizable(false);
        JTextField t1, t2;
        t1 = new JTextField("tubble name?");
        t1.setBounds(150, 150, 200, 30);
        t2 = new JTextField("hours to spend?");
        t2.setBounds(150, 200, 200, 30);
        this.add(t1);
        this.add(t2);
        String name = t1.getText();
        t1.selectAll();

        String hour = t2.getText();
        t2.selectAll();
    }

    // MODIFIES: this
    // EFFECTS: adds components to frame
    private void addComponents() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JPanel inputPanel = initInputPanel();
        container.add(inputPanel);
        add(container);
    }

    // EFFECTS: initializes the input panel and returns it
    private JPanel initInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        JTextField nameTextField = initTextField("tubble name: ", inputPanel);
        JTextField hoursTextField = initTextField("tubble hours: ", inputPanel);

        addTubbleButton(inputPanel, nameTextField, hoursTextField);
        inputPanel.add(nameTextField);
        inputPanel.add(hoursTextField);

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
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameStr = nameTextField.getText();
                String hoursStr = hoursTextField.getText();
                try {
                    double hours = Integer.parseInt(hoursStr);
                    new Task(nameStr, hours);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TubbleAppUI.this, "Not integer input!");
                }
            }
        });

        inputPanel.add(button);
    }

}
