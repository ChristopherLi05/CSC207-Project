package interface_adapter.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileModifierState;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState implements ITileModifierState {
    private final List<MahjongTile> closedTiles;
    private final List<MahjongGroup> closedGroups;
    private final List<MahjongGroup> openGroups;
    private MahjongTile winningTile;

    public CalculatorState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile) {
        this.closedTiles = closedTiles;
        this.closedGroups = closedGroups;
        this.openGroups = openGroups;
        this.winningTile = winningTile;
    }

    public CalculatorState() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null);
    }


    @Override
    public List<MahjongTile> getClosedTiles() {
        return closedTiles;
    }

    @Override
    public List<MahjongGroup> getClosedGroup() {
        return closedGroups;
    }

    @Override
    public List<MahjongGroup> getOpenGroups() {
        return openGroups;
    }

    @Override
    public MahjongTile getWinningTile() {
        return winningTile;
    }

    @Override
    public void addClosedTile(MahjongTile mahjongTile) {
        this.closedTiles.add(mahjongTile);
    }

    @Override
    public void addClosedGroup(MahjongGroup mahjongGroup) {
        this.closedGroups.add(mahjongGroup);
    }

    @Override
    public void addOpenGroup(MahjongGroup mahjongGroup) {
        this.openGroups.add(mahjongGroup);
    }

    @Override
    public void setWinningTile(MahjongTile mahjongTile) {
        this.winningTile = mahjongTile;
    }

    public int getTileNumber() {
        return this.closedTiles.size() + (this.winningTile != null ? 1 : 0) + 3 * this.closedGroups.size() + 3 * this.openGroups.size();
    }
}

