package view;

import entity.calculator.mahjong.MahjongTile;
import interface_adapter.ViewManager;
import interface_adapter.addTile.AddTileController;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import view.component.DisplayHandComponent;
import view.component.ITileSelectorComponentState;
import view.component.MahjongTileInputButton;
import view.component.TileSelectorComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorView extends AbstractPanel<CalculatorState> implements ActionListener, PropertyChangeListener {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;

    private AddTileController addTileController;

    public CalculatorView(CalculatorViewState viewState, ViewManager viewManager) {
        super(viewState);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize and add DisplayHandComponent at top
        displayHandComponent = new DisplayHandComponent(true);
        add(displayHandComponent);
        viewState.addPropertyChangeListener(displayHandComponent);

        // Initialize and add TileSelectorComponent at center
        tileSelectorComponent = new TileSelectorComponent(viewState, this);
        JPanel dontStretch = new JPanel(new FlowLayout());
        dontStretch.add(tileSelectorComponent);
        add(dontStretch);

        add(Box.createVerticalGlue());
    }

    public DisplayHandComponent getDisplayHandComponent() {
        return displayHandComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Execute controller.
        if (e.getSource() instanceof MahjongTileInputButton) {
            MahjongTile clickedTile = ((MahjongTileInputButton) e.getSource()).getMahjongTile();
            boolean isAka = getViewState().getState().isAka();
            ITileSelectorComponentState.SelectorType selectorType = getViewState().getState().getSelectorType();

            addTileController.execute(clickedTile, isAka, selectorType);
        }
    }

    public void setAddTileController(AddTileController addTileController) {
        this.addTileController = addTileController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(getViewState().getState());
    }
}
