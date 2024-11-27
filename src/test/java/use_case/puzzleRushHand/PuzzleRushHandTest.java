package use_case.puzzleRushHand;

import entity.calculator.HandStateFactory;
import interface_adapter.puzzleRush.PuzzleRushController;
import interface_adapter.puzzleRush.PuzzleRushPresenter;
import interface_adapter.puzzleRush.PuzzleRushState;
import interface_adapter.puzzleRush.PuzzleRushViewState;
import interface_adapter.puzzleRushHand.PuzzleRushHandController;
import interface_adapter.puzzleRushHand.PuzzleRushHandPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.puzzleRush.PuzzleRushInteractor;
import use_case.puzzleRush.PuzzleRushOutputBoundary;

public class PuzzleRushHandTest {
    @Test
    void testEndToEnd() {
        PuzzleRushViewState viewState = new PuzzleRushViewState("", new PuzzleRushState(null));

        PuzzleRushHandOutputBoundary puzzleRushHandOutputBoundary = new PuzzleRushHandPresenter(viewState);
        PuzzleRushHandInteractor puzzleRushInteractor = new PuzzleRushHandInteractor(puzzleRushHandOutputBoundary, new HandStateFactory());

        PuzzleRushHandController controller = new PuzzleRushHandController(puzzleRushInteractor);

        controller.execute(0, 0);
        Assertions.assertEquals(0, viewState.getState().getCurrScore());
    }
}
