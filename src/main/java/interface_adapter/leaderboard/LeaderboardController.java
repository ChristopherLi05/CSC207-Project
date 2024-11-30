package interface_adapter.leaderboard;

import use_case.leaderboard.LeaderboardInputBoundary;

/**
 * The LeaderboardController class handles interactions between the leaderboard
 * view state and the leaderboard use case interactor. It ensures that the leaderboard data
 * is retrieved and the view state is updated accordingly.
 */
public class LeaderboardController {
    private final LeaderboardExecutor leaderboardExecutor;
    private final LeaderboardInputBoundary leaderboardInteractor;

    /**
     * Constructs a LeaderboardController with the specified interactor and view state.
     *
     * @param leaderboardInteractor the interactor responsible for fetching and processing leaderboard data
     */
    public LeaderboardController(LeaderboardExecutor leaderboardExecutor, LeaderboardInputBoundary leaderboardInteractor) {
        this.leaderboardExecutor = leaderboardExecutor;
        this.leaderboardInteractor = leaderboardInteractor;
    }

    /**
     * Initiates the leaderboard update process.
     */
    public void execute() {
        leaderboardExecutor.execute(leaderboardInteractor);
    }
}
