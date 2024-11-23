package view;

import interface_adapter.ViewManager;
import interface_adapter.calculator.CalculatorController;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;

import interface_adapter.login.LoginController;
import view.component.DisplayHandComponent;
import view.component.TileSelectorComponent;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorView extends AbstractPanel<CalculatorState> implements PropertyChangeListener {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;
    private CalculatorController calculatorController;
    private final JButton calculate;

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

        final JPanel buttons = new JPanel();
        calculate = new JButton("calculate");
        buttons.add(calculate);

        calculate.addActionListener(evt -> calculatorController.execute(displayHandComponent.getSelectedTiles()));
    }

    public DisplayHandComponent getDisplayHandComponent() {
        return displayHandComponent;
    }

    public void setCalculatorController(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

}

