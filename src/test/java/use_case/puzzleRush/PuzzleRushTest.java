package use_case.puzzleRush;

import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import interface_adapter.puzzleRush.PuzzleRushController;
import interface_adapter.puzzleRush.PuzzleRushPresenter;
import interface_adapter.puzzleRush.PuzzleRushState;
import interface_adapter.puzzleRush.PuzzleRushViewState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuzzleRushTest {
    @Test
    void testEndToEnd() {
        HandState state = new HandStateFactory().createHandState("4s4s6p7p8p4m5mwdwdwd  4srs6s 3m 9m  ww ew 1");
        PuzzleRushViewState viewState = new PuzzleRushViewState("", new PuzzleRushState(state));

        PuzzleRushOutputBoundary puzzleRushHandOutputBoundary = new PuzzleRushPresenter(viewState);
        PuzzleRushInteractor puzzleRushInteractor = new PuzzleRushInteractor(puzzleRushHandOutputBoundary);

        PuzzleRushController controller = new PuzzleRushController(puzzleRushInteractor);
        controller.execute(1, viewState.getState().getHandState());

        Assertions.assertEquals("Correct score: 1000", viewState.getState().getFailMessage());

        controller.execute(0, viewState.getState().getHandState());

        Assertions.assertNotNull(viewState.getState().getFailMessage());
    }
}
