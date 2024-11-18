package interface_adapter.calculator;

import interface_adapter.ViewState;

public class CalculatorViewState extends ViewState<CalculatorState> {

    public CalculatorViewState(String viewName, CalculatorState state) {
        super(viewName, state);
    }
}
