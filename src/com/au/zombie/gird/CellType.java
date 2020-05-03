package com.au.zombie.gird;

public enum CellType {


    ZOMBIE('z'), EMPTY('-'), CREATURE('c'), INFECTED_CREATURE('z');

    private char consoleIcon;

    CellType(char consoleIcon) {
        this.consoleIcon = consoleIcon;
    }

    public char getConsoleIcon() {
        return consoleIcon;
    }
}
