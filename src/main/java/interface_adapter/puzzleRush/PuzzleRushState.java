package interface_adapter.puzzleRush;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.IDisplayHandComponentState;

import java.util.ArrayList;
import java.util.List;

public class PuzzleRushState implements IDisplayHandComponentState {
    private final List<MahjongTile> closedTiles;
    private final List<MahjongGroup> closedGroups;
    private final List<MahjongGroup> openGroups;
    private MahjongTile winningTile;

    public PuzzleRushState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile) {
        this.closedTiles = closedTiles;
        this.closedGroups = closedGroups;
        this.openGroups = openGroups;
        this.winningTile = winningTile;
    }

    public PuzzleRushState() {
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

    public void setWinningTile(MahjongTile winningTile) {
        this.winningTile = winningTile;
    }
}
