package interface_adapter.addTile;

import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import use_case.addTile.AddTileOutputBoundary;
import use_case.addTile.AddTileOutputData;

public class AddTilePresenter implements AddTileOutputBoundary {
    private final CalculatorViewState calculatorViewState;

    public AddTilePresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }

    @Override
    public void present(AddTileOutputData outputData) {
        // Need to make sure setState does what it's supposed to do.
        calculatorViewState.setState(new CalculatorState(outputData));
        calculatorViewState.firePropertyChanged();
    }
}
