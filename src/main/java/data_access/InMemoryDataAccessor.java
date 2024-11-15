package data_access;

import use_case.leaderboard.LeaderboardEntry;

import java.util.*;

public class InMemoryDataAccessor implements IDataAccessor {
    private final List<LeaderboardEntry> leaderboard = new ArrayList<>();
    private final Map<String, String> users = new HashMap<>();

    @Override
    public boolean signUp(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        } else {
            users.put(username, password);
            return true;
        }
    }

    @Override
    public String logIn(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return username;
        } else {
            return null;
        }
    }

    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        return leaderboard;
    }

    @Override
    public void updateScore(String name, int score) {
        LeaderboardEntry entry = findScore(name);
        if (entry != null) {
            leaderboard.remove(entry);
        }

        leaderboard.add(new LeaderboardEntry(name, score));
        leaderboard.sort(Comparator.comparingInt(LeaderboardEntry::score));

        while (leaderboard.size() > 10) {
            leaderboard.remove(leaderboard.size() - 1);
        }
    }

    private LeaderboardEntry findScore(String name) {
        for (LeaderboardEntry entry : leaderboard) {
            if (entry.username().equals(name)) {
                return entry;
            }
        }

        return null;
    }
}
