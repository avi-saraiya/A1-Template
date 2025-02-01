package ca.mcmaster.se2aa4.mazerunner;

class MazeDisplayer {
    public static String format(Maze maze) {
        StringBuilder readableMaze = new StringBuilder();
        for (String row : maze.getRows()) {
            for (char c : row.toCharArray()) {
                if c == '#'{
                    readableMaze.append("WALL ");
                }
                else if c == " "{
                    readableMaze.append("PASS ");
                }
            }
            readableMaze.append(System.lineSeparator());
        }
        return readableMaze.toString();
    }
}
