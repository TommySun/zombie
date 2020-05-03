package com.au.zombie.exceptions;

/**
 * Exception thrown during the initiate phase of the grid
 *
 */
public class gridBuildingException extends Exception {

    public gridBuildingException (Throwable cause, String message){
        super(message, cause);
    }
}
