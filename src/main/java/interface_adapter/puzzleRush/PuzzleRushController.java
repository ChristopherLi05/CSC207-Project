package interface_adapter.puzzleRush;

import entity.calculator.HandState;
import use_case.puzzleRush.PuzzleRushInputBoundary;
import use_case.puzzleRush.PuzzleRushInputData;

public class PuzzleRushController {
    private final PuzzleRushInputBoundary inputBoundary;

    public PuzzleRushController(PuzzleRushInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(int proposedScore, HandState handState) {
        inputBoundary.execute(new PuzzleRushInputData(proposedScore, handState));
    }
}
