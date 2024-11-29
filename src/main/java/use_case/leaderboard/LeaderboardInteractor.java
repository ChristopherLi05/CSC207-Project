package use_case.leaderboard;

import data_access.IDataAccessor;
import entity.leaderboard.LeaderboardEntry;

import java.util.List;

/**
 * The {@code LeaderboardInteractor} class implements the {@link LeaderboardInputBoundary} interface
 * to handle the use case logic for interacting with the leaderboard. It retrieves the top leaderboard entries
 * from the data source and presents them to the user.
 */
public class LeaderboardInteractor implements LeaderboardInputBoundary {
    private final LeaderboardOutputBoundary leaderboardPresenter;
    private final IDataAccessor dataAccessor;

    /**
     * Constructs a new {@code LeaderboardInteractor} instance.
     *
     * @param leaderboardOutputBoundary the presenter to update the view with the leaderboard data
     * @param dataAccessor the data accessor used to fetch leaderboard entries from the data source
     */
    public LeaderboardInteractor(LeaderboardOutputBoundary leaderboardOutputBoundary, IDataAccessor dataAccessor) {
        this.leaderboardPresenter = leaderboardOutputBoundary;
        this.dataAccessor = dataAccessor;
    }

    /**
     * Executes the leaderboard use case. Retrieves the top leaderboard entries from the data source
     * and prepares the success view for presentation.
     */
    @Override
    public void execute() {
        // Retrieve the top ten leaderboard entries from the data source
        List<LeaderboardEntry> entries = dataAccessor.getTopTenLeaderboard();

        // Present the retrieved leaderboard entries via the presenter
        leaderboardPresenter.prepareSuccessView(new LeaderboardOutputData(entries, false));
    }
}
