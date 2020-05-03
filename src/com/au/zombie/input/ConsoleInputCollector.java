package com.au.zombie.input;

import com.au.zombie.exceptions.InputCollectorException;
import com.au.zombie.gird.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ConsoleInputCollector implements InputCollector {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Input collectInput() {
        int gridDimension = collectGridDimension();

        Coordinate zombieStartCoordinate = collectZombieStartCoordinate(gridDimension - 1, gridDimension - 1);

        List<Coordinate> creatureCoordinates =
                collectCreatureCoordinate(gridDimension - 1, gridDimension - 1, zombieStartCoordinate);
        Queue<Move> moveQueue = collectMoves();

        return new Input(gridDimension, gridDimension, moveQueue, creatureCoordinates, zombieStartCoordinate);
    }

    /**
     * Collect grid dimension. This value is used for create game board
     *
     * @param
     * @return
     */
    private int collectGridDimension() {
        boolean validDimensionEntered = false;
        int result = 0;
        while (!validDimensionEntered) {
            System.out.println("Please enter a positive integer as game board dimension. It must be greater than 3");
            try {
                result = collectInteger(Integer.MAX_VALUE, 3);
                validDimensionEntered = true;
            } catch (InputCollectorException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unknown Input");
            }
        }
        return result;
    }


    /**
     * Return a {@link Coordinate} as zombie starting point
     *
     * @param maxX
     * @param maxY
     * @return
     */
    private Coordinate collectZombieStartCoordinate(int maxX, int maxY) {
        boolean validCoordinateEntered = false;
        Coordinate coordinate = null;

        while (!validCoordinateEntered) {
            try {
                System.out.println("Please enter Zombie start point");
                coordinate = collectCoordinate(maxX, maxY);
                validCoordinateEntered = true;
            } catch (InputCollectorException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Coordinate Entered.");
            }
        }

        return coordinate;
    }

    /**
     * Collect creature coordinated. 1. Ask user the enter max number of creatures 2. Ask user to enter coordinate for
     * each creature one after another
     * <p>
     * If there is a creature or zombie already on the coordinate, the input will be invalid
     *
     * @param maxX
     * @param maxY
     * @param zombieCoordinate
     * @return
     */
    private List<Coordinate> collectCreatureCoordinate(int maxX, int maxY, Coordinate zombieCoordinate) {
        boolean numOfCreatureEntered = false;
        int numberOfCreature = maxX * maxY;
        HashSet<Coordinate> creatureCoordinates = new HashSet<>();


        while (!numOfCreatureEntered) {
            try {
                System.out.println("Please Enter number of creature to be put on the game board");
                numberOfCreature = collectInteger(numberOfCreature - 1, 1);
                numOfCreatureEntered = true;
            } catch (InputCollectorException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid max number of creature entered");
            }
        }

        int count = 1;
        while (count <= numberOfCreature) {
            try {
                System.out.println("Please enter coordinate for creature #" + count);
                Coordinate creatureCoordinate = collectCoordinate(maxX, maxY);

                if (creatureCoordinate.equals(zombieCoordinate)) {
                    throw new InputCollectorException("Zombie is on this coordinate, please choose another one");
                }

                if (!creatureCoordinates.add(creatureCoordinate)) {
                    throw new InputCollectorException("There is already a creature on this coordinate");
                }

                count++;
            } catch (InputCollectorException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Value entered");
            }
        }

        return new ArrayList<>(creatureCoordinates);
    }

    /**
     * Collect a queue of {@link Move} from console input
     *
     * @param
     * @return
     */
    private Queue<Move> collectMoves() {
        boolean validMovesEntered = false;
        Queue<Move> moves = new LinkedList<>();

        while (!validMovesEntered) {
            try {
                System.out.println("Please enter a series of D,U,L,R. This will be move sequence of the Zombie");
                System.out.println("U stand for up, D stand for down, L stand for left and R stand for right ");
                String inputString = scanner.nextLine();
                String[] moveNames = inputString.split("");

                for (int i = 0; i < moveNames.length; i++) {
                    moves.add(Move.valueOf(moveNames[i].toUpperCase()));
                }
                validMovesEntered = true;
            } catch (Exception e) {
                System.out.println("Unknown move entered");
            }
        }
        return moves;
    }

    /**
     * Return a {@link Coordinate} object from 2 integer collected from console
     *
     * @param maxX
     * @param maxY
     * @return
     * @throws InputCollectorException
     */
    private Coordinate collectCoordinate(int maxX, int maxY) throws InputCollectorException {
        System.out.println("Please enter a Integer greater than 0 and less than " + maxX + " as X axis.");
        int x = collectInteger(maxX, 0);
        System.out.println("Please enter a Integer greater than 0 and less than " + maxY + " as Y axis.");
        int y = collectInteger(maxY, 0);

        return new Coordinate(x, y);
    }

    /**
     * Collect a Integer value from console. Invalid exception will be thrown if the number entered is less than min
     * (included) and greater than max (included)
     *
     * @param max
     * @param min
     * @return
     * @throws InputCollectorException
     */
    private int collectInteger(int max, int min) throws InputCollectorException {
        int result = Integer.parseInt(scanner.nextLine());
        if (result > max) {
            throw new InputCollectorException("Invalid Input. Number entered is greater than " + max);
        }

        if (result < min) {
            throw new InputCollectorException("Invalid Input. Number entered is less than " + min);
        }
        return result;
    }
}
