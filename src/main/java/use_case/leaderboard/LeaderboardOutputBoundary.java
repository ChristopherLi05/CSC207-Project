package use_case.leaderboard;

/**
 * The {@code LeaderboardOutputBoundary} interface defines the contract for presenting the leaderboard results
 * to the view. It is used by the interactor to communicate the outcome of the leaderboard use case.
 */
public interface LeaderboardOutputBoundary {

    /**
     * Prepares the success view with the leaderboard data to be presented to the user.
     *
     * @param outputData the data containing the leaderboard entries to display
     */
    void prepareSuccessView(LeaderboardOutputData outputData);

    /**
     * Prepares the failure view with an error message to be presented to the user in case of failure.
     *
     * @param errorMessage the error message to display
     */
    void prepareFailView(String errorMessage);
}
