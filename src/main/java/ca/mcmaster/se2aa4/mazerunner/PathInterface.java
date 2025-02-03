package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
//Interface for the PathFinder
public interface PathInterface {
    List<String> findPath(MazeInterface maze);
}