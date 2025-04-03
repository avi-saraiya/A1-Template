package ca.mcmaster.se2aa4.mazerunner;

public class MoveCommand implements Command {
    private PathFinder pathFinder;

    public MoveCommand(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @Override
    public void execute() {
        pathFinder.moveForward();
    }
}