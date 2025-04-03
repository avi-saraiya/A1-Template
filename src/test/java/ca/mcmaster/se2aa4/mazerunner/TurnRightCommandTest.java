package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TurnRightCommandTest {

    @Test
    public void testTurnRightExecution() {
        PathFinder pathFinder = mock(PathFinder.class);
        TurnRightCommand turnRightCommand = new TurnRightCommand(pathFinder);

        turnRightCommand.execute();

        verify(pathFinder).turnRight();
    }
}