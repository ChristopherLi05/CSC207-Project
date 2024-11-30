package interface_adapter.leaderboard;

import entity.leaderboard.LeaderboardEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code LeaderboardState} class represents the state of the leaderboard in the application.
 * It contains a list of leaderboard entries, which hold individual user or score details.
 */
public class LeaderboardState {
    private final List<LeaderboardEntry> leaderboardEntries;

    /**
     * Constructs a new {@code LeaderboardState} with an empty leaderboard.
     */
    public LeaderboardState() {
        this(new ArrayList<>());
    }

    /**
     * Constructs a new {@code LeaderboardState} with the specified list of leaderboard entries.
     *
     * @param leaderboardEntries the list of {@code LeaderboardEntry} objects to initialize the state
     */
    public LeaderboardState(List<LeaderboardEntry> leaderboardEntries) {
        this.leaderboardEntries = leaderboardEntries;
    }

    /**
     * Retrieves the list of leaderboard entries in the current state.
     *
     * @return the list of {@code LeaderboardEntry} objects
     */
    public List<LeaderboardEntry> getLeaderboardEntries() {
        return leaderboardEntries;
    }
}
