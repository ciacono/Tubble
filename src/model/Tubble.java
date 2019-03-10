package model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.awt.*;


public class Tubble {

    private double x;
    private double y;
    private double radius;
    private Paint fill;
    private int scale = 10;

    public Tubble(double x, double y, double radius, Paint fill) {
        Circle targetTubble = new Circle(x,y,radius,fill);
        this.x = x;
        this.y = y;
        this.radius = radius * scale;
        this.fill = fill;

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void incrementRadius(double increment) {
        this.radius += increment;
    }

    public Paint getFill() {
        return fill;
    }

    public void setFill(Paint fill) {
        this.fill = fill;
    }

}
