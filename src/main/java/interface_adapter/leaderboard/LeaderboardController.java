package interface_adapter.leaderboard;

import use_case.leaderboard.LeaderboardInputBoundary;

/**
 * The {@code LeaderboardController} class handles interactions between the leaderboard
 * view state and the leaderboard use case interactor. It ensures that the leaderboard data
 * is retrieved and the view state is updated accordingly.
 */
public class LeaderboardController {
    private final LeaderboardInputBoundary leaderboardInteractor;
    private final LeaderboardViewState viewState;

    private Thread updateThread = null;

    /**
     * Constructs a {@code LeaderboardController} with the specified interactor and view state.
     *
     * @param leaderboardInteractor the interactor responsible for fetching and processing leaderboard data
     * @param viewState             the view state to update and manage
     */
    public LeaderboardController(LeaderboardInputBoundary leaderboardInteractor, LeaderboardViewState viewState) {
        this.leaderboardInteractor = leaderboardInteractor;
        this.viewState = viewState;
    }

    /**
     * Initiates the leaderboard update process if no update is currently running.
     *
     * <p>This method does the following:
     * <ul>
     *   <li>Resets the {@code LeaderboardState} in the {@code viewState}.</li>
     *   <li>Fires a property change notification to update the UI.</li>
     *   <li>Starts a background thread to fetch leaderboard data through the interactor.</li>
     * </ul>
     * If an update is already in progress, the method returns without doing anything.
     */
    public void execute() {
        if (updateThread != null) return;

        // Reset the view state and notify listeners
        viewState.setState(new LeaderboardState());
        viewState.firePropertyChanged();

        // Start a new thread to execute the leaderboard update
        updateThread = new Thread(() -> {
            leaderboardInteractor.execute();
            updateThread = null; // Reset the thread reference after completion
        });

        updateThread.start();
    }
}
