package use_case.leaderboard;

import data_access.IDataAccessor;
import entity.leaderboard.LeaderboardEntry;
import interface_adapter.leaderboard.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LeaderboardUseCaseTest {
    @Test
    void testEndToEnd() {
        LeaderboardViewState viewState = new LeaderboardViewState("", new LeaderboardState());

        LeaderboardOutputBoundary leaderboardOutputBoundary = new LeaderboardPresenter(viewState);
        IDataAccessor dataAccessor = new IDataAccessor() {
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
                return List.of(new LeaderboardEntry("hello", 4), new LeaderboardEntry("world", 2));
            }

            @Override
            public void updateScore(String sessionId, int score) {

            }

            @Override
            public int getBestScore(String sessionId) {
                return 0;
            }
        };


        LeaderboardInteractor leaderboardInteractor = new LeaderboardInteractor(leaderboardOutputBoundary, dataAccessor);
        LeaderboardController leaderboardController = new LeaderboardController(new LeaderboardExecutor(), leaderboardInteractor);

        leaderboardController.execute();

        // Delay a bit since this is multithreaded
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNotNull(viewState.getState().getLeaderboardEntries());
        Assertions.assertEquals(2, viewState.getState().getLeaderboardEntries().size());
        Assertions.assertEquals("hello", viewState.getState().getLeaderboardEntries().get(0).username());
        Assertions.assertEquals(4, viewState.getState().getLeaderboardEntries().get(0).score());
        Assertions.assertEquals("world", viewState.getState().getLeaderboardEntries().get(1).username());
        Assertions.assertEquals(2, viewState.getState().getLeaderboardEntries().get(1).score());
    }
}
