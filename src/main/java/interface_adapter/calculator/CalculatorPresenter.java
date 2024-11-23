package interface_adapter.calculator;

import use_case.calculator.CalculatorOutputBoundary;
import use_case.calculator.CalculatorOutputData;


public class CalculatorPresenter implements CalculatorOutputBoundary {
    private final CalculatorViewState calculatorViewState;

    public CalculatorPresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }

    @Override
    public void prepareSuccessView(CalculatorOutputData outputData) {
        calculatorViewState.setState(new CalculatorState());
        calculatorViewState.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // note: this use case currently can't fail
    }
}
