package data_access;

import use_case.leaderboard.LeaderboardEntry;

import java.util.ArrayList;
import java.util.List;

public class DummyDataAccessor implements IDataAccessor {
    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        return new ArrayList<>();
    }

    @Override
    public void updateScore(String name, int score) {
    }
}
