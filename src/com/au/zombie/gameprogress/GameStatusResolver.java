package com.au.zombie.gameprogress;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameengine.GameStatus;
import com.au.zombie.gird.Cell;
import com.au.zombie.gird.CellType;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.input.Input;

import java.util.List;

/**
 * This handler responsible for if a game should continue or terminate
 */
public class GameStatusResolver implements RoundProgressStepHandler {

    private final GameBoard gameBoard;
    private final Input input;

    public GameStatusResolver(GameBoard gameBoard, Input input) {
        this.gameBoard = gameBoard;
        this.input = input;
    }

    /**
     * Check if there are any infect creature left or if there are any move left if neither, terminate the game
     *
     * @param gameStatus
     * @throws GameProgressException
     */
    @Override
    public void progress(GameStatus gameStatus) throws GameProgressException {
        List<List<Cell>> gameGrid = gameBoard.getGrid();

        boolean creatureRemain = isCreatureRemain(gameGrid);

        if(!creatureRemain || input.getMoves().peek() == null) {
            gameStatus.setGameContinue(false);
        }

        gameStatus.setGameComplete(!creatureRemain);
    }

    private boolean isCreatureRemain(List<List<Cell>> gameGrid) {
        boolean creatureRemain = false;
        for (List<Cell> row : gameGrid) {
            for (Cell cell : row) {
                if(cell.getType().equals(CellType.CREATURE)) {
                    creatureRemain = true;
                    break;
                }
            }
        }

        return creatureRemain;
    }
}
