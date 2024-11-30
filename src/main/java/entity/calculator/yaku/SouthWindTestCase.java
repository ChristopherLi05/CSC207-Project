package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the South Wind Yaku test case.
 *
 * The South Wind Yaku is awarded when the hand contains a group of South Wind tiles
 * and the round wind is also South Wind. This class implements the logic to verify
 * the presence of this Yaku and provides its Han values for both closed and open hands.
 */
public class SouthWindTestCase implements YakuTestCase {
    /**
     * Checks if the given hand satisfies the South Wind Yaku.
     *
     * This Yaku is valid when a group in the hand contains South Wind tiles, and
     * the current round wind is also South Wind.
     *
     * @param hand the HandState, which contains the round wind and other contextual information.
     * @param handGrouping the HandGrouping of the hand, consisting of groups of tiles.
     * @return true if the hand satisfies the South Wind Yaku; false otherwise.
     */
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == MahjongTile.SOUTH_WIND &&
            hand.roundWind() == MahjongTile.SOUTH_WIND) {
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
    public int getOpenHanValue() { return 1; }
}
