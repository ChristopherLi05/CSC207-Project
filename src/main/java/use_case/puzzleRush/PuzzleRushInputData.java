package use_case.puzzleRush;

import entity.calculator.HandState;

public class PuzzleRushInputData {
    private final int proposedScore;
    private final HandState handState;

    public PuzzleRushInputData(int proposedScore, HandState handState) {
        this.proposedScore = proposedScore;
        this.handState = handState;
    }

    public HandState getHandState() {
        return handState;
    }

    public int getProposedScore() {
        return proposedScore;
    }
}
