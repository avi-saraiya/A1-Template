package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MazeSingletonTest {
    
    @Test
    public void testSingletonMazeInstance() throws Exception {
        Maze maze1 = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        Maze maze2 = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        assertSame(maze1, maze2, "Maze instances should be the same.");
    }
}