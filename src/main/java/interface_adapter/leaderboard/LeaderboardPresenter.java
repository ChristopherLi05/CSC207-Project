package interface_adapter.leaderboard;

import use_case.leaderboard.LeaderboardOutputBoundary;
import use_case.leaderboard.LeaderboardOutputData;

public class LeaderboardPresenter implements LeaderboardOutputBoundary {
    private final LeaderboardViewState leaderboardViewState;

    public LeaderboardPresenter(LeaderboardViewState leaderboardViewState) {
        this.leaderboardViewState = leaderboardViewState;
    }

    @Override
    public void prepareSuccessView(LeaderboardOutputData outputData) {
        leaderboardViewState.setState(new LeaderboardState(outputData.leaderboardEntries()));
        leaderboardViewState.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // note: this use case currently can't fail
    }
}
