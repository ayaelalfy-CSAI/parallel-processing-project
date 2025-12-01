import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int rows;
    private final int cols;
    private final int [][]cells;

    public Grid(int[][] cells) {
        this.cells = cells;
        this.rows=cells.length;
        this.cols=cells[0].length;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public boolean inBounds(int row, int column){
        return row>=0 && row<rows && column>=0 && column<cols;
    }

    public boolean isWalkable(int row, int column){
        return inBounds(row,column) && cells[row][column] == 0;
    }

    public List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();

        int r = cell.getRow();
        int c = cell.getColumn();

        if (isWalkable(r - 1, c))
            neighbors.add(new Cell(r - 1, c));

        if (isWalkable(r + 1, c))
            neighbors.add(new Cell(r + 1, c));

        if (isWalkable(r, c - 1))
            neighbors.add(new Cell(r, c - 1));

        if (isWalkable(r, c + 1))
            neighbors.add(new Cell(r, c + 1));

        return neighbors;
    }

    public void printGrid() {
        for (int[] row : cells) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


}
