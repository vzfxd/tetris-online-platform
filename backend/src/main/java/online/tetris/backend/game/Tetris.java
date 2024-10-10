package online.tetris.backend.game;


import java.util.*;

public class Tetris {
    private final static int boardWidth = 10;
    private final static int boardHeight = 20;
    private char[][] board;

    private final int[][] currentBlockCords;
    private char currentBlockName;
    private int blockState;

    private final Queue<BlockType> blockQueue = new LinkedList<>();

    public Tetris() {
        this.board = new char[boardWidth][boardHeight];
        this.currentBlockCords = new int[4][2];

        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                board[x][y] = 'E';
            }
        }


        //TEMPORARY
        blockQueue.add(BlockType.I);
    }

    public void tick(){
        int[] down = new int[]{0,1};
        boolean moved = moveBlock(down);
        if(moved) return;

        List<Integer> clearedRows = new ArrayList<>();
        for(int y: currentBlockCords[1]){
            if(clearRow(y)){
                clearedRows.add(y);
            }
        }

        for(Integer y: clearedRows){
            moveRowsAbove(y);
        }

        spawnBlock(Objects.requireNonNull(blockQueue.poll()));
    }

    private void moveRowsAbove(int y){
        for(int y0 = y; y0 > 0; y0--){
            this.board[y0] = this.board[y0-1];
        }
    }

    private boolean clearRow(int y){
        char[][] copy = this.board.clone();

        for(int x = 0; x < boardWidth; x++){
            if(this.board[x][y] == 'E'){
                return false;
            }
            copy[x][y] = 'E';
        }

        this.board = copy;
        return true;
    }

    private void spawnBlock(BlockType block) {
        //TEMPORARY
        blockQueue.add(BlockType.I);

        int cords = 0;
        int startX = 3;

        String[] shape = block.getShape();
        this.currentBlockName = block.name().charAt(0);

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if(shape[x].charAt(y) == 'E') continue;
                if(board[x + startX][y] == 'E') throw new GameOver("game over");

                this.board[x + startX][y] = shape[x].charAt(y);
                this.currentBlockCords[cords] = new int[]{x, y};
                cords++;
            }
        }
    }

    private boolean moveBlock(int[] direction){
        int i = 0;

        for(int[] xy: this.currentBlockCords){
            int x = xy[0];
            int y = xy[1];
            int newX = x + direction[0];
            int newY = y + direction[1];

            if(board[newX][newY] != 'E') return false;

            board[x][y] = 'E';
            board[newX][newY] = this.currentBlockName;
            currentBlockCords[i] = new int[]{newX, newY};
        }

        return true;
    }

}
