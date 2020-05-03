package test.gameprogressor;

import com.au.zombie.gameengine.GameStatus;
import com.au.zombie.exceptions.GameProgressException;
import com.au.zombie.gameprogress.ZombieCoordinationCalculator;
import com.au.zombie.gird.Cell;
import com.au.zombie.gird.Coordinate;
import com.au.zombie.gird.GameBoard;
import com.au.zombie.input.Input;
import com.au.zombie.input.Move;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZombieCoordinationCalculatorTest {

    @Test
    void theCalculateNewCoordinateMoveDown() throws GameProgressException {

        GameStatus gameStatus = new GameStatus(new Coordinate(3, 3));
        List<List<Cell>> testGrid = getTestBoard();
        GameBoard testBoard = new GameBoard(testGrid);
        Queue<Move> moves = new LinkedList<>();
        moves.add(Move.D);
        Input input = new Input(4, 4, moves, null, null);
        ZombieCoordinationCalculator coordinationCalculator = new ZombieCoordinationCalculator(testBoard, input);
        coordinationCalculator.progress(gameStatus);
        assertEquals(3, gameStatus.getCurrentZombieLocation().getX());
        assertEquals(0, gameStatus.getCurrentZombieLocation().getY());
    }

    private List<List<Cell>> getTestBoard() {

        List<List<Cell>> grid = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                row.add(new Cell());
            }
            grid.add(row);
        }

        return grid;
    }

}