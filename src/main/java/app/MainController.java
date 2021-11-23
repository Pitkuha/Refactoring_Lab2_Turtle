package app;

import app.domain.Figure;
import app.domain.Turtle;
import app.repository.FigureRepository;
import app.repository.UserRepository;
import app.util.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    private final FigureRepository figureRepository;

    @Autowired
    private final UserRepository userRepository;

    static ArrayList<Turtle> arrayList = new ArrayList<>();

    public MainController(FigureRepository figureRepository, UserRepository userRepository) {
        this.figureRepository = figureRepository;
        this.userRepository = userRepository;
    }


    @PostMapping(value = "/aut")
    public void aut(Principal principal) {
        Turtle turtle = new Turtle();
        turtle.setOwner(principal.getName());
        arrayList.add(turtle);
    }

    @GetMapping(value = "/test", produces = "application/json")
    public void test(@RequestParam int steps, Principal principal) {
        Turtle turtle = arrayList
                .stream()
                .filter(t -> t.getOwner().equals(principal.getName()))
                .findFirst().orElse(null);
        turtle.changeAngle(0);
        turtle.move(2);
        turtle.changeAngle(90);
        turtle.move(2);
        turtle.changeAngle(180);
        turtle.move(2);
        turtle.changeAngle(270);
        turtle.move(2);
    }

    @PostMapping(value = "/move")
    public String move(@RequestParam int steps, Principal principal) {
        Turtle turtle = arrayList
                .stream()
                .filter(t -> t.getOwner().equals(principal.getName()))
                .findFirst().orElse(null);
        turtle.move(steps);
        String s = "";
        if (turtle.getPenState() == 0) s = "put down";
        else s = "put up";
        return "Current color:" + turtle.getColor() + "," + "pen state:" + s + "," + "location:(" + turtle.getCoordinates().getX() +
                "," + turtle.getCoordinates().getY() + ")," + "direction:" + turtle.getAngle() + " degrees.";
    }

    @PostMapping(value = "/angle")
    public String angle(@RequestParam int angle, Principal principal) {
        Turtle turtle = arrayList
                .stream()
                .filter(t -> t.getOwner().equals(principal.getName()))
                .findFirst().orElse(null);
        turtle.changeAngle(angle);
        String s = "";
        if (turtle.getPenState() == 0) s = "put down";
        else s = "put up";
        return "Current color:" + turtle.getColor() + "," + "pen state:" + s + "," + "location:(" + turtle.getCoordinates().getX() +
                "," + turtle.getCoordinates().getY() + ")," + "direction:" + turtle.getAngle() + " degrees.";
    }

    @PostMapping(value = "/pen")
    public String pen(@RequestParam int pen, Principal principal) {
        Turtle turtle = arrayList
                .stream()
                .filter(t -> t.getOwner().equals(principal.getName()))
                .findFirst().orElse(null);
        turtle.setPenState(pen);
        String s = "";
        if (turtle.getPenState() == 0) s = "put down";
        else s = "put up";
        return "Current color:" + turtle.getColor() + "," + "pen state:" + s + "," + "location:(" + turtle.getCoordinates().getX() +
                "," + turtle.getCoordinates().getY() + ")," + "direction:" + turtle.getAngle() + " degrees.";
    }

    @GetMapping(value = "/getAll")
    public List<Figure> getAll(Principal principal) {
        List<Figure> f = figureRepository.findAllByOwner(userRepository.findByUsername(principal.getName()));
        for (Figure figure
                : f) {
            figure.setOwner(null);
        }
        return f;
    }

    @PostMapping(value = "/color")
    public String changeColor(@RequestParam int color, Principal principal) {
        Turtle turtle = arrayList
                .stream()
                .filter(t -> t.getOwner().equals(principal.getName()))
                .findFirst().orElse(null);
        if (color == 0) turtle.setColor(Color.BLACK);
        if (color == 1) turtle.setColor(Color.GREEN);
        String s = "";
        if (turtle.getPenState() == 0) s = "put down";
        else s = "put up";
        return "Current color:" + turtle.getColor() + "," + "pen state:" + s + "," + "location:(" + turtle.getCoordinates().getX() +
                "," + turtle.getCoordinates().getY() + ")," + "direction:" + turtle.getAngle() + " degrees.";
    }


}
