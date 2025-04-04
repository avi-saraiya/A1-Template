package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PathFinderStrategyTest {
    
    @Test
    public void testPathFinderWithStrategy() throws Exception {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        List<String> path = pathFinder.findPath(maze);
        assertNotNull(path, "Path should not be null.");
        assertFalse(path.isEmpty(), "Path should not be empty.");
    }
}