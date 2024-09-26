package com.marsrover.application;

import com.marsrover.model.Plateau;
import com.marsrover.service.ConsoleInputHandler;
import com.marsrover.service.InputHandler;
import com.marsrover.service.RoverFactory;
import com.marsrover.service.RoverFactoryImpl;
import java.io.IOException;

public class MarsRoverApplication {
    public static void main(String[] args) {
        // Manually instantiate the dependencies
        Plateau plateau = new Plateau(5, 5); // Example plateau size
        RoverFactory roverFactory = new RoverFactoryImpl();
        InputHandler inputHandler = new ConsoleInputHandler();

        // Manually pass the dependencies into MarsRoverProgram
        MarsRoverProgram program = new MarsRoverProgram(plateau, roverFactory, inputHandler);

        try {
            program.run();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
