package interface_adapter.puzzleRush;

import use_case.puzzleRush.PuzzleRushOutputBoundary;
import use_case.puzzleRush.PuzzleRushOutputData;

public class PuzzleRushPresenter implements PuzzleRushOutputBoundary {
    private final PuzzleRushViewState puzzleRushViewState;

    public PuzzleRushPresenter(PuzzleRushViewState puzzleRushViewState) {
        this.puzzleRushViewState = puzzleRushViewState;
    }

    @Override
    public void prepareSuccessView(PuzzleRushOutputData outputData) {
        PuzzleRushState state = new PuzzleRushState(outputData.getNewHandState().closedTiles(), outputData.getNewHandState().closedGroup(), outputData.getNewHandState().openGroups(), outputData.getNewHandState().winningTile());
        puzzleRushViewState.setState(state);
        puzzleRushViewState.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        throw new RuntimeException("This should never happen");
    }
}
