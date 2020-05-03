package com.au.zombie.gird;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder class for the grid
 */
public class GameBoardBuilder {

    private Integer height;
    private Integer width;
    private Coordinate zombieCoordinate;
    private List<Coordinate> creatureCoordinates;

    public GameBoard build() {
        List<List<Cell>> grid = new ArrayList<>();

        // Fill grid with empty cell
        for (Integer h = 0; h < height; h++) {
            List<Cell> row = new ArrayList<>();
            for (Integer w = 0; w < width; w++) {
                row.add(new Cell());
            }
            grid.add(row);
        }

        // Deploy Zombie on the grid
        grid.get(zombieCoordinate.getY()).get(zombieCoordinate.getX()).setType(CellType.ZOMBIE);

        // Deploy creatures on the grid
        creatureCoordinates.stream().forEach(coordinate -> {
            grid.get(coordinate.getY()).get(coordinate.getX()).setType(CellType.CREATURE);
        });

        return new GameBoard(grid);
    }

    public GameBoardBuilder withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public GameBoardBuilder withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public GameBoardBuilder zombieStartAt(Coordinate zombieCoordinate) {
        this.zombieCoordinate = zombieCoordinate;
        return this;
    }

    public GameBoardBuilder creatureLocatedAt (List<Coordinate> creatureCoordinates){
        this.creatureCoordinates = creatureCoordinates;
        return this;
    }
}
