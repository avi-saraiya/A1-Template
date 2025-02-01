package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

// The following class is used to load the maze from the path specified by the user
class MazeLoader {

    private String filePath;

    public MazeLoader(String filePath) {
        this.filePath = filePath;
    }

    public Maze loadMaze() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Maze maze = new Maze();
        String line;
        while ((line = reader.readLine()) != null) {
            maze.addRow(line);
        }
        reader.close();
        return maze;
    }
}