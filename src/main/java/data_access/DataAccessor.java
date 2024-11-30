package data_access;

import entity.user.UserCreationDataAccessor;
import use_case.leaderboard.LeaderboardDataAccessInterface;

/**
 * Compilation of all the data accessors into 1 main interface
 */
public interface DataAccessor extends LeaderboardDataAccessInterface, UserCreationDataAccessor {
}
