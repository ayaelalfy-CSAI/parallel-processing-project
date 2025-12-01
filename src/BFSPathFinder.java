import java.util.*;

public class BFSPathFinder implements PathFinder {

    @Override
    public Path findPath(PathRequest request) {

        Grid grid = request.getGrid();
        Cell start = request.getStart();
        Cell goal = request.getGoal();

        Queue<Cell> queue = new LinkedList<>();

        Set<Cell> visited = new HashSet<>();

        Map<Cell, Cell> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        boolean found = false;

        while (!queue.isEmpty()) {

            Cell current = queue.poll();

            if (current.equals(goal)) {
                found = true;
                break;
            }

            for (Cell neighbor : grid.getNeighbors(current)) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!found) {
            return null;
        }

        List<Cell> steps = new ArrayList<>();

        Cell current = goal;
        while (current != null) {
            steps.add(current);
            current = parent.get(current);
        }

        Collections.reverse(steps);

        Path path = new Path();
        path.addSteps(steps);

        return path;
    }

}

