package interface_adapter.leaderboard;

import use_case.leaderboard.LeaderboardInputBoundary;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Leaderboard Executor for multithreaded use
 */
public class LeaderboardExecutor {
    private final ExecutorService executorService;

    public LeaderboardExecutor() {
        this.executorService = Executors.newFixedThreadPool(1, Executors.defaultThreadFactory());
    }

    /**
     * Runs the inputted use case in a thread.
     *
     * @param useCase Use case to be run
     */
    public void execute(LeaderboardInputBoundary useCase) {
        executorService.submit(useCase::execute);
    }

    /**
     * Shuts down the executor service
     */
    public void shutdown() {
        executorService.shutdown();
    }
}
