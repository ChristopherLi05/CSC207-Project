package interface_adapter.puzzleRushHand;

import interface_adapter.puzzleRush.PuzzleRushState;
import interface_adapter.puzzleRush.PuzzleRushViewState;
import use_case.puzzleRushHand.PuzzleRushHandOutputBoundary;
import use_case.puzzleRushHand.PuzzleRushHandOutputData;

/**
 * The {@code PuzzleRushHandPresenter} class is responsible for presenting the result of the
 * Puzzle Rush hand update use case. It updates the view state with either the new hand state
 * and relevant details or an error message in case of failure.
 */
public class PuzzleRushHandPresenter implements PuzzleRushHandOutputBoundary {

    private final PuzzleRushViewState puzzleRushViewState;

    /**
     * Constructs a new {@code PuzzleRushHandPresenter} with the specified view state.
     *
     * @param puzzleRushViewState the view state that represents the current state of the Puzzle Rush game
     */
    public PuzzleRushHandPresenter(PuzzleRushViewState puzzleRushViewState) {
        this.puzzleRushViewState = puzzleRushViewState;
    }

    /**
     * Prepares the success view with the updated hand state, time left, and current score.
     *
     * This method updates the {@code PuzzleRushViewState} with the new hand state and marks the state as changed.
     * It then triggers the necessary property change notifications for the view to update.
     *
     * @param outputData the output data containing the new hand state, time left, and current score
     */
    @Override
    public void prepareSuccessView(PuzzleRushHandOutputData outputData) {
        PuzzleRushState state = new PuzzleRushState(outputData.getNewHandState(), outputData.getTimeLeft(), outputData.getCurrScore());
        state.setChangedState(true);
        puzzleRushViewState.setState(state);
        puzzleRushViewState.firePropertyChanged();
    }

    /**
     * Prepares the fail view with an error message.
     *
     * Note: The current use case is designed not to fail, so this method should never be invoked.
     * It throws a {@code RuntimeException} if called.
     *
     * @param errorMessage the error message to display (not used as the method should not be called)
     * @throws RuntimeException if this method is called (should never happen)
     */
    @Override
    public void prepareFailView(String errorMessage) {
        throw new RuntimeException("This should never happen");
    }
}
