package use_case.leaderboard;

import entity.leaderboard.LeaderboardEntry;

import java.util.List;

/**
 * The {@code LeaderboardOutputData} class is a data transfer object (DTO) used to encapsulate the
 * leaderboard data that will be presented to the view.
 * It contains the list of leaderboard entries and a flag indicating whether the use case failed.
 */
public record LeaderboardOutputData(List<LeaderboardEntry> leaderboardEntries, boolean useCaseFailed) {
}
