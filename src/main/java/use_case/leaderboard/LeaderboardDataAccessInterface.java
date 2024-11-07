package use_case.leaderboard;

import java.util.List;

public interface LeaderboardDataAccessInterface {
    List<LeaderboardEntry> getTopTenLeaderboard();

    void updateScore(String name, int score);
}
