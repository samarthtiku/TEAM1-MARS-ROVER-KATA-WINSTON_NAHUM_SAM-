package com.marsrover.application;

import com.marsrover.model.Plateau;
import com.marsrover.service.ConsoleInputHandler;
import com.marsrover.service.InputHandler;
import com.marsrover.service.RoverFactory;
import com.marsrover.service.RoverFactoryImpl;
import java.io.IOException;
import java.util.Scanner;

public class MarsRoverApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;

        // Prompt for grid size input
        System.out.println("Enter plateau size (width height):");
        width = scanner.nextInt();
        height = scanner.nextInt();

        // Instantiate the dependencies
        Plateau plateau = new Plateau(width, height);
        RoverFactory roverFactory = new RoverFactoryImpl();
        InputHandler inputHandler = new ConsoleInputHandler();

        MarsRoverProgram program = new MarsRoverProgram(plateau, roverFactory, inputHandler);

        try {
            program.run();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
