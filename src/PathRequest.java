public class PathRequest {

    private final Grid grid;
    private final Cell start;
    private final Cell goal;

    public PathRequest(Grid grid, Cell start, Cell goal) {
        this.grid = grid;
        this.start = start;
        this.goal = goal;
    }

    public Grid getGrid() {
        return grid;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getGoal() {
        return goal;
    }

    @Override
    public String toString() {
        return "PathRequest{" +
                "start=" + start +
                ", goal=" + goal +
                '}';
    }

}
