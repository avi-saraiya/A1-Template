package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

// The class will implement the pathfinding algorithm

public class SolutionFinder {
    private MazeInterface maze;
    private PathInterface pathInterface;

    public SolutionFinder(MazeInterface maze, PathInterface pathInterface) { // This is so that the program can now accept anything that implements the interfaces (like an object of the maze class etc)
        this.maze = maze;
        this.pathInterface = pathInterface;
    }

    public List<String> findPath() {
        if (pathInterface != null) {
            return pathInterface.findPath(maze);
        } else {
            // Placeholder for later when the pathfinding implementation is added
            return "Add Pathfinding algorhithm";
        }
    }
}
