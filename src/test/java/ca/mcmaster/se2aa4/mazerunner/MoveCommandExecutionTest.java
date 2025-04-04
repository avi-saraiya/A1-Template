package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MoveCommandExecutionTest {
    @Test
    public void testMoveCommandExecution() throws Exception {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        MoveCommand moveCommand = new MoveCommand(pathFinder);
        moveCommand.execute();
    }
}