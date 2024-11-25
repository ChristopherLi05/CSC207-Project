package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public class GreenDragonTestCase implements IYakuTestCase {
    @Override
    public boolean isYaku(HandState hand, HandGrouping handGrouping) {
        for (MahjongGroup group : handGrouping.getGroups()) {
            if (group.getTile(0) == MahjongTile.GREEN_DRAGON) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int getClosedHanValue() {
        return 1;
    }

    @Override
    public int getOpenHanValue() { return 1; }
}
