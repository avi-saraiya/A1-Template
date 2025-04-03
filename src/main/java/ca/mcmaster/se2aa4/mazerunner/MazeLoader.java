package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

class MazeLoader {
    private String filePath;

    public MazeLoader(String filePath) {
        this.filePath = filePath;
    }
    // Method for loadin in the maze
    public Maze loadMaze() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Maze maze = Maze.getInstance(filePath);
        // Loads the maze using the new method that loads the grid and rows
        maze.loadMazeFromFile(filePath);
        return maze;
    }
}

