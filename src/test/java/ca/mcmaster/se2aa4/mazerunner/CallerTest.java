package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CallerTest {
    @Test
    public void testCallerExecutesCommand() throws Exception {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        MoveCommand moveCommand = new MoveCommand(pathFinder);
        Caller caller = new Caller();
        caller.setCommand(moveCommand);
        caller.call();
    }

    @Test
    public void testCallerWithoutCommand() {
        Caller caller = new Caller();
        caller.call();
    }

    @Test
    public void testMultipleCommandsInCaller() throws Exception {
        Maze maze = Maze.getInstance("/root/A1-Template/examples/tiny.maz.txt");
        PathFinder pathFinder = new PathFinder(maze);
        MoveCommand moveCommand1 = new MoveCommand(pathFinder);
        MoveCommand moveCommand2 = new MoveCommand(pathFinder);
        Caller caller = new Caller();
        caller.setCommand(moveCommand1);
        caller.call();
        caller.setCommand(moveCommand2);
        caller.call();
    }
}