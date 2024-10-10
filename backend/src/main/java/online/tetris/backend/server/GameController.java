package online.tetris.backend.server;

import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

}
