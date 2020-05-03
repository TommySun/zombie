package com.au.zombie.gameprogress;


import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameengine.GameStatus;

public interface RoundProgressStepHandler {

    void progress(GameStatus gameStatus) throws GameProgressException;
}
