package com.au.zombie.input;

import com.au.zombie.gird.Coordinate;

import java.util.List;
import java.util.Queue;

/**
 * Object holding the parameter input from the user.
 */
public class Input {

    private final int gridHeight;
    private final int gridWidth;
    private final Queue<Move> moves;
    private final List<Coordinate> creatureCoordinator;
    private final Coordinate initialZombieCoordinator;


    public Input(int height, int width, Queue<Move> moves, List<Coordinate> creatureCoordinator,
            Coordinate initialZombieCoordinator) {
        this.gridHeight = height;
        this.moves = moves;
        this.creatureCoordinator = creatureCoordinator;
        this.initialZombieCoordinator = initialZombieCoordinator;
        gridWidth = width;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public Queue<Move> getMoves() {
        return moves;
    }

    public List<Coordinate> getCreatureCoordinator() {
        return creatureCoordinator;
    }

    public Coordinate getInitialZombieCoordinator() {
        return initialZombieCoordinator;
    }
}
