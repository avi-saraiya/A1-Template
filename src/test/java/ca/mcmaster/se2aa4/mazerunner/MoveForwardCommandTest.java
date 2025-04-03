package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MoveForwardCommandTest {

    @Test
    public void testMoveForwardExecution() {
        PathFinder pathFinder = mock(PathFinder.class);
        MoveForwardCommand moveCommand = new MoveForwardCommand(pathFinder);

        moveCommand.execute();

        verify(pathFinder).moveForward();
    }
}