package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

// The following class represents the maze in terms of 'WALL' and 'PATH'
package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

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
