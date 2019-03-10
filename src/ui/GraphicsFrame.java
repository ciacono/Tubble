package ui;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;

public class GraphicsFrame extends JPanel {

    public void paint(Graphics g) {
        setSize(500,500);
        g.drawOval(100,100,50,50);
        g.setColor(Color.BLUE);
        g.fillOval(100,100,50,50);

        g.drawOval(100,100,20,20);
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(600,600);
        Circle circlePanel = new Circle();
        mainFrame.add(circlePanel);
        mainFrame.setVisible(true);
    }
}
