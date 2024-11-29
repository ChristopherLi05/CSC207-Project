package use_case.leaderboard;

import entity.leaderboard.LeaderboardEntry;

import java.util.List;

/**
 * The {@code LeaderboardDataAccessInterface} interface defines the methods required for accessing and updating leaderboard data.
 * This interface should be implemented by classes responsible for interacting with the data source (e.g., a database or file system).
 */
public interface LeaderboardDataAccessInterface {

    /**
     * Retrieves the top ten entries on the leaderboard.
     *
     * @return a list of the top ten {@link LeaderboardEntry} objects, ordered by score.
     */
    List<LeaderboardEntry> getTopTenLeaderboard();

    /**
     * Updates the score for a given session in the leaderboard.
     *
     * @param sessionId the session identifier of the player whose score is to be updated
     * @param score the new score to be recorded
     */
    void updateScore(String sessionId, int score);

    /**
     * Retrieves the best score for a given session.
     *
     * @param sessionId the session identifier of the player whose best score is to be retrieved
     * @return the best score of the player identified by the given sessionId
     */
    int getBestScore(String sessionId);
}
