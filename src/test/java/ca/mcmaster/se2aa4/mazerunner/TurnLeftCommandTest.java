package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TurnLeftCommandTest {

    @Test
    public void testTurnLeftExecution() {
        PathFinder pathFinder = mock(PathFinder.class);
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(pathFinder);

        turnLeftCommand.execute();

        verify(pathFinder).turnLeft();
    }
}