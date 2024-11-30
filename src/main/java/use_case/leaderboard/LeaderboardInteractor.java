package use_case.leaderboard;

import data_access.IDataAccessor;
import entity.leaderboard.LeaderboardEntry;

import java.util.List;

/**
 * The LeaderboardInteractor class implements the LeaderboardInputBoundary interface
 * to handle the use case logic for interacting with the leaderboard. It retrieves the top leaderboard entries
 * from the data source and presents them to the user.
 */
public class LeaderboardInteractor implements LeaderboardInputBoundary {
    private final LeaderboardOutputBoundary leaderboardPresenter;
    private final LeaderboardDataAccessInterface dataAccessor;

    /**
     * Constructs a new LeaderboardInteractor instance.
     *
     * @param leaderboardOutputBoundary the presenter to update the view with the leaderboard data
     * @param dataAccessor              the data accessor used to fetch leaderboard entries from the data source
     */
    public LeaderboardInteractor(LeaderboardOutputBoundary leaderboardOutputBoundary,
                                 LeaderboardDataAccessInterface dataAccessor) {
        this.leaderboardPresenter = leaderboardOutputBoundary;
        this.dataAccessor = dataAccessor;
    }

    /**
     * Executes the leaderboard use case. Retrieves the top leaderboard entries from the data source
     * and prepares the success view for presentation.
     */
    @Override
    public void execute() {
        List<LeaderboardEntry> entries = dataAccessor.getTopTenLeaderboard();
        leaderboardPresenter.prepareSuccessView(new LeaderboardOutputData(entries, false));
    }
}

