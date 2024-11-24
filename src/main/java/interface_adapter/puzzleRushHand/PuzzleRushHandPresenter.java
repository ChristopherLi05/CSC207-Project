package interface_adapter.puzzleRushHand;

import use_case.puzzleRushHand.PuzzleRushHandOutputBoundary;
import use_case.puzzleRushHand.PuzzleRushHandOutputData;

public class PuzzleRushHandPresenter implements PuzzleRushHandOutputBoundary {
    private final PuzzleRushViewState puzzleRushViewState;

    public PuzzleRushHandPresenter(PuzzleRushViewState puzzleRushViewState) {
        this.puzzleRushViewState = puzzleRushViewState;
    }

    @Override
    public void prepareSuccessView(PuzzleRushHandOutputData outputData) {
        PuzzleRushState state = new PuzzleRushState(outputData.getNewHandState().closedTiles(), outputData.getNewHandState().closedGroup(), outputData.getNewHandState().openGroups(), outputData.getNewHandState().winningTile(), outputData.getTimeLeft(), outputData.getCurrScore());
        puzzleRushViewState.setState(state);
        puzzleRushViewState.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        throw new RuntimeException("This should never happen");
    }
}
