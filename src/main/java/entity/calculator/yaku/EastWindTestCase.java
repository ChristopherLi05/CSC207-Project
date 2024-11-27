package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the East Wind Yaku test case.
 *
 * The East Wind Yaku is awarded when the hand contains a group of East Wind tiles
 * and the round wind is also East Wind. This class implements the logic to verify
 * the presence of this Yaku and provides its Han values for both closed and open hands.
 */
public class EastWindTestCase implements IYakuTestCase {
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == MahjongTile.EAST_WIND &&
                    hand.roundWind() == MahjongTile.EAST_WIND) {
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
