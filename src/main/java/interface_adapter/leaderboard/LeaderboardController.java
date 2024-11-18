package interface_adapter.leaderboard;

import use_case.leaderboard.LeaderboardInputBoundary;

public class LeaderboardController {
    private final LeaderboardInputBoundary leaderboardInteractor;
    private final LeaderboardViewState viewState;

    private Thread updateThread = null;

    public LeaderboardController(LeaderboardInputBoundary leaderboardInteractor, LeaderboardViewState viewState) {
        this.leaderboardInteractor = leaderboardInteractor;
        this.viewState = viewState;
    }

    public void execute() {
        if (updateThread != null) return;

        viewState.setState(new LeaderboardState());
        viewState.firePropertyChanged();

        updateThread = new Thread(() -> {
            leaderboardInteractor.execute();
            updateThread = null;
        });

        updateThread.start();
    }
}
