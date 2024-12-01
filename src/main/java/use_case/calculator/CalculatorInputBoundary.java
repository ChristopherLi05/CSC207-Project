package use_case.calculator;

import entity.calculator.HandState;

/**
 * Input boundary interface for the Calculator use case.
 * Defines the contract for calculating a score or performing other calculations
 * based on a provided hand state.
 */
public interface CalculatorInputBoundary {

    /**
     * Executes the calculation logic based on the provided {@link HandState}.
     * This method is called to perform the primary business logic for the calculation.
     *
     * @param hand The {@link HandState} representing the current state of the hand to be calculated.
     */
    void execute(HandState hand);

    void reset();
}
