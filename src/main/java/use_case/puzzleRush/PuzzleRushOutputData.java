package use_case.puzzleRush;

import entity.calculator.HandState;

public class PuzzleRushOutputData {
    private final HandState newHandState;

    public PuzzleRushOutputData(HandState newHandState) {
        this.newHandState = newHandState;
    }

    public HandState getNewHandState() {
        return newHandState;
    }
}
