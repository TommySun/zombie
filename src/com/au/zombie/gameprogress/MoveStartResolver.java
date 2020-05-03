package com.au.zombie.gameprogress;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameengine.GameStatus;
import com.au.zombie.gird.CellType;
import com.au.zombie.gird.GameBoard;

/**
 * Contain logic before a move is made in a round
 */
public class MoveStartResolver implements RoundProgressStepHandler {

    private final GameBoard gameBoard;

    public MoveStartResolver(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * This progress set the current cell zombie located to empty cell if it is not an infected creature
     *
     * @param gameStatus
     * @throws GameProgressException
     */
    @Override
    public void progress(GameStatus gameStatus) throws GameProgressException {

        if (!gameBoard.getCell(gameStatus.getCurrentZombieLocation()).getType().equals(CellType.INFECTED_CREATURE)) {
            gameBoard.setCellType(CellType.EMPTY, gameStatus.getCurrentZombieLocation());
        }

    }
}
