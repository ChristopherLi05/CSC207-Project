package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

/**
 * Represents the Chinnitsu (Pure Suit) Yaku test case.
 *
 * Chinnitsu is a Yaku in Mahjong where all tiles in the hand belong to the same suit,
 * including the winning tile. This class implements the logic to verify the Chinnitsu
 * condition and provides its Han values for closed and open hands.
 */
public class ChinnitsuTestCase implements YakuTestCase {
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            for (MahjongTile tile : group.getTiles()) {
                if (tile.getSuit() != hand.winningTile().getSuit()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getClosedHanValue() { return 6; }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getOpenHanValue() { return 5; }
}
