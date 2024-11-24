package interface_adapter.puzzleRush;

import use_case.puzzleRush.PuzzleRushInputBoundary;

public class PuzzleRushController {
    private final PuzzleRushInputBoundary puzzleRushInputBoundary;

    public PuzzleRushController(PuzzleRushInputBoundary puzzleRushInputBoundary) {
        this.puzzleRushInputBoundary = puzzleRushInputBoundary;
    }

    public void execute() {
        puzzleRushInputBoundary.execute();
    }
}
