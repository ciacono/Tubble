package ui;

import javax.swing.*;
import java.awt.*;

public class PanelClass extends JPanel {

    public PanelClass() {
        setSize(500, 500);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(50,50,400,400);
        g.setColor(Color.cyan);
        }
    }
