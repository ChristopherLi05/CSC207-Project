package use_case.puzzleRush;

import data_access.IDataAccessor;
import entity.calculator.HandState;
import entity.leaderboard.LeaderboardEntry;
import interface_adapter.leaderboard.LeaderboardController;
import interface_adapter.leaderboard.LeaderboardPresenter;
import interface_adapter.leaderboard.LeaderboardState;
import interface_adapter.leaderboard.LeaderboardViewState;
import interface_adapter.puzzleRush.PuzzleRushController;
import interface_adapter.puzzleRush.PuzzleRushPresenter;
import interface_adapter.puzzleRush.PuzzleRushState;
import interface_adapter.puzzleRush.PuzzleRushViewState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.leaderboard.LeaderboardInteractor;
import use_case.leaderboard.LeaderboardOutputBoundary;

import java.util.List;

public class PuzzleRushTest {
    @Test
    void testEndToEnd() {
        PuzzleRushViewState viewState = new PuzzleRushViewState("", new PuzzleRushState(null));

        PuzzleRushOutputBoundary puzzleRushHandOutputBoundary = new PuzzleRushPresenter(viewState);
        PuzzleRushInteractor puzzleRushInteractor = new PuzzleRushInteractor(puzzleRushHandOutputBoundary);

        PuzzleRushController controller = new PuzzleRushController(puzzleRushInteractor);
        controller.execute(0, viewState.getState().getHandState());

        Assertions.assertNull(viewState.getState().getFailMessage());

        controller.execute(1, viewState.getState().getHandState());

        Assertions.assertNotNull(viewState.getState().getFailMessage());
    }
}
