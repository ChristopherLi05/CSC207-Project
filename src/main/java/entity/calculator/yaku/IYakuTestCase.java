package entity.calculator.yaku;

import entity.calculator.HandState;

public interface IYakuTestCase {
    boolean isYaku(HandState hand);

    int getHanValue();
}
