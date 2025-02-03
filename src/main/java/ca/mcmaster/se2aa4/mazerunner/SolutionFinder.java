package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;
// The class will implement the pathfinding algorithm

public class SolutionFinder {
    private MazeInterface maze;
    private PathInterface pathInterface;

    public SolutionFinder(MazeInterface maze, PathInterface pathInterface) {
        this.maze = maze;
        this.pathInterface = pathInterface;
    }

    public List<String> findPath() {
        if (pathInterface == null) {
            System.out.println("No pathfinding strategy implemented yet.");
            return new ArrayList<>();
        }
        return pathInterface.findPath(maze);  // Calls the method from the pathfinding strategy
    }
}
