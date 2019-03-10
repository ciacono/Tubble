package ui;

import javax.swing.*;
import java.awt.*;
//
public class PanelClass extends JPanel {

    public PanelClass() {
        setSize(1200, 700);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(400,200,400,400);
        }
    }
