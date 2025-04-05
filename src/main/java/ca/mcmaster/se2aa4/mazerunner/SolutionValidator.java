package ca.mcmaster.se2aa4.mazerunner;

// This class is a placeholder for validating the entered path
public class SolutionValidator {
    private Maze maze;
    // This is from the viewer's refernce not the explorar's
    private static final int[][] DIRECTIONS = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public SolutionValidator(Maze maze) {
        this.maze = maze;
    }

    public boolean validatePath(String path) {
        char[][] grid = maze.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;

        //To find the starting position (first space in the leftmost column (like non wall))
        int row = -1, col = -1;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == ' ') {
                row = i;
                col = 0;
                break;
            }
        }

        if (row == -1 || col == -1) {
            return false; // For potential future iterations that have to deal with mazes without entry points
        }

        int dir = 0; // Facing right at the begininng

        for (int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);

            switch (move) {
                case 'F':
                    // for going forward
                    row += DIRECTIONS[dir][0];
                    col += DIRECTIONS[dir][1];

                    // Checks for bounds
                    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '#') {
                        return false; // Invalid cause should not be able to go through a wall
                    }
                    break;
                case 'L':
                    // to turn left
                    dir = (dir + 3) % 4; // For turning 90 deg (anticlockwise)
                    break;
                case 'R':
                    // Turn right (clockwise)
                    dir = (dir + 1) % 4; // for turning 90 deg (clockwise)
                    break;
                default:
                    return false; // No movement
            }
        }

        // Checks for exit
        return col == cols - 1 && grid[row][col] == ' ';
    }
}

