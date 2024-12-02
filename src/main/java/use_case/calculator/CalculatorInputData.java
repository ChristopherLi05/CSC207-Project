package use_case.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

/**
 * Represents the input data required for calculating Mahjong game results.
 * This class encapsulates the tiles, groups, and the winning tile needed to perform calculations.
 */
public class CalculatorInputData {

    /**
     * A list of closed tiles (individual tiles not part of a group).
     */
    public final List<MahjongTile> closedTiles;

    /**
     * A list of closed groups (hidden melds or combinations of tiles).
     */
    public final List<MahjongGroup> closedGroups;

    /**
     * A list of open groups (melds or combinations of tiles revealed to other players).
     */
    public final List<MahjongGroup> openGroups;

    /**
     * The tile that completes the winning hand.
     */
    public final MahjongTile winningTile;

    /**
     * Constructs an instance of {@code CalculatorInputData} with the specified tiles and groups.
     *
     * @param closedTiles  the list of closed tiles
     * @param closedGroups the list of closed groups
     * @param openGroups   the list of open groups
     * @param winningTile  the tile that completes the winning hand
     */
    public CalculatorInputData(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile) {
        this.closedTiles = closedTiles;
        this.closedGroups = closedGroups;
        this.openGroups = openGroups;
        this.winningTile = winningTile;
    }

    /**
     * Returns the list of closed tiles.
     *
     * @return the list of closed tiles
     */
    public List<MahjongTile> getClosedTiles() {
        return closedTiles;
    }

    /**
     * Returns the list of closed groups.
     *
     * @return the list of closed groups
     */
    public List<MahjongGroup> getClosedGroups() {
        return closedGroups;
    }

    /**
     * Returns the list of open groups.
     *
     * @return the list of open groups
     */
    public List<MahjongGroup> getOpenGroups() {
        return openGroups;
    }

    /**
     * Returns the winning tile.
     *
     * @return the winning tile
     */
    public MahjongTile getWinningTile() {
        return winningTile;
    }
}