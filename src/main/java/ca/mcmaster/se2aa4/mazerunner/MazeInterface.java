package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public interface MazeInterface {
    void displayMaze();
    List<String> getRows();
    char[][] getGrid(); // Method to get the grid (2D array)
}
