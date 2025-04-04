package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PathFinderPathValidityTest {
    @Test
    public void testPathFinderWithValidPath() throws IOException {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        List<String> path = pathFinder.findPath(maze);
        assertNotNull(path, "Path should not be null");
        assertTrue(path.size() > 0, "Path should have at least one step");
    }
}