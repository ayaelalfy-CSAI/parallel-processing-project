
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PathfindingExperiment {

    private final Grid grid;
    private final int numberOfRequests;

    public PathfindingExperiment(Grid grid, int numberOfRequests) {
        this.grid = grid;
        this.numberOfRequests = numberOfRequests;
    }

    // إنشاء Path Requests عشوائية
    private List<PathRequest> generateRequests() {
        List<PathRequest> requests = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < numberOfRequests; i++) {

            Cell start, goal;

            // start walkable
            do {
                int r = rand.nextInt(grid.getRows());
                int c = rand.nextInt(grid.getCols());
                start = new Cell(r, c);
            } while (!grid.isWalkable(start.getRow(), start.getColumn()));

            //goal walkable
            do {
                int r = rand.nextInt(grid.getRows());
                int c = rand.nextInt(grid.getCols());
                goal = new Cell(r, c);
            } while (!grid.isWalkable(goal.getRow(), goal.getColumn()));

            requests.add(new PathRequest(grid, start, goal));
        }

        return requests;
    }


    //  Sequential & Parallel
    public void runExperiment() {

        PathFinderInterface bfs = new BFSPathFinder();

        List<PathRequest> requests = generateRequests();

        System.out.println("===== Running Sequential BFS =====");
        long t1 = System.currentTimeMillis();
        List<Path> seqResults = runSequential(bfs, requests);
        long t2 = System.currentTimeMillis();
        long seqTime = t2 - t1;
        System.out.println("Sequential Time = " + seqTime + " ms\n");

        System.out.println("===== Running Parallel BFS =====");
        ParallelPathfindingEngine engine = new ParallelPathfindingEngine(
                Runtime.getRuntime().availableProcessors(),
                bfs
        );

        long t3 = System.currentTimeMillis();
        List<Path> parResults = engine.processRequests(requests);
        long t4 = System.currentTimeMillis();
        long parTime = t4 - t3;

        engine.shutdown();

        System.out.println("Parallel Time = " + parTime + " ms\n");

        System.out.println("===== Summary =====");
        System.out.println("Requests Count = " + numberOfRequests);
        System.out.println("Sequential Time = " + seqTime + " ms");
        System.out.println("Parallel Time = " + parTime + " ms");

        double speedup = (double) seqTime / parTime;
        System.out.println("Speedup = " + String.format("%.2f", speedup) + "x");
    }

    // Sequential BFS
    private List<Path> runSequential(PathFinderInterface pathFinder, List<PathRequest> requests) {
        List<Path> results = new ArrayList<>();
        for (PathRequest req : requests) {
            results.add(pathFinder.findPath(req));
        }
        return results;
    }

}

