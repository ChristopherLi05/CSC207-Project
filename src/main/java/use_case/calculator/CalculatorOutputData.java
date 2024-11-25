package use_case.calculator;

import entity.calculator.HandState;

public class CalculatorOutputData {

    private final int score;

    public CalculatorOutputData(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
