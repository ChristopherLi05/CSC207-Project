package use_case.leaderboard;

/**
 * The {@code LeaderboardInputBoundary} interface defines the method for interacting with the leaderboard use case.
 * It serves as an entry point for actions that trigger changes or updates to the leaderboard data.
 */
public interface LeaderboardInputBoundary {

    /**
     * Executes the leaderboard use case, typically used to fetch and update the leaderboard data.
     * This method could be responsible for loading the leaderboard, updating scores, or other related actions.
     */
    void execute();
}
