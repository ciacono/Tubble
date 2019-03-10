package ui;

import javax.swing.*;
import java.awt.*;

public class PanelClass extends JPanel {

    public PanelClass() {
        setSize(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(50,50,50,50);
        g.setColor(Color.BLUE);
        }
    }
