package use_case.leaderboard;

import entity.leaderboard.LeaderboardEntry;

import java.util.List;

public interface LeaderboardDataAccessInterface {
    List<LeaderboardEntry> getTopTenLeaderboard();

    void updateScore(String sessionId, int score);

    int getBestScore(String sessionId);
}
