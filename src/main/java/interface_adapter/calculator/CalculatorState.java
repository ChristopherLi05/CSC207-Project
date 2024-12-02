package interface_adapter.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.TileModifierState;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state of the Calculator in the Mahjong game.
 * This class manages the tiles and groups, including open and closed groups,
 * and handles updates to the winning tile and other relevant states.
 */
public class CalculatorState implements TileModifierState {

    private final List<MahjongTile> closedTiles;
    private final List<MahjongGroup> closedGroups;
    private final List<MahjongGroup> openGroups;
    private MahjongTile winningTile;
    private boolean isAka = false;
    private SelectorType selectorType = SelectorType.NONE;
    private static String messageState = "Score is 0";

    /**
     * Constructs a CalculatorState with the specified tiles and groups.
     *
     * @param closedTiles  the list of closed tiles
     * @param closedGroups the list of closed groups
     * @param openGroups   the list of open groups
     * @param winningTile  the winning tile, or null if none
     */
    public CalculatorState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile) {
        this.closedTiles = closedTiles;
        this.closedGroups = closedGroups;
        this.openGroups = openGroups;
        this.winningTile = winningTile;
    }

    /**
     * Default constructor initializing with empty lists and no winning tile.
     */
    public CalculatorState() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null);
    }

    /**
     * Retrieves the list of closed tiles.
     *
     * @return the list of closed tiles
     */
    @Override
    public List<MahjongTile> getClosedTiles() {
        return closedTiles;
    }

    /**
     * Retrieves the list of closed groups.
     *
     * @return the list of closed groups
     */
    @Override
    public List<MahjongGroup> getClosedGroup() {
        return closedGroups;
    }

    /**
     * Retrieves the list of open groups.
     *
     * @return the list of open groups
     */
    @Override
    public List<MahjongGroup> getOpenGroups() {
        return openGroups;
    }

    /**
     * Retrieves the current winning tile.
     *
     * @return the winning tile, or null if not set
     */
    @Override
    public MahjongTile getWinningTile() {
        return winningTile;
    }

    /**
     * Indicates if the state has changed.
     *
     * @return true, indicating the state has changed
     */
    @Override
    public boolean changedState() {
        return true;
    }

    /**
     * Adds a closed tile to the list of closed tiles.
     *
     * @param mahjongTile the tile to add
     */
    @Override
    public void addClosedTile(MahjongTile mahjongTile) {
        this.closedTiles.add(mahjongTile);
    }

    /**
     * Adds a closed group to the list of closed groups.
     *
     * @param mahjongGroup the group to add
     */
    @Override
    public void addClosedGroup(MahjongGroup mahjongGroup) {
        this.closedGroups.add(mahjongGroup);
    }

    /**
     * Adds an open group to the list of open groups.
     *
     * @param mahjongGroup the group to add
     */
    @Override
    public void addOpenGroup(MahjongGroup mahjongGroup) {
        this.openGroups.add(mahjongGroup);
    }

    /**
     * Sets the winning tile.
     *
     * @param mahjongTile the tile to set as the winning tile
     */
    @Override
    public void setWinningTile(MahjongTile mahjongTile) {
        this.winningTile = mahjongTile;
    }

    /**
     * Sets the last closed tile as the winning tile.
     */
    public void setWinningTile() {
        this.winningTile = this.closedTiles.remove(this.closedTiles.size() - 1);
    }

    /**
     * Retrieves the total number of tiles in the current state, including groups and the winning tile.
     *
     * @return the total number of tiles
     */
    public int getTileNumber() {
        return this.closedTiles.size() + (this.winningTile != null ? 1 : 0) + 3 * this.closedGroups.size() + 3 * this.openGroups.size();
    }

    /**
     * Retrieves the current selector type.
     *
     * @return the selector type
     */
    public SelectorType getSelectorType() {
        return selectorType;
    }

    /**
     * Sets the selector type.
     *
     * @param selectorType the selector type to set
     */
    public void setSelectorType(SelectorType selectorType) {
        this.selectorType = selectorType;
    }

    /**
     * Checks if the "aka" flag is enabled.
     *
     * @return true if "aka" is enabled, false otherwise
     */
    public boolean isAka() {
        return isAka;
    }

    /**
     * Sets the "aka" flag.
     *
     * @param aka the value to set for the "aka" flag
     */
    public void setAka(boolean aka) {
        isAka = aka;
    }

    /**
     * Returns a string representation of the CalculatorState.
     *
     * @return a string describing the current state
     */
    @Override
    public String toString() {
        return "CalculatorState(closedTiles=" + closedTiles + ", closedGroups=" + closedGroups + ", openGroups=" + openGroups + ", winningTile=" + winningTile + ")";
    }

    /**
     * Sets the message state.
     *
     * @param message the message to set
     */
    public void setMessageState(String message) {
        this.messageState = message;
    }


    /**
     * Retrieves the current message state.
     *
     * @return the current message state
     */
    public String getMessageState() {
        return messageState;
    }

    /**
     * reset the current data
     */
    public void resetState() {
        this.closedTiles.clear();
        this.closedGroups.clear();
        this.openGroups.clear();
        this.winningTile = null;
    }
}
