package interface_adapter.puzzleRush;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.DisplayHandComponentState;

import java.util.List;

/**
 * The {@code PuzzleRushState} class holds the state for a Puzzle Rush game.
 * It implements the {@code IDisplayHandComponentState} interface and stores information
 * about the current hand state, time left, current score, and any failure message.
 * This class is used to display the current state of the game in the view.
 */
public class PuzzleRushState implements DisplayHandComponentState {
    private final HandState handState;

    private String failMessage = null;
    private boolean changedState = false;

    private int timeLeft;
    private int currScore;

    /**
     * Constructs a new {@code PuzzleRushState} with the given hand state, time left, and current score.
     *
     * @param handState the current hand state
     * @param timeLeft the remaining time for the game
     * @param currScore the current score of the player
     */
    public PuzzleRushState(HandState handState, int timeLeft, int currScore) {
        this.handState = handState;
        this.timeLeft = timeLeft;
        this.currScore = currScore;
    }

    /**
     * Constructs a new {@code PuzzleRushState} with the given hand state, setting the time left and current score to 0.
     *
     * @param handState the current hand state
     */
    public PuzzleRushState(HandState handState) {
        this(handState, 0, 0);
    }

    /**
     * Returns the list of closed tiles from the current hand state.
     *
     * @return a list of closed tiles
     */
    @Override
    public List<MahjongTile> getClosedTiles() {
        return handState.closedTiles();
    }

    /**
     * Returns the list of closed groups from the current hand state.
     *
     * @return a list of closed groups
     */
    @Override
    public List<MahjongGroup> getClosedGroup() {
        return handState.closedGroup();
    }

    /**
     * Returns the list of open groups from the current hand state.
     *
     * @return a list of open groups
     */
    @Override
    public List<MahjongGroup> getOpenGroups() {
        return handState.openGroups();
    }

    /**
     * Returns the winning tile from the current hand state.
     *
     * @return the winning tile
     */
    @Override
    public MahjongTile getWinningTile() {
        return handState.winningTile();
    }

    /**
     * Returns whether the state has changed since the last time it was checked.
     *
     * @return true if the state has changed, false otherwise
     */
    @Override
    public boolean changedState() {
        boolean changedState = this.changedState;
        this.changedState = false;
        return changedState;
    }

    /**
     * Sets whether the state has changed.
     *
     * @param changedState a boolean indicating if the state has changed
     */
    public void setChangedState(boolean changedState) {
        this.changedState = changedState;
    }

    /**
     * Returns the time left in the game.
     *
     * @return the time left
     */
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * Returns the current score of the player.
     *
     * @return the current score
     */
    public int getCurrScore() {
        return currScore;
    }

    /**
     * Sets the time left in the game.
     *
     * @param timeLeft the remaining time
     */
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * Sets the current score of the player.
     *
     * @param currScore the current score
     */
    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    /**
     * Returns the failure message, if any.
     *
     * @return the failure message, or null if there is no failure message
     */
    public String getFailMessage() {
        return failMessage;
    }

    /**
     * Sets the failure message to be displayed.
     *
     * @param failMessage the failure message
     */
    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    /**
     * Returns the hand state associated with this state.
     *
     * @return the current hand state
     */
    public HandState getHandState() {
        return handState;
    }
}
