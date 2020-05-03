package com.au.zombie.gameengine;

import com.au.zombie.gird.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Holding the current status of the game
 *
 */
public class GameStatus {

    private Coordinate currentZombieLocation;
    private boolean gameContinue = true;
    private List<Coordinate> infectedCreatureCoordinate;
    private boolean gameComplete = false;

    private int score = 0;

    public GameStatus(Coordinate currentZombieLocation) {
        this.currentZombieLocation = currentZombieLocation;
    }

    public Coordinate getCurrentZombieLocation() {
        return currentZombieLocation;
    }

    public void setCurrentZombieLocation(Coordinate currentZombieLocation) {
        this.currentZombieLocation = currentZombieLocation;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public void setGameContinue(boolean gameContinue) {
        this.gameContinue = gameContinue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Add adjustment to score
     * @param adjustment
     */
    public void addScore(int adjustment) {
        this.score = score + adjustment;
    }

    public List<Coordinate> getScoreCoordinate() {
        return this.infectedCreatureCoordinate;
    }

    public void addInfectedCreatureCoordinate(Coordinate coordinate){
        if(this.infectedCreatureCoordinate == null){
            this.infectedCreatureCoordinate = new ArrayList<>();
        }
        this.infectedCreatureCoordinate.add(coordinate);
    }

    public boolean isGameComplete() {
        return gameComplete;
    }

    public void setGameComplete(boolean gameComplete) {
        this.gameComplete = gameComplete;
    }
}
