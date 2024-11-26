package interface_adapter.calculator;

import use_case.calculator.CalculatorOutputBoundary;
import use_case.calculator.CalculatorOutputData;

/**
 * Presenter class for the Calculator use case.
 * This class is responsible for preparing the output data and updating the view state
 * based on the results of the calculator use case.
 */
public class CalculatorPresenter implements CalculatorOutputBoundary {

    /**
     * The view state associated with the Calculator, used to reflect changes in the UI.
     */
    private final CalculatorViewState calculatorViewState;

    /**
     * Constructs a CalculatorPresenter with the specified view state.
     *
     * @param calculatorViewState the view state used to update the UI
     */
    public CalculatorPresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }

    /**
     * Prepares the success view by updating the state with the success message and output data.
     *
     * @param successMessage the success message to be displayed
     * @param outputData     the output data containing the calculated score
     */
    @Override
    public void prepareSuccessView(String successMessage, CalculatorOutputData outputData) {
        final CalculatorState calculatorState = calculatorViewState.getState();
        calculatorState.setMessageState(successMessage);
        calculatorViewState.firePropertyChanged();
    }

    /**
     * Prepares the failure view by updating the state with the error message.
     *
     * @param errorMessage the error message to be displayed
     */
    @Override
    public void prepareFailView(String errorMessage) {
        final CalculatorState calculatorState = calculatorViewState.getState();
        calculatorState.setMessageState(errorMessage);
        calculatorViewState.firePropertyChanged();
    }
}
