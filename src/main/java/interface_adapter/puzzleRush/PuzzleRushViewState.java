package interface_adapter.puzzleRush;

import interface_adapter.ViewState;

/**
 * The {@code PuzzleRushViewState} class represents the view state for the Puzzle Rush game.
 * It extends the {@code ViewState} class and manages the state associated with Puzzle Rush,
 * including the hand state, time left, score, and failure message.
 * This class is used to notify the view layer of any changes in the game state.
 */
public class PuzzleRushViewState extends ViewState<PuzzleRushState> {

    /**
     * Constructs a new {@code PuzzleRushViewState} with the specified view name and state.
     *
     * @param viewName the name of the view
     * @param state the current state of the Puzzle Rush game
     */
    public PuzzleRushViewState(String viewName, PuzzleRushState state) {
        super(viewName, state);
    }
}
