package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

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


    @Override
    public int getHanValue() {
        return 1;
    }
}
