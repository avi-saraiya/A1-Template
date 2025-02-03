package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;
// The class integrates the Maze and PathFinder classes through their interfaces
public class SolutionFinder {
    private MazeInterface maze;
    private PathInterface pathInterface;

    public SolutionFinder(MazeInterface maze, PathInterface pathInterface) {
        this.maze = maze;
        this.pathInterface = pathInterface;
    }

    public List<String> findPath() {
        if (pathInterface == null) {
            System.out.println("No pathfinding strategy implemented yet."); // This is for a potential case where the PathFinding class does not have an algorithm in it for pathfinding (for further extension in a future iteration)
            return new ArrayList<>();
        }
        return pathInterface.findPath(maze);  // Calls the method from the pathfinding strategy
    }
}
