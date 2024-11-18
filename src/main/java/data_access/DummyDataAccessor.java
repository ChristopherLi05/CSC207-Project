package data_access;

import use_case.leaderboard.LeaderboardEntry;

import java.util.List;

public class DummyDataAccessor implements IDataAccessor {
    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        return List.of(new LeaderboardEntry("Bob", 10),
                new LeaderboardEntry("Alice", 9),
                new LeaderboardEntry("Joe", 8),
                new LeaderboardEntry("Man", 7),
                new LeaderboardEntry("Ichime", 6),
                new LeaderboardEntry("[BLANK]", 5),
                new LeaderboardEntry("Aaaaaaaa", 4),
                new LeaderboardEntry("Fuma", 3),
                new LeaderboardEntry("thisisatestaccount", 2),
                new LeaderboardEntry("David", 1)
        );
    }

    @Override
    public void updateScore(String sessionId, int score) {
    }

    @Override
    public int getBestScore(String sessionId) {
        return 0;
    }

    @Override
    public boolean signUp(String username, String password) {
        return true;
    }

    @Override
    public String logIn(String username, String password) {
        return username;
    }
}
