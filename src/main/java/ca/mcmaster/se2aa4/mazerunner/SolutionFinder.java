package ca.mcmaster.se2aa4.mazerunner;

// The following class will implement a pathfinding algorithm, and add the solution to a list and return it
class SolutionFinder {

    private Maze maze;

    public SolutionFinder(Maze maze) {
        this.maze = maze;
    }

    public List<String> findPath() {
        // The additions to the list below are just placeholder examples for the MVP
        List<String> path = new ArrayList<>();
        path.add("L");
        path.add("R");
        path.add("F");
        return path;
    }
}