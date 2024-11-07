package data_access;

import use_case.leaderboard.LeaderboardDataAccessInterface;
import use_case.leaderboard.LeaderboardEntry;

import java.util.List;

public class DummyDataAccessor implements LeaderboardDataAccessInterface {
    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        return null;
    }

    @Override
    public void updateScore(String name, int score) {

    }
}
