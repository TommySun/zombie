package com.au.zombie.input;

/**
 * Move user can take to move zombie D - Down U - Up L- Left R - Right
 */
public enum Move {
    D(1), U(-1), L(-1), R(1);

    private int adjustment;

    Move(int adjustment) {
        this.adjustment = adjustment;
    }

    public int getAdjustment() {
        return adjustment;
    }
}
