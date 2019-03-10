package ui;

import javafx.scene.shape.Circle;
import model.Tubble;

import java.awt.*;

public class TubbleRender {
    private Color tubble_Colour = new Color(150, 150, 10);
    private static final Color TARGET_COLOUR = new Color(204, 204, 204);
    private Tubble tubble;

    TubbleRender(Tubble tubble) {
        this.tubble = tubble;
    }

    void draw(Graphics graphics) {
        Circle targetTubble = new Circle(50,50,10);
//        drawSmallTubble(graphics);
//        drawLargeTubble(graphics);
    }
}
