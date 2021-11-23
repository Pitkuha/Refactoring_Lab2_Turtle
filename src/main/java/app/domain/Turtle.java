package app.domain;

import app.util.Color;
import app.util.Direction;

import java.util.ArrayList;

public class Turtle {
    String owner;
    Coordinates coordinates = new Coordinates(0, 0);
    int angle = 0;
    int penState = 0;
    ArrayList<Coordinates> linePoints = new ArrayList<>();
    ArrayList<Coordinates> usinPoints = new ArrayList<>();
    Color color = Color.BLACK;

    public void move(int steps) {
        if (getAngle() == 0) {
            coordinates.change(steps, Direction.RIGHT, this.penState, this.owner);
        }
        if (getAngle() == 90) {
            coordinates.change(steps, Direction.UP, this.penState, this.owner);
        }
        if (getAngle() == 180) {
            coordinates.change(steps, Direction.LEFT, this.penState, this.owner);
        }
        if (getAngle() == 270) {
            coordinates.change(steps, Direction.DOWN, this.penState, this.owner);
        }
    }

    public void changeAngle(int angle) {
        if (angle % 90 != 0) {
            System.out.println("Угол говно!");
        } else
            this.angle = angle % 360;
    }

    public int getAngle() {
        return angle;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPenState() {
        return penState;
    }

    public void setPenState(int penState) {
        this.penState = penState;
        if (penState == 1) {
            coordinates.saveLastBeforePenUp();
        }
    }


}
