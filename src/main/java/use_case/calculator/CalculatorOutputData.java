package use_case.calculator;

import entity.calculator.HandState;

public class CalculatorOutputData {

    private final int score;
    private final boolean useCaseFailed;

    public CalculatorOutputData(int score, boolean useCaseFailed) {
        this.score = score;
        this.useCaseFailed = useCaseFailed;
    }

    public int getScore() {
        return score;
    }
}
