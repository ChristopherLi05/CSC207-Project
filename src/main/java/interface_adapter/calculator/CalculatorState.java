package interface_adapter.calculator;

import entity.calculator.Calculator;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import use_case.addtile.AddTileOutputData;
import view.component.ITileSelectorMaster;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState implements ITileSelectorMaster {
    private final List<MahjongTile> selectedTiles = new ArrayList<>();
    private boolean containsAka = false;
    private boolean isOpen = false;
    private List<MahjongTile> dora;
    private List<MahjongTile> ura;
    private MahjongTile seatWind;
    private MahjongTile roundWind;
    private boolean ron;
    private boolean tsumo;
    private boolean riichi;
    private boolean doubleRiichi;
    private boolean ippatsu;
    private boolean chankan;
    private boolean rinshanKaihou;
    private boolean haitei;
    private boolean houtei;

    public CalculatorState(AddTileOutputData outputData) {
    }

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

