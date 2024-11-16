package data_access;

import entity.user.UserCreationDataAccessor;
import use_case.leaderboard.LeaderboardDataAccessInterface;

public interface IDataAccessor extends LeaderboardDataAccessInterface, UserCreationDataAccessor {
}
