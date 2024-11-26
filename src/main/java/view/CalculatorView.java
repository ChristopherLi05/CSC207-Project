package view;

import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.ViewManager;
import interface_adapter.addTile.AddTileController;
import interface_adapter.calculator.CalculatorController;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import view.component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import static entity.calculator.mahjong.MahjongTile.EAST_WIND;

public class CalculatorView extends AbstractPanel<CalculatorState> implements ActionListener, PropertyChangeListener {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;
    private AddTileController addTileController;
    private CalculatorController calculatorController;

    public CalculatorView(CalculatorViewState viewState, ViewManager viewManager, IHandStateFactory handStateFactory) {
        super(viewState);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(new TabSwitcherComponent(viewManager));

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

        final JPanel buttons = new JPanel();
        JButton calculate = new JButton("calculate");
        buttons.add(calculate);


        calculate.addActionListener(evt -> {
            List<MahjongTile> closedTiles = viewState.getState().getClosedTiles();
            List<MahjongGroup> closedGroups = viewState.getState().getClosedGroup();
            List<MahjongGroup> openGroups = viewState.getState().getOpenGroups();
            MahjongTile winningTile = viewState.getState().getWinningTile();

            HandState handstate =
                    handStateFactory.createHandState(closedTiles, closedGroups, openGroups, winningTile, new ArrayList<>(), new ArrayList<>(), EAST_WIND, EAST_WIND, true, false, false, false, false, false, false, false, false);

        });

        this.add(buttons, BorderLayout.SOUTH);
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

    public void setCalculatorController(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(getViewState().getState());
    }
}
