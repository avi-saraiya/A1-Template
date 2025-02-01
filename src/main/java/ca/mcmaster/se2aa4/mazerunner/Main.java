// This program has been extended by Avi Saraiya, 24-01-25
package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        if (args.length > 1 && args.length < 5 && "-i".equals(args[0])) { // Checks for the -i flag
            String mazeFilePath = args[1];
            MazeLoader mazeLoader = new MazeLoader(mazeFilePath);
            try {
                logger.info("**** Reading the maze from file " + mazeFilePath);
                Maze maze = mazeLoader.loadMaze();
                maze.displayMaze();
                SolutionFinder solutionFinder = new SolutionFinder(maze);
                List<String> path = solutionFinder.findPath(); // placeholder for the solution through the maze
                logger.info("**** Path found: " + path);
                if (args.length >= 3 && "-p".equals(args[2])) { // Checks for the -p flag
                    String userPath = args[3];
                    SolutionValidator SolutionValidator = new SolutionValidator(maze);
                    boolean isValid = SolutionValidator.validatePath(userPath); // Placeholder for actual validation logic
                    if (isValid) {
                        logger.info("User-provided path is valid.");
                    } else {
                        logger.info("User-provided path is invalid.");
                    }
                }
            } catch (Exception e) {
                logger.error("/!\\ An error has occurred while loading the maze /!\\", e);
            }
        } else {
            logger.error("Invalid arguments. Usage: -i <mazeFilePath> [-p <userPath>]");
        }

        logger.info("** End of MazeRunner");
    }
}








