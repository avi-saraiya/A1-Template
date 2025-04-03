package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CallerTest {

    @Test
    public void testCaller() {
        Command moveCommand = new MoveCommand();
        Caller caller = new Caller();
        caller.setCommand(moveCommand);
        caller.call(); //should print "Move command executed."
    }
}
