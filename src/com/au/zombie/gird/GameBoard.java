package com.au.zombie.gird;

import java.util.List;

public class GameBoard {

    private List<List<Cell>> grid;

    public GameBoard(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public Cell getCell (Coordinate coordinate) {
        List<Cell> row = grid.get(coordinate.getY());
        return row.get(coordinate.getX());
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public int getHeight() {
        return grid.size();
    }

    public int getWidth() {
        return grid.get(0).size();
    }

    public void setCellType(CellType cellType, Coordinate coordinate) {
        Cell cell = getCell(coordinate);
        cell.setType(cellType);
    }

}
