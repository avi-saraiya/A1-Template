package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    public void testCommandInterface() { // stub for now
        Command moveCommand = new MoveCommand();
        assertNotNull(moveCommand);
        moveCommand.execute();
    }
}
