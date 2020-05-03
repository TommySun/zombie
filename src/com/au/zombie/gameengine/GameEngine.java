package com.au.zombie.gameengine;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.input.Input;

public interface GameEngine {

    /**
     * Progress a round of game. Each move in the {@link Input#getMoves()} is a round of game
     *
     * @return
     */
    void progressARound() throws GameProgressException;

    /**
     * Return overall Result of the game
     *
     * @return
     */
    GameStatus getGameStatus();

    /**
     * Return game board, the GameEngine working against
     *
     * @return
     */
    GameBoard getGameBoard();
}
