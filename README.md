# Parallel Pathfinding on Grid (Multiple Shortest Paths)

## Project Overview
This project implements shortest path search on a 2D grid with obstacles, and extends it to handle multiple path requests in parallel using Java concurrency tools.

The main goals are:
- Implement BFS (for unweighted grids) to find shortest paths.
- Handle multiple pathfinding requests sequentially and in parallel.
- Measure and compare performance of sequential vs parallel execution.

---

## Grid Representation
- **Grid**: 2D matrix of cells.
- **Cell**: Represents a position (row, column).
- **Walkable cells**: value `0`.
- **Blocked cells (obstacles)**: value `1`.

---

## Key Classes

- **Grid**: Holds the 2D map and provides methods to check walkability and get neighbors.
- **Cell**: Represents a position in the grid (`row`, `col`), overrides `equals()` and `hashCode()` for correct usage in BFS.
- **Path**: Stores the list of cells from start to goal.
- **PathRequest**: Encapsulates a grid, start cell, and goal cell.
- **PathFinder**: Interface defining `Path findPath(PathRequest request)`.
- **BFSPathFinder**: Implements BFS algorithm sequentially.
- **ParallelPathfindingEngine**: Uses `ExecutorService` to handle multiple `PathRequest` in parallel.
- **PathfindingExperiment**: Generates multiple path requests, executes them sequentially and in parallel, measures execution time, and prints a summary.

---

## How to Run

Run the Main class  (java Main)
