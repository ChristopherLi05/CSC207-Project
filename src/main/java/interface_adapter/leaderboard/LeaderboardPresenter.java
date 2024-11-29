package interface_adapter.leaderboard;

import use_case.leaderboard.LeaderboardOutputBoundary;
import use_case.leaderboard.LeaderboardOutputData;

/**
 * The {@code LeaderboardPresenter} class manages the presentation layer for the leaderboard use case.
 * It updates the {@code LeaderboardViewState} based on the output data from the interactor.
 */
public class LeaderboardPresenter implements LeaderboardOutputBoundary {
    private final LeaderboardViewState leaderboardViewState;

    /**
     * Constructs a new {@code LeaderboardPresenter} with the specified view state.
     *
     * @param leaderboardViewState the view state to manage the leaderboard's UI state
     */
    public LeaderboardPresenter(LeaderboardViewState leaderboardViewState) {
        this.leaderboardViewState = leaderboardViewState;
    }

    /**
     * Updates the view state with leaderboard data on successful execution.
     *
     * <p>This method sets a new {@code LeaderboardState} in the {@code leaderboardViewState}
     * using the leaderboard entries provided in the output data. It then triggers
     * a property change notification to update the UI.</p>
     *
     * @param outputData the data containing leaderboard entries
     */
    @Override
    public void prepareSuccessView(LeaderboardOutputData outputData) {
        leaderboardViewState.setState(new LeaderboardState(outputData.leaderboardEntries()));
        leaderboardViewState.firePropertyChanged();
    }

    /**
     * Handles any failure in the leaderboard use case.
     *
     * <p>Currently, this use case is designed not to fail, but this method exists
     * for potential future enhancements.</p>
     *
     * @param errorMessage the error message explaining the failure (unused in the current implementation)
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // Note: This use case currently cannot fail.
    }
}
