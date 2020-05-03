package com.au.zombie.input;

public interface InputCollector {

    /**
     * Return an {@link Input} instance contain all input from user for game to be played.
     *
     * @return
     */
    Input collectInput();
}
