package ui;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;

public class PanelClass extends JPanel {
    private Circle circle;

    public void setCircle(Circle circle) {
        this.circle = circle;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (circle != null) {
            // get the state from circle and paint
            g.fillOval(50,50,50,50);
            g.setColor(Color.BLUE);
        }
    }
}
