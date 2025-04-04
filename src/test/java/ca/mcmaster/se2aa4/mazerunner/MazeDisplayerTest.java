package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class MazeDisplayerTest {
    @Test
    public void testMazeDisplayerWithValidMaze() throws IOException {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        String formattedMaze = MazeDisplayer.format(maze);
        assertNotNull(formattedMaze, "Formatted maze should not be null");
        assertTrue(formattedMaze.contains("WALL"), "Formatted maze should contain WALL");
        assertTrue(formattedMaze.contains("PASS"), "Formatted maze should contain PASS");
    }
}