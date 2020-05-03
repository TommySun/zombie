package com.au.zombie.gameengine;

import com.au.zombie.gameprogress.GameStatusResolver;
import com.au.zombie.gameprogress.MoveResultResolver;
import com.au.zombie.gameprogress.MoveStartResolver;
import com.au.zombie.gameprogress.RoundProgressStepHandler;
import com.au.zombie.gameprogress.ZombieCoordinationCalculator;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.input.Input;

import java.util.LinkedList;

public class GameEngineFactory {

    private GameBoard gameBoard;
    private Input input;


    public GameEngineFactory(GameBoard gameBoard, Input input) {
        this.gameBoard = gameBoard;
        this.input = input;
    }

    /**
     * Return an instance of {@link GameEngine}.
     *
     * @return
     */
    public GameEngine assembleGameEngine (){
        LinkedList<RoundProgressStepHandler> roundSteps = new LinkedList<>();
        roundSteps.add(new MoveStartResolver(gameBoard));
        roundSteps.add(new ZombieCoordinationCalculator(gameBoard, input));
        roundSteps.add(new MoveResultResolver(gameBoard));
        roundSteps.add(new GameStatusResolver(gameBoard, input));

        BasicGameEngine basicGameEngine = new BasicGameEngine(roundSteps, gameBoard, input);

        return basicGameEngine;
    }

}
