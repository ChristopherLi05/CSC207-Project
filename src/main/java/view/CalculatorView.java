package view;

import interface_adapter.ViewManager;
import interface_adapter.addTile.AddTileController;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import view.component.DisplayHandComponent;
import view.component.MahjongTileInputButton;
import view.component.TileSelectorComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorView extends AbstractPanel<CalculatorState> implements PropertyChangeListener, ActionListener {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;
    private AddTileController addTileController;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // Execute controller.
        if (e.getSource() instanceof MahjongTileInputButton) {
            addTileController.execute(e.getSource(), tileSelectorComponent.containsAka(),
                    tileSelectorComponent.getSelectorType());
        }
    }
}
