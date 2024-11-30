package entity.calculator;

import entity.calculator.mahjong.MahjongTile;
import entity.calculator.yaku.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Static class to calculate hand values
 */
public class Calculator {
    private static final List<YakuTestCase> yakuList = new ArrayList<>();

    /**
     * Calculates han value of hand
     * @param hand hand
     * @return han value
     */
    public static int calculateHan(HandState hand) {
        int result = 0;
        if (hand.openGroups().isEmpty()) {
            for (YakuTestCase testCase : yakuList) {
                result += testCase.getClosedHanValue();
            }
        } else {
            for (YakuTestCase testCase : yakuList) {
                result += testCase.getOpenHanValue();
            }
        }
        return result;
    }

    /**
     * Calculates fu value of hand
     * @param hand hand
     * @return fu value
     */
    public static int calculateFu(HandState hand) { return 30; }

    /**
     * Calculates score of hand
     * @param hand hand
     * @return score value
     */
    public static int calculateScore(HandState hand) {
        int fu = calculateHan(hand);
        int basescore;
        if (fu==1) {
            basescore = 1000;
        } else if (fu==2) {
            basescore = 2000;
        } else if (fu==3) {
            basescore = 4000;
        } else if (fu==4 || fu==5) {
            basescore = 8000;
        } else if (fu==6 || fu==7) {
            basescore = 12000;
        } else if (fu==8 || fu==9 || fu==10) {
            basescore = 16000;
        } else if (fu==11 || fu==12) {
            basescore = 24000;
        } else {
            basescore = 32000;
        }
        if (hand.seatWind()==MahjongTile.EAST_WIND) {
            return (int) Math.round(basescore * 1.5);
        }
        return basescore;
    }

    static {
        // Initialize all of the yaku test cases here
        yakuList.add(new TanyaoTestCase());
        yakuList.add(new GreenDragonTestCase());
        yakuList.add(new WhiteDragonTestCase());
        yakuList.add(new RedDragonTestCase());
        yakuList.add(new NorthWindTestCase());
        yakuList.add(new SouthWindTestCase());
        yakuList.add(new WestWindTestCase());
        yakuList.add(new NorthWindTestCase());
        yakuList.add(new SeatWindTestCase());
        yakuList.add(new ChinnitsuTestCase());
    }
}
