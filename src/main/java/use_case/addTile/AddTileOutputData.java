package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * The {@code AddTileOutputData} class holds the results of adding a tile to a Mahjong hand.
 * It contains the tiles and groups that have been added to the hand as part of the operation.
 */
public class AddTileOutputData {

    // Lists to hold the added tiles and groups
    private final List<MahjongTile> addedTile = new ArrayList<>();
    private final List<MahjongGroup> addedClosedGroup = new ArrayList<>();
    private final List<MahjongGroup> addedOpenGroup = new ArrayList<>();

    /**
     * Constructs an empty {@code AddTileOutputData} object.
     */
    public AddTileOutputData() {
    }

    /**
     * Adds a tile to the list of added tiles.
     *
     * @param tile the Mahjong tile to add
     */
    public void addTile(MahjongTile tile) {
        this.addedTile.add(tile);
    }

    /**
     * Adds a closed group to the list of added closed groups.
     *
     * @param mahjongGroup the Mahjong group to add to the closed groups
     */
    public void addClosedGroup(MahjongGroup mahjongGroup) {
        this.addedClosedGroup.add(mahjongGroup);
    }

    /**
     * Adds an open group to the list of added open groups.
     *
     * @param mahjongGroup the Mahjong group to add to the open groups
     */
    public void addOpenGroup(MahjongGroup mahjongGroup) {
        this.addedOpenGroup.add(mahjongGroup);
    }

    /**
     * Returns the list of added closed groups.
     *
     * @return a list of Mahjong closed groups added during the operation
     */
    public List<MahjongGroup> getAddedClosedGroup() {
        return addedClosedGroup;
    }

    /**
     * Returns the list of added open groups.
     *
     * @return a list of Mahjong open groups added during the operation
     */
    public List<MahjongGroup> getAddedOpenGroup() {
        return addedOpenGroup;
    }

    /**
     * Returns the list of added tiles.
     *
     * @return a list of Mahjong tiles added during the operation
     */
    public List<MahjongTile> getAddedTile() {
        return addedTile;
    }
}
