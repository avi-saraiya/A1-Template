package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCommand implements Command {
    boolean executed = false;

    @Override
    public void execute() {
        executed = true;
    }
}

public class CallerTest {

    @Test
    public void testCaller() {
        TestCommand testCommand = new TestCommand();
        Caller caller = new Caller();
        caller.setCommand(testCommand);
        caller.call();
        assertTrue(testCommand.executed, "Command should be called when call() is called");
    }
}