package ui;

import javafx.scene.shape.Circle;
import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class TubbleAppUI2 extends JFrame {
    JPanel inputPanel = new JPanel();
    JLabel greeting;
    JTextField nameTextField = new JTextField("Enter tubble name");
    JTextField hoursTextField = new JTextField("Enter target hours");

    private static final String INIT_GREETING = "tubble: a time bubble to get you out of trouble!";
    public static final int HOME_TAB_INDEX = 0;

    TubbleRender renderer;

    Ellipse2D.Double circle;
    Circle circleTubble = new Circle(50,50,10);

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


//    public CircleComponent(int radius)
//    {
//        circle = new Ellipse2D.Double(0, 0, radius, radius);
////        setOpaque(false);
//    }

    // MODIFIES: inputPanel
    // EFFECTS: adds button to change spaceship coordinates to input panel
    private void addTubbleButton(JPanel inputPanel, final JTextField nameTextField, final JTextField hoursTextField) {
        JButton button = new JButton(ButtonNames.CREATE.getValue());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // TODO: create tubble when press button
                String nameStr = nameTextField.getText();
                String hoursStr = hoursTextField.getText();
                try {
                    double hours = Integer.parseInt(hoursStr);
                    new Task(nameStr, hours);
                    inputPanel.add(new PanelClass());
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TubbleAppUI2.this, "Not integer input!");
                }
            }
        });
        inputPanel.add(button);
    }

//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (circle != null) {
//            // get the state from circle and paint
//            g.fillOval(circle.getX(), circle.getY(), getWidth(), getHeight());
//        }
//    }

//    @Override
//    // MODIFIES: graphics
//    // EFFECTS:  clears screen and paints game onto graphics
//    public void paint(Graphics graphics) {
//        renderer.draw(graphics);
//    }

    //Next 2 methods not working for placing greeting on screen
    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public void HomeTab(TubbleAppUI2 this) {
        setLayout(new GridLayout(3, 1));
        placeGreeting();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting(){
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //launch program
    public static void main(String[] args) {
        new TubbleAppUI2();
    }

}
