package use_case.calculator;

import entity.calculator.Calculator;
import entity.calculator.HandState;

/**
 * Interactor for the Calculator use case.
 * This class handles the calculation of the score based on the given {@link HandState}.
 * It coordinates with the output boundary to present the result.
 */
public class CalculatorInteractor implements CalculatorInputBoundary {

    /** The output boundary for presenting the result of the calculation. */
    private final CalculatorOutputBoundary calculatorPresenter;

    /**
     * Constructs a new {@code CalculatorInteractor} with the provided output boundary.
     *
     * @param calculatorOutputBoundary The output boundary to be used for presenting the result.
     */
    public CalculatorInteractor(CalculatorOutputBoundary calculatorOutputBoundary) {
        this.calculatorPresenter = calculatorOutputBoundary;
    }

    /**
     * Executes the calculation logic to compute the score for the provided hand.
     * If the score is valid, it sends the result to the presenter. If the score is zero,
     * it prepares a failure view with an error message.
     *
     * @param input The {@link CalculatorInputData} representing the hand to be evaluated.
     */
    @Override
    public void execute(CalculatorInputData input) {
        // Calculate the score for the given hand
        int score = Calculator.calculateScore(input.getHand());
            // Otherwise, present the calculated score
            calculatorPresenter.prepareSuccessView("Score is ", new CalculatorOutputData(score));
        }
    }