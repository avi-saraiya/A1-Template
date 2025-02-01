// This program has been extended by Avi Saraiya, 24-01-25

package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        if (args.length >= 2 && "-i".equals(args[0])) {
            String mazeFilePath = args[1];
            boolean validatePath = args.length == 4 && "-p".equals(args[2]);
            MazeLoader mazeLoader = new MazeLoader(mazeFilePath);
            try {
                logger.info("**** Reading the maze from file " + mazeFilePath);
                Maze maze = mazeLoader.loadMaze();
                System.out.print(MazeDisplayer.format(maze));  // This is to print the maze in the "WALL" "PASS" form

                // This is where the pathfinding strategy will go
                SolutionFinder solutionFinder = new SolutionFinder(maze, null); //Null because no strategy selecte yet
                List<String> path = solutionFinder.findPath();
                logger.info("**** Path found: " + path);

                if (validatePath) {
                    String userPath = args[3];
                    SolutionValidator solutionValidator = new SolutionValidator(maze);
                    boolean isValid = solutionValidator.validatePath(userPath);
                    if (isValid){
                        logger.info("Provided path is valid");
                    }
                    else{
                        logger.info("Provided path is invalid");
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




