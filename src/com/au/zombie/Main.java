package com.au.zombie;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.exceptions.InputCollectorException;
import com.au.zombie.gameengine.GameEngine;
import com.au.zombie.gameengine.GameEngineFactory;
import com.au.zombie.gird.Cell;
import com.au.zombie.gird.Coordinate;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.gird.GameBoardBuilder;
import com.au.zombie.input.Input;
import com.au.zombie.input.InputCollectMethod;
import com.au.zombie.input.InputCollector;
import com.au.zombie.input.InputCollectorFactory;

public class Main {

    public static void main(String[] args) {



        try {
            //Gather input

            InputCollector inputCollector = new InputCollectorFactory().getInputCollector(InputCollectMethod.CONSOLE);
            Input input = inputCollector.collectInput();


            // initiate Game
            GameBoardBuilder boardBuilder =
                    new GameBoardBuilder().withHeight(input.getGridHeight()).withWidth(input.getGridWidth())
                            .zombieStartAt(input.getInitialZombieCoordinator())
                            .creatureLocatedAt(input.getCreatureCoordinator());

            GameEngine gameEngine = new GameEngineFactory(boardBuilder.build(), input).assembleGameEngine();


            printGrid(gameEngine.getGameBoard());

            System.out.println("Infecting....");
            while (gameEngine.getGameStatus().isGameContinue()){
                gameEngine.progressARound();
            }

            System.out.println("Your score " + gameEngine.getGameStatus().getScore());

            if(gameEngine.getGameStatus().getScoreCoordinate() != null) {
                System.out.println("Infected creature positions ");
                StringBuilder stringBuilder = new StringBuilder();
                for (Coordinate scoreCoordinate: gameEngine.getGameStatus().getScoreCoordinate()) {
                    stringBuilder.append(scoreCoordinate.toString());
                }
                System.out.println(stringBuilder.toString());
            }

            if (gameEngine.getGameStatus().isGameComplete()) {
                System.out.println("Congratulation, you got all of them!");
            } else {
                System.out.println ("To bad, you didn't get all of them!");
            }

            printGrid(gameEngine.getGameBoard());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } catch (GameProgressException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Print the game grid on console
     *
     * @param gameBoard
     */
    private static void printGrid(GameBoard gameBoard) {
        for (int y = 0; y < gameBoard.getHeight(); y++) {
            for (int x = 0; x < gameBoard.getWidth(); x++) {
                System.out.print(gameBoard.getCell(new Coordinate(x,y)).getType().getConsoleIcon());
            }
            System.out.println("");
        }
    }
}
