package com.au.zombie.gameprogress;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameengine.GameStatus;
import com.au.zombie.gird.Coordinate;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.input.Input;
import com.au.zombie.input.Move;

/**
 * Calculate the new Zombie coordinate from a move from the queue, and set the state on the cell accordingly. This
 * calculator assume zombie will take only one step each round towards a single direction
 */
public class ZombieCoordinationCalculator implements RoundProgressStepHandler {


    private final GameBoard gameBoard;
    private final Input input;

    public ZombieCoordinationCalculator(GameBoard gameBoard, Input input) {
        this.gameBoard = gameBoard;
        this.input = input;
    }



    /**
     * Calculate new Zombie location and adjust it according the grid boundary.
     *
     * @param gameStatus
     * @throws GameProgressException
     */
    @Override
    public void progress(final GameStatus gameStatus) throws GameProgressException {
        Move move = input.getMoves().poll();

        // Free cell, set current zombie cell to empty
        Coordinate newLocation = getNewCoordinate(gameStatus.getCurrentZombieLocation(), move);
        gameStatus.setCurrentZombieLocation(boundaryAdjustment(newLocation, gameBoard));
    }


    private Coordinate boundaryAdjustment(Coordinate coordinate, GameBoard gameBoard) {

        Integer adjustedX = coordinate.getX();
        Integer adjustedY = coordinate.getY();

        // adjust X
        if (adjustedX < 0) {
            adjustedX = gameBoard.getWidth() - 1;
        } else if (adjustedX > gameBoard.getWidth() - 1) {
            adjustedX = 0;
        }

        // adjust Y
        if (adjustedY < 0) {
            adjustedY = gameBoard.getHeight() - 1;
        } else if (adjustedY > gameBoard.getHeight() - 1) {
            adjustedY = 0;
        }


        return new Coordinate(adjustedX, adjustedY);
    }


    private Coordinate getNewCoordinate(Coordinate currentLocation, Move move) throws GameProgressException {
        Integer zombieNewLocationX = currentLocation.getX();
        Integer zombieNewLocationY = currentLocation.getY();

        switch (move) {
            case D:
            case U:
                Integer y = currentLocation.getY();
                zombieNewLocationY = y + move.getAdjustment();
                break;

            case L:
            case R:
                Integer x = currentLocation.getX();
                zombieNewLocationX = x + move.getAdjustment();
                break;

            default:
                throw new GameProgressException("Unknown Move Detected");
        }

        return new Coordinate(zombieNewLocationX, zombieNewLocationY);
    }
}
