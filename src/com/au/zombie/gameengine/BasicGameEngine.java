package com.au.zombie.gameengine;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameprogress.RoundProgressStepHandler;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.input.Input;

import java.util.LinkedList;

/**
 * The Basic Controller of the game.
 */
public class BasicGameEngine implements GameEngine {


    private LinkedList<RoundProgressStepHandler> roundProgressSteps;
    private GameBoard gameBoard;
    private Input input;
    private GameStatus gameStatus;


    public BasicGameEngine(LinkedList<RoundProgressStepHandler> roundProgressSteps, GameBoard gameBoard, Input input) {
        this.roundProgressSteps = roundProgressSteps;
        this.gameBoard = gameBoard;
        this.input = input;
        gameStatus = new GameStatus(input.getInitialZombieCoordinator());
    }

    /**
     * Progress a round of game. Each move in the {@link Input#getMoves()} is a round of game
     *
     * @return
     */
    public void progressARound() throws GameProgressException {
        for (RoundProgressStepHandler progressor : roundProgressSteps) {
            progressor.progress(gameStatus);
        }
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
