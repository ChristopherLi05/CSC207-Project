package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongSuit;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to store the intermediate groupings
 */
public class HandGrouping {
    private final List<MahjongGroup> groups = new ArrayList<>();
    private final List<MahjongTile> ungroupedTiles;
    private MahjongTile[] pair = null;

    public HandGrouping(List<MahjongTile> ungroupedTiles) {
        this.ungroupedTiles = ungroupedTiles;
    }

    public MahjongTile[] getPair() {
        return pair;
    }

    public void setPair(MahjongTile tile1, MahjongTile tile2) {
        this.pair = new MahjongTile[]{tile1, tile2};
    }

    public List<MahjongGroup> getGroups() {
        return groups;
    }

    /**
     * Adds a group to the grouping
     *
     * @param group group
     */
    public void addGroup(MahjongGroup group) {
        groups.add(group);
    }

    public List<MahjongTile> getUngroupedTiles() {
        return ungroupedTiles;
    }

    /**
     * Gets the first ungrouped tile for matching
     *
     * @return first ungrouped tile
     */
    public MahjongTile getFirstTile() {
        if (ungroupedTiles.isEmpty()) {
            return null;
        } else {
            return ungroupedTiles.get(0);
        }
    }

    /**
     * Extracts a tile from ungrouped tiles. Returns the extracted tile
     *
     * @param value value we're looking for
     * @param suit  suit we're looking for
     * @return tile that's extracted
     */
    public MahjongTile extractTile(int value, MahjongSuit suit) {
        for (int i = 0; i < ungroupedTiles.size(); i++) {
            MahjongTile tile = ungroupedTiles.get(i);
            if (tile.getValue() == value && tile.getSuit() == suit) {
                ungroupedTiles.remove(i);
                return tile;
            }
        }

        return null;
    }

    /**
     * Deep copy of this class
     *
     * @return handgrouping
     */
    public HandGrouping copy() {
        HandGrouping grouping = new HandGrouping(ungroupedTiles);
        grouping.setPair(pair[0], pair[1]);
        for (MahjongGroup group : groups) {
            grouping.addGroup(group);
        }

        return grouping;
    }
}