package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;

public interface IYakuTestCase {
    boolean isYaku(HandState hand, HandGrouping handGrouping);

    int getHanValue();
}
