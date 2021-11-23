package app.util;

import app.domain.Coordinates;
import app.domain.Figure;
import app.domain.Line;
import app.domain.Turtle;

import java.util.ArrayList;

public class Intersection {
    public static Figure checkIntersection(ArrayList<Coordinates> doneCord, int curX, int curY){
        for (int i = 0; i < doneCord.size() - 1; i++) {
            if (doneCord.get(i).getX() == curX && doneCord.get(i).getY() == curY){
                return new Figure(doneCord);
            }
        }
        return null;
    }
}
