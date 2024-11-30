package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the White Dragon Yaku test case.
 *
 * The White Dragon Yaku is awarded when the hand contains a group of tiles that include
 * the White Dragon tile (WHITE_DRAGON). This class implements the logic to check for
 * this Yaku and provides the Han values for both closed and open hands.
 */
public class WhiteDragonTestCase implements YakuTestCase {
    /**
     * Checks if the given hand satisfies the White Dragon Yaku.
     *
     * This Yaku is valid when a group in the hand contains a tile that matches
     * the White Dragon (WHITE_DRAGON) tile.
     *
     * @param hand the HandState, which contains the contextual information of the hand.
     * @param handGrouping the HandGrouping of the hand, consisting of groups of tiles.
     * @return true if the hand satisfies the White Dragon Yaku; false otherwise.
     */
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == MahjongTile.WHITE_DRAGON) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getClosedHanValue() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getOpenHanValue() {
        return 1;
    }
}
