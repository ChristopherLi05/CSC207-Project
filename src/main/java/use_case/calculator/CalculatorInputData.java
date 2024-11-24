package use_case.calculator;

import entity.calculator.HandState;

public class CalculatorInputData {

    private final HandState hand;

    public CalculatorInputData(HandState hand) {
        this.hand = hand;
    }

    HandState getHand() {
        return hand;
    }
}
