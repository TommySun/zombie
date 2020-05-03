package com.au.zombie.gameprogress;

import com.au.zombie.gameengine.GameStatus;
import com.au.zombie.gird.Cell;
import com.au.zombie.gird.CellType;
import com.au.zombie.gird.GameBoard;

/**
 * This step resolve the type of a cell on the board depending on the current coordinate of the zombie
 */
public class MoveResultResolver implements RoundProgressStepHandler {

    private final GameBoard gameBoard;

    public MoveResultResolver(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * Set the status of the cell zombie located in. If it is a creature cell
     * 1. set it as infected creature
     * 2. Add 1 to score
     * 3. Add infected creature to game status.
     *
     * @param gameStatus
     */
    @Override
    public void progress(final GameStatus gameStatus) {

        Cell zombieLocationCell = gameBoard.getCell(gameStatus.getCurrentZombieLocation());

        if (zombieLocationCell.getType().equals(CellType.CREATURE)) {
            zombieLocationCell.setType(CellType.INFECTED_CREATURE);
            gameStatus.addScore(1);
            gameStatus.addInfectedCreatureCoordinate(gameStatus.getCurrentZombieLocation());
        } else {
            zombieLocationCell.setType(CellType.ZOMBIE);
        }


    }
}
