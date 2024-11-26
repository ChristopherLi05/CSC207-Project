package use_case.calculator;

/**
 * Output boundary interface for the Calculator use case.
 * Defines the contract for preparing views that present the result of the calculation.
 */
public interface CalculatorOutputBoundary {

    /**
     * Prepares a success view with the provided success message and output data.
     * This method is called when the calculation is successful and returns a valid score.
     *
     * @param successMessage The message indicating success.
     * @param outputData     The data containing the calculated score.
     */
    void prepareSuccessView(String successMessage, CalculatorOutputData outputData);

    /**
     * Prepares a fail view with the provided error message.
     * This method is called when the calculation fails, such as when the hand is invalid.
     *
     * @param errorMessage The message indicating failure or an error.
     */
    void prepareFailView(String errorMessage);
}