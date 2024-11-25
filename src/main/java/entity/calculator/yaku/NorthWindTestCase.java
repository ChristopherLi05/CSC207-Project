package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public class NorthWindTestCase implements IYakuTestCase {
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


    @Override
    public int getHanValue() {
        return 1;
    }
}
