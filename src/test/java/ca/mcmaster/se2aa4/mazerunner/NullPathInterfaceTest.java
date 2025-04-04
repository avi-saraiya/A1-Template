package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class NullPathInterfaceTest {
    @Test
    public void testPathInterfaceWithNullStrategy() {
        Maze maze = null;
        SolutionFinder solutionFinder = new SolutionFinder(maze, null);
        List<String> path = solutionFinder.findPath();
        assertTrue(path.isEmpty(), "Path should be empty when no strategy is provided.");
    }
}