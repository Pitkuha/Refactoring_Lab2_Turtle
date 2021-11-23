package app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FIGURES")
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient
    private ArrayList<Coordinates> points;

    private String coordinates;

    @ManyToOne
    private User owner;

    public Figure() {
    }

    private ArrayList<Coordinates> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Coordinates> points) {
        this.points = points;
    }

    public Figure(ArrayList<Coordinates> points) {
        this.points = points;
        this.coordinates = arrToString();
    }

    public void addCoord(Coordinates coordinates){
        points.add(coordinates);
    }

    public String arrToString(){
        StringBuilder str = new StringBuilder();
        for (Coordinates c :
                points) {
            str.append("[").append(c.getX()).append(";").append(c.getY()).append("]");
        }
        return str.toString();
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
