package hw5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class for simulation that creates elevator and state objects, takes user input,
 * and then runs the simulation, providing its results as output
 * 
 * @author Jayden Palacios (ubc007) | CS-4773 Fall '23
 */
public class ElevatorSimulation {

    public static void main(String [] args) {
        Elevator elevator = new Elevator();
        //output builder
        StringBuilder output = new StringBuilder();

        String fileName = args[0];
        String line;
        BufferedReader reader = openReader(fileName);

        if(reader == null) {
            System.out.println(String.format("File '%s' not found", fileName));
            return;
        }

        while ((line = readLine(reader)) != null) {
            // Split the line by spaces and process each integer
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                int button = Integer.parseInt(token);

                output.append(elevator.handleButtonPress(button));
            }
        }
        System.out.println(output.toString());
    }

    public static BufferedReader openReader(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            return br;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readLine(BufferedReader reader) {
        try {
            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}