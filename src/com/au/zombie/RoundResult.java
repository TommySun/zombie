package com.au.zombie;

/**
 * The result of each round
 */
public class RoundResult {

    private boolean gameContinue;

    public RoundResult(boolean gameContinue) {
        this.gameContinue = gameContinue;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }
}
