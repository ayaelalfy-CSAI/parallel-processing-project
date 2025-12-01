import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelPathfindingEngine {

    private final ExecutorService executor;
    private final PathFinder pathFinder;

    public ParallelPathfindingEngine(int threadCount, PathFinder pathFinder) {
        this.executor = Executors.newFixedThreadPool(threadCount);
        this.pathFinder = pathFinder;
    }

    public List<Path> processRequests(List<PathRequest> requests) {

        List<Future<Path>> futures = new ArrayList<>();

        for (PathRequest req : requests) {
            Callable<Path> task = () -> pathFinder.findPath(req);
            futures.add(executor.submit(task));
        }

        List<Path> results = new ArrayList<>();
        for (Future<Path> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                results.add(null);
            }
        }

        return results;
    }

    public void shutdown() {
        executor.shutdown();
    }

}
