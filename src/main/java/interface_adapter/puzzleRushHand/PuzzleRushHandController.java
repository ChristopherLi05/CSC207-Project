package interface_adapter.puzzleRushHand;

import use_case.puzzleRushHand.PuzzleRushHandInputBoundary;

public class PuzzleRushHandController {
    private final PuzzleRushHandInputBoundary puzzleRushHandInputBoundary;

    public PuzzleRushHandController(PuzzleRushHandInputBoundary puzzleRushHandInputBoundary) {
        this.puzzleRushHandInputBoundary = puzzleRushHandInputBoundary;
    }

    public void execute(int timeLeft, int currScore) {
        puzzleRushHandInputBoundary.execute(timeLeft, currScore);
    }
}
