package use_case.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public class CalculatorInputData {

    public final List<MahjongTile> closedTiles;
    public final List<MahjongGroup> closedGroups;
    public final List<MahjongGroup> openGroups;
    public final MahjongTile winningTile;

    public CalculatorInputData(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile) {

        this.closedTiles = closedTiles;
        this.closedGroups = closedGroups;
        this.openGroups = openGroups;
        this.winningTile = winningTile;
    }
    public List<MahjongTile> getClosedTiles() {
        return closedTiles;
    }
    public List<MahjongGroup> getClosedGroups() {
        return closedGroups;
    }
    public List<MahjongGroup> getOpenGroups() {
        return openGroups;
    }
    public MahjongTile getWinningTile() {
        return winningTile;
    }
}