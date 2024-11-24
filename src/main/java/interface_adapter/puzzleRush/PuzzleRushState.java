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

    private int timeLeft;
    private int currScore;

    public PuzzleRushState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile, int timeLeft, int currScore) {
        this.closedTiles = closedTiles;
        this.closedGroups = closedGroups;
        this.openGroups = openGroups;
        this.winningTile = winningTile;
        this.timeLeft = timeLeft;
        this.currScore = currScore;
    }

    public PuzzleRushState() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, 0, 0);
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

    public int getTimeLeft() {
        return timeLeft;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }
}
