package ca.mcmaster.se2aa4.mazerunner;

public class TurnLeftCommand implements Command {
    private PathFinder pathFinder;

    public TurnLeftCommand(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @Override
    public void execute() {
        pathFinder.turnLeft();
    }
}