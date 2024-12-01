package interface_adapter.calculator;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongTile;
import use_case.calculator.CalculatorInputBoundary;
import use_case.calculator.CalculatorInputData;

import java.util.List;

/**
 * Controller class for handling the Calculator use case.
 * This class acts as a bridge between the user interface and the business logic,
 * delegating the task of score calculation to the use case interactor.
 */
public class CalculatorController {

    /**
     * The input boundary for the Calculator use case, enabling dependency inversion.
     */
    private final CalculatorInputBoundary calculatorUseCaseInteractor;

    /**
     * Constructs a CalculatorController with the specified use case interactor.
     *
     * @param calculatorUseCaseInteractor the interactor responsible for processing the calculator logic
     */
    public CalculatorController(CalculatorInputBoundary calculatorUseCaseInteractor) {
        this.calculatorUseCaseInteractor = calculatorUseCaseInteractor;
    }

    /**
     * Executes the calculator use case with the provided hand state.
     *
     * @param hand the hand state to be processed for score calculation
     */
    public void execute(HandState hand) {
        calculatorUseCaseInteractor.execute(hand);
    }

    public void reset() {calculatorUseCaseInteractor.reset();}
}
