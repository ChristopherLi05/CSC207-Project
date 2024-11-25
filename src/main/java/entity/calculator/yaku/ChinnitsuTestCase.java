package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public class ChinnitsuTestCase implements IYakuTestCase {
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


    @Override
    public int getClosedHanValue() { return 6; }

    @Override
    public int getOpenHanValue() { return 5; }
}
