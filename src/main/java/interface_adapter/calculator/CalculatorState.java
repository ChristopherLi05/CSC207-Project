package interface_adapter.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.login.LoginState;
import view.component.ITileModifierState;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState implements ITileModifierState {
    private final List<MahjongTile> closedTiles;
    private final List<MahjongGroup> closedGroups;
    private final List<MahjongGroup> openGroups;
    private MahjongTile winningTile;
    private boolean isAka = false;
    private SelectorType selectorType = SelectorType.NONE;
    private static String messageState = null;

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
    public boolean changedState() {
        return true;
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

    public void setWinningTile() {
        this.winningTile = this.closedTiles.remove(this.closedTiles.size() - 1);
    }

    public int getTileNumber() {
        return this.closedTiles.size() + (this.winningTile != null ? 1 : 0) + 3 * this.closedGroups.size() + 3 * this.openGroups.size();
    }

    public SelectorType getSelectorType() {
        return selectorType;
    }

    public void setSelectorType(SelectorType selectorType) {
        this.selectorType = selectorType;
    }

    public boolean isAka() {
        return isAka;
    }

    public void setAka(boolean aka) {
        isAka = aka;
    }

    @Override
    public String toString() {
        return "CalculatorState(closedTiles=" + closedTiles + ", closedGroups=" + closedGroups + ", openGroups=" + openGroups + ", winningTile=" + winningTile + ")";
    }

    public void setMessageState(String message) {
        this.messageState = message;
    }

    public String getMessageState() {
        return messageState;
    }
}

