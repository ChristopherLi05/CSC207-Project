package use_case.puzzleRushHand;


public interface PuzzleRushHandOutputBoundary {
    void prepareSuccessView(PuzzleRushHandOutputData outputData);

    void prepareFailView(String errorMessage);
}
