package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

// The following class represents the maze in terms of 'WALL' and 'PATH'
class Maze {

    private StringBuilder readableMaze;
    private List<String> rows;

    public Maze() {
        this.readableMaze = new StringBuilder();
        this.rows = new ArrayList<>();
    }

    public void addRow(String row) {
        rows.add(row);  // Stores the row for pathfinding later
        for (int idx = 0; idx < row.length(); idx++) {
            if (row.charAt(idx) == '#') {
                readableMaze.append("WALL ");
            } else if (row.charAt(idx) == ' ') {
                readableMaze.append("PASS ");
            }
        }
        readableMaze.append(System.lineSeparator());// Adds a newline to format the readable maze properly
    }

    public void displayMaze() { // Prints out the readable version of the maze
        System.out.print(readableMaze.toString());
    }

    public List<String> getRows() {
        return rows;
    }
}