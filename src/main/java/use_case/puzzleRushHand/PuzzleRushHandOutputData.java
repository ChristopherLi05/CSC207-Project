package use_case.puzzleRushHand;

import entity.calculator.HandState;

public class PuzzleRushHandOutputData {
    private final HandState newHandState;
    private final int timeLeft;
    private final int currScore;

    public PuzzleRushHandOutputData(HandState newHandState, int timeLeft, int currScore) {
        this.newHandState = newHandState;
        this.timeLeft = timeLeft;
        this.currScore = currScore;
    }

    public HandState getNewHandState() {
        return newHandState;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public int getCurrScore() {
        return currScore;
    }
}
