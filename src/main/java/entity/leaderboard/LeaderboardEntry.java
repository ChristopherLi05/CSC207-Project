package entity.leaderboard;

/**
 * Generic class used to store a leaderboard entry
 *
 * @param username .
 * @param score    .
 */
public record LeaderboardEntry(String username, int score) {
}
