package data_access;

import entity.leaderboard.LeaderboardEntry;

import java.util.*;

/**
 * In-memory implementation of the DAO for storing data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryDataAccessor implements IDataAccessor {
    private final List<LeaderboardEntry> leaderboard = new ArrayList<>();
    private final Map<String, String> users = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean signUp(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        } else {
            users.put(username, password);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String logIn(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return username;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        return leaderboard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateScore(String sessionId, int score) {
        LeaderboardEntry entry = findScore(sessionId);
        if (entry != null) {
            leaderboard.remove(entry);
        }

        leaderboard.add(new LeaderboardEntry(sessionId, score));
        leaderboard.sort(Comparator.comparingInt(LeaderboardEntry::score));

        while (leaderboard.size() > 10) {
            leaderboard.remove(leaderboard.size() - 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBestScore(String sessionId) {
        LeaderboardEntry entry = findScore(sessionId);
        if (entry != null) {
            return entry.score();
        } else {
            return 0;
        }
    }

    /**
     * {@inheritDoc}
     */
    private LeaderboardEntry findScore(String name) {
        for (LeaderboardEntry entry : leaderboard) {
            if (entry.username().equals(name)) {
                return entry;
            }
        }

        return null;
    }
}
