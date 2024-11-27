package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Tile Selector Component Interface (if multiple states want to use tile selector)
 */
public interface ITileSelectorComponentState {
    /**
     * Adds a closed tile
     * @param mahjongTile .
     */
    void addClosedTile(MahjongTile mahjongTile);

    /**
     * Adds a closed group
     * @param mahjongGroup .
     */
    void addClosedGroup(MahjongGroup mahjongGroup);

    /**
     * Adds an open group
     * @param mahjongGroup .
     */
    void addOpenGroup(MahjongGroup mahjongGroup);

    /**
     * Sets the winning tile
     * @param mahjongTile .
     */
    void setWinningTile(MahjongTile mahjongTile);

    /**
     * The selector type
     */
    enum SelectorType {
        NONE, PON, CHII, CLOSED_KAN, OPEN_KAN;
    }
}