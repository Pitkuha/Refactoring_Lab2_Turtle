package app.service;

import app.domain.Figure;
import app.repository.FigureRepository;
import org.springframework.stereotype.Service;

@Service
public class FigureService {
    private static FigureRepository figureRepository = null;

    public FigureService(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    public static void saveFigure(Figure figure){
        figureRepository.save(figure);
    }
}
