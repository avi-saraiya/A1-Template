package ca.mcmaster.se2aa4.mazerunner;

public class MoveForwardCommand implements Command {
    private PathFinder pathFinder;

    public MoveForwardCommand(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @Override
    public void execute() {
        pathFinder.moveForward();
    }
}
