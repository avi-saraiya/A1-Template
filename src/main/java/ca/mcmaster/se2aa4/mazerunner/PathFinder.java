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

    private static final String[] MOVES = {"R", "F", "L"}; // Right turn, Forward, Left turn

    private int row, col, dir;
    private char[][] grid;
    private int rows, cols;

    public PathFinder(MazeInterface maze) {
        this.grid = maze.getGrid();
        this.rows = grid.length;
        this.cols = grid[0].length;
        int[] start = findStart(grid);
        if (start != null) {
            this.row = start[0];
            this.col = start[1];
            this.dir = 0; // Start facing right
        }
    }

    @Override
    public List<String> findPath(MazeInterface maze) {
        List<String> path = new ArrayList<>();
        while (!isExit(row, col)) {
            int rightDir = (dir + 1) % 4;
            int nextRow = row + DIRECTIONS[rightDir][0];
            int nextCol = col + DIRECTIONS[rightDir][1];
            if (isValidMove(nextRow, nextCol)) {
                turnRight();
                moveForward();
                path.add("R");
                path.add("F");
            } else {
                nextRow = row + DIRECTIONS[dir][0];
                nextCol = col + DIRECTIONS[dir][1];
                if (isValidMove(nextRow, nextCol)) {
                    moveForward();
                    path.add("F");
                } else {
                    turnLeft();
                    path.add("L");
                }
            }
        }
        return path;
    }

    public void moveForward() {
        int nextRow = row + DIRECTIONS[dir][0];
        int nextCol = col + DIRECTIONS[dir][1];
        if (isValidMove(nextRow, nextCol)) {
            row = nextRow;
            col = nextCol;
        } else {
            System.out.println("Invalid move! Hit a wall or out of bounds.");
        }
    }

    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    public void turnLeft() {
        dir = (dir + 3) % 4;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == PATH;
    }

    private boolean isExit(int row, int col) {
        return col == cols - 1;
    }

    private int[] findStart(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == PATH) {
                return new int[]{i, 0};
            }
        }
        return null;
    }
}