package view;

import app.IApp;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorMaster;
import view.component.DisplayHandComponent;
import view.component.TileSelectorComponent;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends AbstractPanel implements ITileSelectorMaster {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;
    private boolean containsAka = false;

    public CalculatorView(IApp master) {
        super(master);
        setLayout(new BorderLayout());

        // Initialize and add DisplayHandComponent at top
        displayHandComponent = new DisplayHandComponent();
        add(displayHandComponent, BorderLayout.NORTH);

        // Initialize and add TileSelectorComponent at center
        tileSelectorComponent = new TileSelectorComponent(this);
        add(tileSelectorComponent, BorderLayout.CENTER);
    }

    public void setContainsAka(boolean containsAka) {
        this.containsAka = containsAka;
    }

    @Override
    public void addClosedTile(MahjongTile mahjongTile) {
        displayHandComponent.addTile(mahjongTile);
    }

    @Override
    public void addChiiGroup(MahjongGroup mahjongGroup) {
        for (MahjongTile tile : mahjongGroup.getTiles()) {
            displayHandComponent.addTile(tile);
        }
    }

    @Override
    public void addPonGroup(MahjongGroup mahjongGroup) {
        for (MahjongTile tile : mahjongGroup.getTiles()) {
            displayHandComponent.addTile(tile);
        }
    }

    @Override
    public void addClosedKanGroup(MahjongGroup mahjongGroup) {
        for (MahjongTile tile : mahjongGroup.getTiles()) {
            displayHandComponent.addTile(tile);
        }
    }

    @Override
    public void addOpenKanGroup(MahjongGroup mahjongGroup) {
        for (MahjongTile tile : mahjongGroup.getTiles()) {
            displayHandComponent.addTile(tile);
        }
    }

    public DisplayHandComponent getDisplayHandComponent() {
        return displayHandComponent;
    }
}
