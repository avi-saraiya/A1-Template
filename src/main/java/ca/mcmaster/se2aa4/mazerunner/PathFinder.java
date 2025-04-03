package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;

public class PathFinder implements PathInterface {
    private static final char WALL = '#';
    private static final char PATH = ' ';

    private static final int[][] DIRECTIONS = {
        {0, 1},  // Right
        {1, 0},  // Down
        {0, -1}, // Left
        {-1, 0}  // Up
    };

    private int row, col, dir; // Position and direction
    private char[][] grid;

    public PathFinder(MazeInterface maze) {
        this.grid = maze.getGrid();
        int[] start = findStart(grid);
        if (start != null) {
            this.row = start[0];
            this.col = start[1];
            this.dir = 0; // Facing right initially
        }
    }

    public void moveForward() {
        int nextRow = row + DIRECTIONS[dir][0];
        int nextCol = col + DIRECTIONS[dir][1];
        if (isValidMove(nextRow, nextCol)) {
            row = nextRow;
            col = nextCol;
        }
    }

    public void turnLeft() {
        dir = (dir + 3) % 4;
    }

    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    private boolean isValidMove(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == PATH;
    }

    private int[] findStart(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == PATH) {
                return new int[]{i, 0};
            }
        }
        return null;
    }

    @Override
    public List<String> findPath(MazeInterface maze) {
        return new ArrayList<>(); // Placeholder
    }
}