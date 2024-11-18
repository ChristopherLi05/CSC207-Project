package view;

import app.IApp;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.ViewManager;
import interface_adapter.ViewState;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import view.component.ITileSelectorMaster;
import view.component.DisplayHandComponent;
import view.component.TileSelectorComponent;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends AbstractPanel<CalculatorState> implements ITileSelectorMaster {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;

    public CalculatorView(CalculatorViewState viewState, ViewManager viewManager) {
        super(viewState);
        setLayout(new BorderLayout());

        // Initialize and add DisplayHandComponent at top
        displayHandComponent = new DisplayHandComponent();
        add(displayHandComponent, BorderLayout.NORTH);

        // Initialize and add TileSelectorComponent at center
        tileSelectorComponent = new TileSelectorComponent(this);
        add(tileSelectorComponent, BorderLayout.CENTER);
    }

    @Override
    public void addClosedTile(MahjongTile mahjongTile) {
        // Test Code
        System.out.println("Closed tile: " + mahjongTile);
    }

    @Override
    public void addChiiGroup(MahjongGroup mahjongGroup) {
        // Test Code
        System.out.println("Chii Group: " + mahjongGroup);
    }

    @Override
    public void addPonGroup(MahjongGroup mahjongGroup) {
        // Test Code
        System.out.println("Chii Group: " + mahjongGroup);
    }

    @Override
    public void addClosedKanGroup(MahjongGroup mahjongGroup) {
        // Test Code
        System.out.println("Closed Kan Group: " + mahjongGroup);
    }

    @Override
    public void addOpenKanGroup(MahjongGroup mahjongGroup) {
        // Test Code
        System.out.println("Open Kan Group: " + mahjongGroup);
    }

    public DisplayHandComponent getDisplayHandComponent() {
        return displayHandComponent;
    }
}
