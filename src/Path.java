import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {

    private final List<Cell> cells;

    public Path(){
        this .cells = new ArrayList<>();
    }

    public int length() {
        return cells.size();
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    public void addStep(Cell cell) {
        cells.add(cell);
    }

    public void addSteps(List<Cell> steps) {
        cells.addAll(steps);
    }



}
