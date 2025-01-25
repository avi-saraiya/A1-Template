package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        if (args.length == 2 && "-i".equals(args[0])) { // Checks for the -i flag
            String mazeFilePath = args[1];
            MazeLoader mazeLoader = new MazeLoader(mazeFilePath);

            try {
                logger.info("**** Reading the maze from file " + mazeFilePath);
                Maze maze = mazeLoader.loadMaze();
                maze.displayMaze();
            } catch (Exception e) {
                logger.error("/!\\ An error has occurred while loading the maze /!\\", e);
            }
        } else {
            logger.error("Invalid arguments. Usage: -i <mazeFilePath>");
        }

        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED"); // Placeholder for pathfinding logic (to implement in the 'final' sprint)
        logger.info("** End of MazeRunner");
    }
}

// The following class is used to load the maze from the path specified by the user
class MazeLoader {

    private final String filePath;

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

    private final StringBuilder readableMaze;

    public Maze() {
        this.readableMaze = new StringBuilder();
    }

    public void addRow(String row) {
        for (int idx = 0; idx < row.length(); idx++) {
            if (row.charAt(idx) == '#') {
                readableMaze.append("WALL ");
            } else if (row.charAt(idx) == ' ') {
                readableMaze.append("PASS ");
            }
        }
        readableMaze.append(System.lineSeparator()); // Adds a newline to format the readable maze properly
    }

    public void displayMaze() { // Prints out the readable version of the maze (in terms of wall and pass)
        System.out.print(readableMaze.toString());
    }
}
