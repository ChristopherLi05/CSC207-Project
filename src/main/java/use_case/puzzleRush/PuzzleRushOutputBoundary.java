package use_case.puzzleRush;

public interface PuzzleRushOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String message);
}
