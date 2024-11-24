package interface_adapter.puzzleRush;

import use_case.puzzleRush.PuzzleRushOutputBoundary;

public class PuzzleRushPresenter implements PuzzleRushOutputBoundary {
    private final PuzzleRushViewState viewState;

    public PuzzleRushPresenter(PuzzleRushViewState viewState) {
        this.viewState = viewState;
    }


    @Override
    public void prepareSuccessView() {
        viewState.getState().setFailMessage(null);
        viewState.firePropertyChanged();
        viewState.firePropertyChanged("successChangeHand");
    }

    @Override
    public void prepareFailView(String message) {
        viewState.getState().setFailMessage(message);
        viewState.firePropertyChanged();
        viewState.firePropertyChanged("failChangeHand");
    }
}
