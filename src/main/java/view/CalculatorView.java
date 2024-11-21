package view;

import interface_adapter.ViewManager;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import view.component.DisplayHandComponent;
import view.component.TileSelectorComponent;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorView extends AbstractPanel<CalculatorState> implements PropertyChangeListener {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;

    public CalculatorView(CalculatorViewState viewState, ViewManager viewManager) {
        super(viewState);
        setLayout(new BorderLayout());

        // Initialize and add DisplayHandComponent at top
        displayHandComponent = new DisplayHandComponent();
        add(displayHandComponent, BorderLayout.NORTH);

        // Initialize and add TileSelectorComponent at center
        tileSelectorComponent = new TileSelectorComponent(viewState);
        add(tileSelectorComponent, BorderLayout.CENTER);

        viewState.addPropertyChangeListener(this);
        viewManager.addPropertyChangeListener(this);
    }

    public DisplayHandComponent getDisplayHandComponent() {
        return displayHandComponent;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
