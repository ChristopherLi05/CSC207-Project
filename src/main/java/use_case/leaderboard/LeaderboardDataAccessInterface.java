package use_case.leaderboard;

import java.util.List;

public interface LeaderboardDataAccessInterface {
    List<LeaderboardEntry> getTopTenLeaderboard();

    void updateScore(String sessionId, int score);

    int getBestScore(String sessionId);
}
