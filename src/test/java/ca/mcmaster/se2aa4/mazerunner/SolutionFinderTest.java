package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SolutionFinderTest {
    @Test
    public void testSolutionFinderWithPathStrategy() throws Exception {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        SolutionFinder solutionFinder = new SolutionFinder(maze, pathFinder);
        List<String> path = solutionFinder.findPath();
        assertNotNull(path, "Path should not be null.");
        assertFalse(path.isEmpty(), "Path should not be empty.");
    }
}