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

    @Override
    public void addClosedTile(MahjongTile mahjongTile) {

    }

    @Override
    public void addChiiGroup(MahjongGroup mahjongGroup) {

    }

    @Override
    public void addPonGroup(MahjongGroup mahjongGroup) {

    }

    @Override
    public void addClosedKanGroup(MahjongGroup mahjongGroup) {

    }

    @Override
    public void addOpenKanGroup(MahjongGroup mahjongGroup) {

    }
}
