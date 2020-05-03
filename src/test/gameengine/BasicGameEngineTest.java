package test.gameengine;

import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameengine.GameEngine;
import com.au.zombie.gameengine.GameEngineFactory;
import com.au.zombie.gameengine.GameStatus;
import com.au.zombie.gird.Coordinate;
import com.au.zombie.gird.GameBoardBuilder;
import com.au.zombie.input.Input;
import com.au.zombie.input.Move;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BasicGameEngineTest {

    /**
     * Test case for game engine. The grid is 10x10 and the move will only hit one creature at (2,3), the game should
     * finish at zombie move exhausted
     */
    @Test
    void testEngineOneHit() throws GameProgressException {
        Coordinate zombieCoordinate = new Coordinate(0, 0);
        List<Coordinate> creatureCoordinates = new ArrayList<>();
        creatureCoordinates.add(new Coordinate(2, 3));
        creatureCoordinates.add(new Coordinate(4, 7));
        creatureCoordinates.add(new Coordinate(8, 8));

        Queue<Move> moveQueue = new LinkedList<>();
        moveQueue.add(Move.D);
        moveQueue.add(Move.D);
        moveQueue.add(Move.D);
        moveQueue.add(Move.R);
        moveQueue.add(Move.R);
        moveQueue.add(Move.R);
        moveQueue.add(Move.R);
        Input input = new Input(10, 10, moveQueue, creatureCoordinates, zombieCoordinate);

        GameBoardBuilder boardBuilder =
                new GameBoardBuilder().withHeight(10).withWidth(10).zombieStartAt(input.getInitialZombieCoordinator())
                        .creatureLocatedAt(creatureCoordinates);

        GameEngine gameEngine = new GameEngineFactory(boardBuilder.build(), input).assembleGameEngine();

        while (gameEngine.getGameStatus().isGameContinue()) {
            gameEngine.progressARound();
        }

        GameStatus status = gameEngine.getGameStatus();
        assertFalse(status.isGameComplete());
        assertEquals(1, status.getScore());
        assertEquals(2, status.getScoreCoordinate().get(0).getX());
        assertEquals(3, status.getScoreCoordinate().get(0).getY());
    }

}