package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

/**
 * Display Hand Component Interface (if multiple states want to use display selector)
 */
public interface DisplayHandComponentState {
    /**
     * Gets the closed tiles
     * @return closed tile
     */
    List<MahjongTile> getClosedTiles();

    /**
     * Gets the closed groups
     * @return closed groups
     */
    List<MahjongGroup> getClosedGroup();

    /**
     * Gets the open groups
     * @return open groups
     */
    List<MahjongGroup> getOpenGroups();

    /**
     * Gets the winning tile
     * @return winning tile
     */
    MahjongTile getWinningTile();

    /**
     * Whether the mahjong hand has been changed or not; sets to false after the use
     * @return changed state
     */
    boolean changedState();
}
