package data_access;

import entity.leaderboard.LeaderboardEntry;

import java.util.List;

/**
 * The DAO that does nothing except provide dummy data
 */
public class DummyDataAccessor implements DataAccessor {
    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateScore(String sessionId, int score) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBestScore(String sessionId) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean signUp(String username, String password) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String logIn(String username, String password) {
        return username;
    }
}
