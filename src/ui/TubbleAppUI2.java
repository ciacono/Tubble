package ui;

import javax.swing.*;

public class TubbleAppUI2 extends JFrame {
    JPanel jp = new JPanel();
    JTextField nameTextField = new JTextField("Enter tubble name");
    JTextField hoursTextField = new JTextField("Enter target hours");


    TubbleAppUI2() {
        super("TubbleApp Console");
        setVisible(true);
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp.add(nameTextField);
        jp.add(hoursTextField);
        add(jp);
    }

    //launch program
    public static void main(String[] args) {
        new TubbleAppUI2();
    }}
