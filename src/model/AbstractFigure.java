package model;

import java.awt.*;
import java.util.Random;

public abstract class AbstractFigure {
    private static final Color targetColour = new Color(220, 220, 220); //grey
    private Color shapeColour = randomColour();

    private int x;
    private int y;
    private int width;
    private int height;

    public AbstractFigure(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }

    // MODIFIES: this
    // EFFECTS: returns a random number 0 - 255 for generating RGB
    public Color randomColour() {
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(255) + 1;
        int green = randomGenerator.nextInt(255) + 1;
        int blue = randomGenerator.nextInt(255) + 1;
        return new Color(red, green, blue);
    }

    // getters
    public int getXCoord() { return x; }
    public int getYCoord() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    // EFFECTS: return true iff the given x value is within the bounds of the Shape
    public boolean containsX(int x) {
        return (this.x <= x) && (x <= this.x + width);
    }

    // EFFECTS: return true iff the given y value is within the bounds of the Shape
    public boolean containsY(int y) {
        return (this.y <= y) && (y <= this.y + height);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    public boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }

    // REQUIRES: the x,y coordinates of the Point are larger than the x,y coordinates of the shape
    // MODIFIES: this
    // EFFECTS:  sets the bottom right corner of this Shape to the given Point
    public void setBounds(Point bottomRight) {
        width = bottomRight.x - x;
        height = bottomRight.y - y;
    }


}
