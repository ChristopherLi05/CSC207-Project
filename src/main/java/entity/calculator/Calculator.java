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
        List<HandGrouping> handGroupings = createHandGroupings(hand);
        List<Integer> results = new ArrayList<>();
        for (HandGrouping handGrouping : handGroupings) {
            int result = 0;
            if (hand.openGroups().isEmpty()) {
                for (YakuTestCase testCase : yakuList) {
                    if (testCase.isYaku(hand, handGrouping)) {
                        result += testCase.getClosedHanValue();
                    }
                }
            } else {
                for (YakuTestCase testCase : yakuList) {
                    if (testCase.isYaku(hand, handGrouping)) {
                        result += testCase.getOpenHanValue();
                    }
                }
            }
            results.add(result);
        }
        return results.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    /**
     * Creates a list of possible HandGroupings from the given HandState.
     *
     * @param handState the HandState to process.
     * @return a list of possible HandGroupings.
     */
    public static List<HandGrouping> createHandGroupings(HandState handState) {
        List<HandGrouping> initialGroupings = CalculatorHelper.extractPairs(handState);

        if (initialGroupings == null) {
            return new ArrayList<>();
        }

        List<HandGrouping> allGroupings = new ArrayList<>();
        for (HandGrouping grouping : initialGroupings) {
            allGroupings.addAll(CalculatorHelper.extractGroup(grouping));
        }

        return allGroupings;
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
        int han = calculateHan(hand);
        int fu = calculateFu(hand);
        int basescore;
        if (fu == 30) {
            if (han==1) {
                basescore = 1000;
            } else if (han==2) {
                basescore = 2000;
            } else if (han==3) {
                basescore = 4000;
            } else if (han==4 || han==5) {
                basescore = 8000;
            } else if (han==6 || han==7) {
                basescore = 12000;
            } else if (han==8 || han==9 || han==10) {
                basescore = 16000;
            } else if (han==11 || han==12) {
                basescore = 24000;
            } else {
                basescore = 32000;
            }
            if (hand.seatWind()==MahjongTile.EAST_WIND) {
                return (int) Math.round(basescore * 1.5);
            }
            return basescore;
        }
        return 0;
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
