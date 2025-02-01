package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
// This class taked in the rows of the maze (either '#' or ' ')
public class Maze implements MazeInterface {
    private List<String> rows = new ArrayList<>();

    public void addRow(String row) {
        rows.add(row);
    }

    @Override
    public List<String> getRows() {
        return rows;
    }
}
