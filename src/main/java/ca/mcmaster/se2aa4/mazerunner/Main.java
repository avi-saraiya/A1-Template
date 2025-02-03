// This program has been extended by Avi Saraiya, 24-01-25

package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1 && "-i".equals(args[0])) { // Checks for -i flag 
            String mazeFilePath = args[1]; // uploads file from specified path
            MazeLoader mazeLoader = new MazeLoader(mazeFilePath);
            try {
                Maze maze = mazeLoader.loadMaze();  // Loads the maze
                PathInterface pathFinder = new PathFinder(); // Implements the path finding algorithrm
                SolutionFinder solutionFinder = new SolutionFinder(maze, pathFinder); // The SolutionFinder helps integrate the path finding algorithm with the maze
                List<String> path = solutionFinder.findPath(); // List containint the directions to the end point
                OutputFormatter outputFormatter = new OutputFormatter(); // Prints the canonical and factorized solutions
                StringBuilder output = outputFormatter.solFormat(path);
                StringBuilder factorizedOutput = outputFormatter.factorize(output);
                if (args.length > 3 && "-p".equals(args[2])) { // Looks for the -p flag
                String userPath = args[3];
                SolutionValidator validator = new SolutionValidator(maze); // Checks entered path against maze to validate path
                boolean isValid = validator.validatePath(userPath); 
                if (isValid) {
                    System.out.println("Entered path was valid");
                } else {
                    System.out.println("Entered path was invalid");
                }
                }
            } catch (Exception e) {
                System.out.println("An error has occurred while processing the maze");
            }
        } else {
            System.out.println("Invalid arguments. Usage: -i <mazeFilePath> [-p <userPath>]");
        }
    }
}


