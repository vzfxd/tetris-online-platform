package online.tetris.backend.game;

public class GameOver extends RuntimeException {
    public GameOver(String message) {
        super(message);
    }
}
