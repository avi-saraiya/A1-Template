package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;

//Ideally, I would have preferred to implement this algorithm in the SolutionValidator class as well, but I could not figure it out

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

    @Override
    public List<String> findPath(MazeInterface maze) {
        List<String> path = new ArrayList<>();
        char[][] grid = maze.getGrid(); // Sees the Maze grid
        int rows = grid.length;
        int cols = grid[0].length;

        int[] start = findStart(grid);
        if (start == null) {
            System.out.println("No valid start position found.");
            return path;
        }

        int row = start[0], col = start[1];
        int dir = 0; // Faces directly right (user's perspective)

        //Keeps looping till the exit is found
        while (!isExit(row, col, grid, cols)) {
            int rightDir = (dir + 1) % 4;
            int nextRow = row + DIRECTIONS[rightDir][0];
            int nextCol = col + DIRECTIONS[rightDir][1];
            //Makes move as long as a wall is not run into
            if (isValidMove(nextRow, nextCol, grid, rows, cols)) {
                // Turn right and move
                dir = rightDir;
                row = nextRow;
                col = nextCol;
                path.add("R");
                path.add("F");
            } else {
                // Just going forward in the grid
                nextRow = row + DIRECTIONS[dir][0];
                nextCol = col + DIRECTIONS[dir][1];

                if (isValidMove(nextRow, nextCol, grid, rows, cols)) {
                    row = nextRow;
                    col = nextCol;
                    path.add("F");
                } else {
                    // turns left when stuck
                    dir = (dir + 3) % 4;
                    path.add("L");
                }
            }
        }

        return path;
    }


    // Checks for valid move
    private boolean isValidMove(int row, int col, char[][] grid, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == PATH;
    }


    // Checks for exit
    private boolean isExit(int row, int col, char[][] grid, int cols) {
        return col == cols - 1; // Exit is the only open space on the rightmost column
    }
    //Looks for start point
    private int[] findStart(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == PATH) {
                return new int[]{i, 0}; // First open space in the leftmost column
            }
        }
        return null;
    }
}
