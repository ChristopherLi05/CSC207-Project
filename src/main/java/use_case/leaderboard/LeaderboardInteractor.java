package use_case.leaderboard;

import data_access.IDataAccessor;
import entity.leaderboard.LeaderboardEntry;

import java.util.List;

public class LeaderboardInteractor implements LeaderboardInputBoundary {
    private final LeaderboardOutputBoundary leaderboardPresenter;
    private final IDataAccessor dataAccessor;

    public LeaderboardInteractor(LeaderboardOutputBoundary leaderboardOutputBoundary, IDataAccessor dataAccessor) {
        this.leaderboardPresenter = leaderboardOutputBoundary;
        this.dataAccessor = dataAccessor;
    }

    @Override
    public void execute() {
        List<LeaderboardEntry> entries = dataAccessor.getTopTenLeaderboard();
        leaderboardPresenter.prepareSuccessView(new LeaderboardOutputData(entries, false));
    }
}
