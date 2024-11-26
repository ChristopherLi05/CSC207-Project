package interface_adapter.puzzleRush;

import use_case.puzzleRush.PuzzleRushOutputBoundary;

/**
 * The {@code PuzzleRushPresenter} class is responsible for preparing the view for the user
 * based on the outcome of the Puzzle Rush use case. It implements the {@code PuzzleRushOutputBoundary}
 * interface and updates the view state accordingly, either preparing a success or failure view.
 */
public class PuzzleRushPresenter implements PuzzleRushOutputBoundary {
    private final PuzzleRushViewState viewState;

    /**
     * Constructs a new {@code PuzzleRushPresenter} with the given view state.
     *
     * @param viewState the view state to be updated by the presenter
     */
    public PuzzleRushPresenter(PuzzleRushViewState viewState) {
        this.viewState = viewState;
    }

    /**
     * Prepares the success view by clearing any fail messages and triggering the relevant property change events.
     * This method is called when the Puzzle Rush use case is successfully completed.
     */
    @Override
    public void prepareSuccessView() {
        // Clears any previous error message and triggers the success view update
        viewState.getState().setFailMessage(null);
        viewState.firePropertyChanged();
        viewState.firePropertyChanged("successChangeHand");
    }

    /**
     * Prepares the failure view by setting the failure message and triggering the relevant property change events.
     * This method is called when the Puzzle Rush use case fails.
     *
     * @param message the failure message to be displayed in the view
     */
    @Override
    public void prepareFailView(String message) {
        // Sets the failure message and triggers the failure view update
        viewState.getState().setFailMessage(message);
        viewState.firePropertyChanged();
        viewState.firePropertyChanged("failChangeHand");
    }
}
