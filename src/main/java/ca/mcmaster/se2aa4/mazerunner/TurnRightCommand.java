package ca.mcmaster.se2aa4.mazerunner;

public class TurnRightCommand implements Command {
    private PathFinder pathFinder;

    public TurnRightCommand(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @Override
    public void execute() {
        pathFinder.turnRight();
    }
}