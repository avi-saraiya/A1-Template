package ca.mcmaster.se2aa4.mazerunner;

// This class is a placeholder for validating the entered path
public class SolutionValidator {
    private Maze maze;
    private static final int[][] DIRECTIONS = {
        {0, 1},  // Right
        {1, 0},  // Down
        {0, -1}, // Left
        {-1, 0}  // Up
    };

    public SolutionValidator(Maze maze) {
        this.maze = maze;
    }

    public boolean validatePath(String path) {
        char[][] grid = maze.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;

        // Find the starting position (first open space in the leftmost column)
        int row = -1, col = -1;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == ' ') {
                row = i;
                col = 0;
                break;
            }
        }

        if (row == -1 || col == -1) {
            return false; // No valid start found
        }

        int dir = 0; // Start facing right

        for (int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);

            switch (move) {
                case 'F':
                    // Move forward in the current direction
                    row += DIRECTIONS[dir][0];
                    col += DIRECTIONS[dir][1];

                    // Check if the new position is within bounds and not a wall
                    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '#') {
                        return false; // Invalid move
                    }
                    break;
                case 'L':
                    // Turn left (counter-clockwise)
                    dir = (dir + 3) % 4; // 90 degrees counter-clockwise
                    break;
                case 'R':
                    // Turn right (clockwise)
                    dir = (dir + 1) % 4; // 90 degrees clockwise
                    break;
                default:
                    return false; // Invalid move
            }
        }

        // Check if the end point is on the rightmost column (exit point)
        return col == cols - 1 && grid[row][col] == ' ';
    }
}

