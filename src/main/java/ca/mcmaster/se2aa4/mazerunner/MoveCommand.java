package ca.mcmaster.se2aa4.mazerunner;

public class MoveCommand implements Command {
    // Basic for now, to pass test
    @Override
    public void execute() {
        System.out.println("Move command executed.");
    }
}
