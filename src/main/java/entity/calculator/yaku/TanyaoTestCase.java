package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public class TanyaoTestCase implements IYakuTestCase {
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

    @Override
    public int getClosedHanValue() {
        return 1;
    }

    @Override
    public int getOpenHanValue() { return 1; }
}
