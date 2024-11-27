package interface_adapter.puzzleRush;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.IDisplayHandComponentState;

import java.util.List;

public class PuzzleRushState implements IDisplayHandComponentState {
    private final HandState handState;

    private String failMessage = null;
    private boolean changedState = false;

    private int timeLeft;
    private int currScore;

    public PuzzleRushState(HandState handState, int timeLeft, int currScore) {
        this.handState = handState;
        this.timeLeft = timeLeft;
        this.currScore = currScore;
    }

    public PuzzleRushState(HandState handState) {
        this(handState, 0, 0);
    }

    @Override
    public List<MahjongTile> getClosedTiles() {
        return handState.closedTiles();
    }

    @Override
    public List<MahjongGroup> getClosedGroup() {
        return handState.closedGroup();
    }

    @Override
    public List<MahjongGroup> getOpenGroups() {
        return handState.openGroups();
    }

    @Override
    public MahjongTile getWinningTile() {
        return handState.winningTile();
    }

    @Override
    public boolean changedState() {
        boolean changedState = this.changedState;
        this.changedState = false;
        return changedState;
    }

    public void setChangedState(boolean changedState) {
        this.changedState = changedState;
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

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public HandState getHandState() {
        return handState;
    }
}
