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

// The following class is used to load the maze from the path specified by the user
class MazeLoader {

    private String filePath;

    public MazeLoader(String filePath) {
        this.filePath = filePath;
    }

    public Maze loadMaze() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Maze maze = new Maze();
        String line;
        while ((line = reader.readLine()) != null) {
            maze.addRow(line);
        }
        reader.close();
        return maze;
    }
}

// The following class represents the maze in terms of 'WALL' and 'PATH'
class Maze {

    private StringBuilder readableMaze;
    private List<String> rows;

    public Maze() {
        this.readableMaze = new StringBuilder();
        this.rows = new ArrayList<>();
    }

    public void addRow(String row) {
        rows.add(row);  // Stores the row for pathfinding later
        for (int idx = 0; idx < row.length(); idx++) {
            if (row.charAt(idx) == '#') {
                readableMaze.append("WALL ");
            } else if (row.charAt(idx) == ' ') {
                readableMaze.append("PASS ");
            }
        }
        readableMaze.append(System.lineSeparator());// Adds a newline to format the readable maze properly
    }

    public void displayMaze() { // Prints out the readable version of the maze
        System.out.print(readableMaze.toString());
    }

    public List<String> getRows() {
        return rows;
    }
}

// The following class will implement a pathfinding algorithm, and add the solution to a list and return it
class SolutionFinder {

    private Maze maze;

    public SolutionFinder(Maze maze) {
        this.maze = maze;
    }

    public List<String> findPath() {
        // The additions to the list below are just placeholder examples for the MVP
        List<String> path = new ArrayList<>();
        path.add("L");
        path.add("R");
        path.add("F");
        return path;
    }
}

// The following class is a placeholder for validating the user-provided path
class SolutionValidator {

    private Maze maze;

    public SolutionValidator(Maze maze) {
        this.maze = maze;
    }

    public boolean validatePath(String userPath) {
        // Placeholder logic for validating the path
        return userPath != null && !userPath.isEmpty();
    }
}
