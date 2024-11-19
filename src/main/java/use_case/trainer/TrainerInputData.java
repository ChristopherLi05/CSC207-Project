package use_case.trainer;

import entity.calculator.HandState;

public class TrainerInputData {
    private final int attempt;
    private final HandState handState;

    public TrainerInputData(int attempt, HandState handState) {
        this.attempt = attempt;
        this.handState = handState;
    }

    public int getAttempt() {
        return attempt;
    }

    public HandState getHandState() {
        return handState;
    }
}
