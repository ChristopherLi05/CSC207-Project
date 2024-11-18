package interface_adapter.leaderboard;

import entity.leaderboard.LeaderboardEntry;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardState {
    private final List<LeaderboardEntry> leaderboardEntries;

    public LeaderboardState() {
        this(new ArrayList<>());
    }

    public LeaderboardState(List<LeaderboardEntry> leaderboardEntries) {
        this.leaderboardEntries = leaderboardEntries;
    }

    public List<LeaderboardEntry> getLeaderboardEntries() {
        return leaderboardEntries;
    }
}
