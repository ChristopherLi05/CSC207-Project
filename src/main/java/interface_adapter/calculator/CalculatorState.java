package interface_adapter.calculator;

import entity.calculator.Calculator;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import use_case.calculator.CalculatorDataAccessInterface;
import view.component.ITileSelectorMaster;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState implements CalculatorDataAccessInterface {
    private final List<MahjongTile> closedTiles;
    private final List<MahjongGroup> closedGroup;
    private final List<MahjongGroup> openedGroup;
    private final MahjongTile winningTile;

    public CalculatorState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroup, List<MahjongGroup> openedGroup, MahjongTile winningTile) {
        this.closedTiles = closedTiles;
        this.closedGroup = closedGroup;
        this.openedGroup = openedGroup;
        this.winningTile = winningTile;
    }


    String getClosedTiles() {};

    void addClosedTiles(List<MahjongTile> closedTiles);

    String getClosedGroup();

    void addClosedGroup(List<MahjongGroup> closedGroup);

    String getOpenGroups();

    void addOpenGroups(List<MahjongGroup> openGroups);

    String getWinningTile();

    void addWinningTile(MahjongTile winningTile);

//    private final List<MahjongTile> selectedTiles = new ArrayList<>();
//    private boolean containsAka = false;
//    private boolean isOpen = false;
//
//    public List<MahjongTile> getSelectedTiles() {
//        return selectedTiles;
//    }
//
//    public boolean isContainsAka() {
//        return containsAka;
//    }
//
//    public void setContainsAka(boolean containsAka) {
//        this.containsAka = containsAka;
//    }
//
//    public boolean isOpen() {
//        return isOpen;
//    }
//
//    public void setIsOpen(boolean isOpen) {
//        this.isOpen = isOpen;
//    }
//
//    @Override
//    public void addClosedTile(MahjongTile mahjongTile) {
//        System.out.println("Closed tile: " + mahjongTile);
//    }
//
//    @Override
//    public void addChiiGroup(MahjongGroup mahjongGroup) {
//        System.out.println("Chii Group: " + mahjongGroup);
//    }
//
//    @Override
//    public void addPonGroup(MahjongGroup mahjongGroup) {
//        System.out.println("Chii Group: " + mahjongGroup);
//    }
//
//    @Override
//    public void addClosedKanGroup(MahjongGroup mahjongGroup) {
//        System.out.println("Closed Kan Group: " + mahjongGroup);
//    }
//
//    @Override
//    public void addOpenKanGroup(MahjongGroup mahjongGroup) {
//        System.out.println("Open Kan Group: " + mahjongGroup);
//        }
}

