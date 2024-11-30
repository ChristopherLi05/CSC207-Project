package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the West Wind Yaku test case.
 *
 * The West Wind Yaku is awarded when the hand contains a group of West Wind tiles
 * and the round wind is also West Wind. This class implements the logic to verify
 * the presence of this Yaku and provides its Han values for both closed and open hands.
 */
public class WestWindTestCase implements YakuTestCase {
    /**
     * Checks if the given hand satisfies the West Wind Yaku.
     *
     * This Yaku is valid when a group in the hand contains West Wind tiles, and
     * the current round wind is also West Wind.
     *
     * @param hand the HandState, which contains the round wind and other contextual information.
     * @param handGrouping the HandGrouping of the hand, consisting of groups of tiles.
     * @return true if the hand satisfies the West Wind Yaku; false otherwise.
     */
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == MahjongTile.WEST_WIND &&
                    hand.roundWind() == MahjongTile.WEST_WIND) {
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
