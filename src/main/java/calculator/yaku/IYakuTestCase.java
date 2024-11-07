package calculator.yaku;

import calculator.HandState;

public interface IYakuTestCase {
    boolean isYaku(HandState hand);

    int getHanValue();
}
