package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

public class MultiplePathTest {
    @Test
    public void testPathFinderWithMultipleValidPaths() throws IOException {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        List<String> path = pathFinder.findPath(maze);
        assertNotNull(path, "Path should not be null");
        assertTrue(path.size() > 0, "Path should have at least one step");
        assertTrue(path.contains("F"), "Path should contain forward moves");
    }
}
