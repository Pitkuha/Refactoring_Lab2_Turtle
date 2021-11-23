package app.domain;

import app.service.FigureService;
import app.service.UserBadService;
import app.util.Direction;
import app.util.Intersection;

import java.util.ArrayList;

public class Coordinates {
    int x;
    int y;
    ArrayList<Coordinates> usinPoints = new ArrayList<>();


    @SuppressWarnings("DuplicatedCode")
    public void change(int steps, Direction direction, int penState, String owner) {
        switch (direction) {
            case UP:
                for (int i = 0; i < steps; i++) {
                    if (penState == 0) {
                        usinPoints.add(new Coordinates(x, y));
                    }
                    y += 1;
                    Figure figure = Intersection.checkIntersection(usinPoints, x, y);
                    if (figure != null) {
                        figure.addCoord(new Coordinates(x, y));
                        figure.setOwner(UserBadService.getUser(owner));
                        FigureService.saveFigure(figure);
                        figure = null;
                        usinPoints = new ArrayList<>();
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if (penState == 0) {
                        usinPoints.add(new Coordinates(x, y));
                    }
                    x -= 1;
                    Figure figure = Intersection.checkIntersection(usinPoints, x, y);
                    if (figure != null) {
                        figure.addCoord(new Coordinates(x, y));
                        figure.setOwner(UserBadService.getUser(owner));
                        FigureService.saveFigure(figure);
                        figure = null;
                        usinPoints = new ArrayList<>();
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if (penState == 0) {
                        usinPoints.add(new Coordinates(x, y));
                    }
                    x += 1;
                    Figure figure = Intersection.checkIntersection(usinPoints, x, y);
                    if (figure != null) {
                        figure.addCoord(new Coordinates(x, y));
                        figure.setOwner(UserBadService.getUser(owner));
                        FigureService.saveFigure(figure);
                        figure = null;
                        usinPoints = new ArrayList<>();
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if (penState == 0) {
                        usinPoints.add(new Coordinates(x, y));
                    }
                    y -= 1;
                    Figure figure = Intersection.checkIntersection(usinPoints, x, y);
                    if (figure != null) {
                        figure.addCoord(new Coordinates(x, y));
                        figure.setOwner(UserBadService.getUser(owner));
                        FigureService.saveFigure(figure);
                        figure = null;
                        usinPoints = new ArrayList<>();
                    }
                }
                break;
        }
    }

    public Coordinates() {
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void saveLastBeforePenUp() {
        usinPoints.add(new Coordinates(x, y));
    }
}
