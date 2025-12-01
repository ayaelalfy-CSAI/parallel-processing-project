import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int rows = 50;
        int cols = 50;
        int[][] cells = new int[rows][cols];

        Random rand = new Random();

        for (int i = 0; i < 200; i++) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            cells[r][c] = 1; // blocked
        }
        Grid grid = new Grid(cells);

        System.out.println("===== Grid =====");
        grid.printGrid();
        System.out.println("================\n");

        int numberOfRequests = 10;
        PathfindingExperiment experiment = new PathfindingExperiment(grid, numberOfRequests);

        experiment.runExperiment();
    }
}