// This program has been extended by Avi Saraiya, 24-01-25

package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner **");

        if (args.length > 1 && "-i".equals(args[0])) { 
            String mazeFilePath = args[1];
            MazeLoader mazeLoader = new MazeLoader(mazeFilePath);

            try {
                logger.info("**** Reading the maze from file: " + mazeFilePath);
                MazeInterface maze = mazeLoader.loadMaze();
                maze.displayMaze();

                // Initialize pathfinding strategy
                PathInterface pathFinder = new PathFinder();
                SolutionFinder solutionFinder = new SolutionFinder(maze, pathFinder);

                logger.info("**** Finding path through the maze...");
                List<String> path = solutionFinder.findPath();
                logger.info("**** Path found: ");
                OutputFormatter outputFormatter = new OutputFormatter();
                StringBuilder output = outputFormatter.solFormat(path);
                System.out.println(output);

            } catch (Exception e) {
                logger.error("/!\\ An error has occurred while processing the maze /!\\", e);
            }
        } else {
            logger.error("Invalid arguments. Usage: -i <mazeFilePath>");
        }

        logger.info("** End of Maze Runner **");
    }
}




