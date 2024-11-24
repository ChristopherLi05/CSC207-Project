package use_case.puzzleRush;


public interface PuzzleRushOutputBoundary {
    void prepareSuccessView(PuzzleRushOutputData outputData);

    void prepareFailView(String errorMessage);
}
