package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MazeLoadingTest {

    @Test
    public void testMazeLoading() throws Exception {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        assertNotNull(maze.getGrid(), "Maze grid should not be null after loading.");
        assertNotNull(maze.getRows(), "Maze rows should not be null after loading.");
    }
}