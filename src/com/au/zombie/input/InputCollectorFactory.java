package com.au.zombie.input;

import com.au.zombie.exceptions.InputCollectorException;

public class InputCollectorFactory {

    public InputCollector getInputCollector(InputCollectMethod inputCollectMethod) throws InputCollectorException {
        InputCollector inputCollector = null;

        switch (inputCollectMethod) {
            case HTTP_REQUEST:
                // To be implemented
                break;
            case CONSOLE:
                inputCollector = new ConsoleInputCollector();
                break;

            default:
                throw new InputCollectorException("Unknown Input Method");
        }

        return inputCollector;
    }

}
