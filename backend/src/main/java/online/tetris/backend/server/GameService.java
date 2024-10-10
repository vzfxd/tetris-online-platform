package online.tetris.backend.server;

import online.tetris.backend.game.Tetris;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private List<Tetris> games;
}
