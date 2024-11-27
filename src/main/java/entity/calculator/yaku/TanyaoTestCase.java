package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the Tanyao (All Simples) Yaku test case.
 *
 * The Tanyao Yaku is awarded when the hand contains only simple tiles, meaning
 * all tiles in the hand must have a value between 2 and 8 (inclusive), and no
 * terminal (1 or 9) or honor tiles (winds or dragons) are allowed. This class
 * implements the logic to check for this Yaku and provides the Han values for
 * both closed and open hands.
 */
public class TanyaoTestCase implements IYakuTestCase {
    /**
     * Checks if the given hand satisfies the Tanyao Yaku.
     *
     * This Yaku is valid if all tiles in the hand, including the pair, have a value
     * between 2 and 8 (inclusive), and the hand does not contain any terminal
     * (1 or 9) or honor tiles (winds or dragons).
     *
     * @param hand the HandState, which contains the contextual information of the hand.
     * @param handGrouping the HandGrouping of the hand, consisting of groups of tiles and the pair.
     * @return true if the hand satisfies the Tanyao Yaku; false otherwise.
     */
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            for (MahjongTile mahjongTile : group.getTiles()) {
                if (mahjongTile.getValue()<2 || mahjongTile.getValue()>8) {
                    return false;
                }
            }
        }
        for (MahjongTile tile : handGrouping.getPair()) {
            if (tile.getValue()<2 || tile.getValue()>8) {
                return false;
            }
        }
        return true;
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
