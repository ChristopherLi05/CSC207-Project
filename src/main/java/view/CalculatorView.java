package view;

import app.IApp;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorMaster;
import view.component.MahjongTileInputButton;
import view.component.TileSelectorComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorView extends AbstractPanel implements ITileSelectorMaster {
    private final TileSelectorComponent tileSelectorComponent;

    public CalculatorView(IApp master) {
        super(master);

        tileSelectorComponent = new TileSelectorComponent(this);
    }

    @Override
    public String getViewName() {
        return "CalculatorView";
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
