package use_case.calculator;

import entity.calculator.Calculator;
import entity.calculator.HandState;

public class CalculatorInteractor implements CalculatorInputBoundary{
    private final CalculatorOutputBoundary calculatorPresenter;

    public CalculatorInteractor(CalculatorOutputBoundary calculatorOutputBoundary) {
        this.calculatorPresenter = calculatorOutputBoundary;
    }

    @Override
    public void execute(HandState hand) {
        int score = Calculator.calculateScore(hand);
        if (score == 0) {
            calculatorPresenter.prepareFailView("Invalid hand");
        } else {
            calculatorPresenter.prepareSuccessView("Score is", new CalculatorOutputData(score));
        }
    }
}
