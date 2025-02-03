package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze implements MazeInterface {
    private char[][] grid; //2d representation of the maze
    private List<String> rows = new ArrayList<>();

    // Not implemented in the final version
    @Override
    public void displayMaze() {
        for (String row : rows) {
            System.out.println(row);
        }
    }

    @Override
    public List<String> getRows() {
        return this.rows;
    }

    @Override
    public char[][] getGrid() {
        return this.grid;
    }

    // Method to load maze from file
    public void loadMazeFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        List<String> rowList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            rowList.add(line);
        }
        reader.close();
        this.rows = rowList;
        this.grid = new char[rowList.size()][rowList.get(0).length()];// Converts rows to the grid
        for (int i = 0; i < rowList.size(); i++) { // To initialize the grid with maze data
            this.grid[i] = rowList.get(i).toCharArray();
        }
    }
}