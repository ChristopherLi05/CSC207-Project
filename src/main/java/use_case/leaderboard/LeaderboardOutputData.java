package use_case.leaderboard;

import entity.leaderboard.LeaderboardEntry;

import java.util.List;

public record LeaderboardOutputData(List<LeaderboardEntry> leaderboardEntries, boolean useCaseFailed) {
}
