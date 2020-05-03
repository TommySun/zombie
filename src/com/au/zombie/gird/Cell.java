package com.au.zombie.gird;

public class Cell {
    private CellType type = CellType.EMPTY;;

    public void setType (CellType type){
        this.type = type;
    }

    public CellType getType() {
        return type;
    }
}
