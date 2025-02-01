package ca.mcmaster.se2aa4.mazerunner;

// The following class is a placeholder for validating the user-provided path
class SolutionValidator {

    private Maze maze;

    public SolutionValidator(Maze maze) {
        this.maze = maze;
    }

    public boolean validatePath(String userPath) {
        // Placeholder logic for validating the path
        return userPath != null && !userPath.isEmpty();
    }
}