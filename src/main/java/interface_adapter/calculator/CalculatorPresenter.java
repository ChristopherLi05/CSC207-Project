package interface_adapter.calculator;

import interface_adapter.login.LoginState;
import use_case.calculator.CalculatorOutputBoundary;
import use_case.calculator.CalculatorOutputData;


public class CalculatorPresenter implements CalculatorOutputBoundary {
    private final CalculatorViewState calculatorViewState;

    public CalculatorPresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }
//TODO make it present the message and score
    @Override
    public void prepareSuccessView(String successMessage, CalculatorOutputData outputData) {
        final CalculatorState calculatorState = calculatorViewState.getState();
        calculatorState.setMessageState(successMessage);
        calculatorViewState.firePropertyChanged();
    }
//TODO
    @Override
    public void prepareFailView(String errorMessage) {
        final CalculatorState calculatorState = calculatorViewState.getState();
        calculatorState.setMessageState(errorMessage);
        calculatorViewState.firePropertyChanged();
    }
}
