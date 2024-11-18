package data_access;

import entity.leaderboard.LeaderboardEntry;

import java.util.List;

public class APIDataAccessor implements IDataAccessor {
    @Override
    public boolean signUp(String username, String password) {
        return false;
    }

    @Override
    public String logIn(String username, String password) {
        return "";
    }

    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        return List.of();
    }

    @Override
    public void updateScore(String name, int score) {

    }
}
