package app.repository;

import app.domain.Figure;
import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FigureRepository extends JpaRepository<Figure, Long> {
    List<Figure> findAllByOwner(User owner);
}
