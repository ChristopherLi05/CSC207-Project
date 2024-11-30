package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;

/**
 * Represents the Seat Wind Yaku test case.
 *
 * The Seat Wind Yaku is awarded when the hand contains a group of tiles that match
 * the player's seat wind. This class implements the logic to verify the presence
 * of this Yaku and provides its Han values for both closed and open hands.
 */
public class SeatWindTestCase implements YakuTestCase {
    /**
     * Checks if the given hand satisfies the Seat Wind Yaku.
     *
     * This Yaku is valid when a group in the hand contains tiles that match the player's
     * seat wind as specified in the HandState.
     *
     * @param hand the HandState, which contains the seat wind and other contextual information.
     * @param handGrouping the handGrouping of the hand, consisting of groups of tiles.
     * @return true if the hand satisfies the Seat Wind Yaku; false otherwise.
     */
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == hand.seatWind()) {
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
