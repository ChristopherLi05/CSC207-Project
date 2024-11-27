package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the North Wind Yaku test case.
 *
 * The North Wind Yaku is awarded when the hand contains a group of North Wind tiles
 * and the round wind is also North Wind. This class implements the logic to verify
 * the presence of this Yaku and provides its Han values for both closed and open hands.
 */
public class NorthWindTestCase implements IYakuTestCase {
    /**
     * Checks if the given hand satisfies the North Wind Yaku.
     *
     * This Yaku is valid when a group in the hand contains North Wind tiles, and
     * the current round wind is also North Wind.
     *
     * @param hand the HandState, which contains the round wind and other contextual information.
     * @param handGrouping the HandGrouping of the hand, consisting of groups of tiles.
     * @return true if the hand satisfies the North Wind Yaku; false otherwise.
     */
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == MahjongTile.NORTH_WIND &&
                    hand.roundWind() == MahjongTile.NORTH_WIND) {
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
