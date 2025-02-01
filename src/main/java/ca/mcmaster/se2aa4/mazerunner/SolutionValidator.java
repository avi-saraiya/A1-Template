package ca.mcmaster.se2aa4.mazerunner;

// This class is a placeholder for validating the entered path
class SolutionValidator {

    private Maze maze;

    public SolutionValidator(Maze maze) {
        this.maze = maze;
    }

    public boolean validatePath(String userPath) {
        // Validating path logic will be added over here
        return userPath != null && !userPath.isEmpty();
    }
}