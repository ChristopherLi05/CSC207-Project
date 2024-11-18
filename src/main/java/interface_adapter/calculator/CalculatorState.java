package interface_adapter.calculator;

import entity.calculator.Calculator;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorMaster;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState implements ITileSelectorMaster {
    private final List<MahjongTile> selectedTiles = new ArrayList<>();
    private boolean containsAka = false;
    private boolean isOpen = false;

    public List<MahjongTile> getSelectedTiles() {
        return selectedTiles;
    }

    public boolean isContainsAka() {
        return containsAka;
    }

    public void setContainsAka(boolean containsAka) {
        this.containsAka = containsAka;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public void addClosedTile(MahjongTile mahjongTile) {
        System.out.println("Closed tile: " + mahjongTile);
    }

    @Override
    public void addChiiGroup(MahjongGroup mahjongGroup) {
        System.out.println("Chii Group: " + mahjongGroup);
    }

    @Override
    public void addPonGroup(MahjongGroup mahjongGroup) {
        System.out.println("Chii Group: " + mahjongGroup);
    }

    @Override
    public void addClosedKanGroup(MahjongGroup mahjongGroup) {
        System.out.println("Closed Kan Group: " + mahjongGroup);
    }

    @Override
    public void addOpenKanGroup(MahjongGroup mahjongGroup) {
        System.out.println("Open Kan Group: " + mahjongGroup);
    }
}

