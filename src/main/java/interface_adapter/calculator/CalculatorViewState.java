package interface_adapter.calculator;

import interface_adapter.ViewState;

/**
 * Represents the view state for the Calculator feature in the Mahjong game.
 * This class extends the generic {@code ViewState} and encapsulates the specific
 * state and behavior related to the calculator.
 */
public class CalculatorViewState extends ViewState<CalculatorState> {

    /**
     * Constructs a {@code CalculatorViewState} with the specified view name and state.
     *
     * @param viewName the name of the view associated with this state
     * @param state    the specific {@link CalculatorState} to manage
     */
    public CalculatorViewState(String viewName, CalculatorState state) {
        super(viewName, state);
    }
}
