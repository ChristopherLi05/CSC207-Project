package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongSuit;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.yaku.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Static class to calculate hand values
 */
public class Calculator {
    private static final List<IYakuTestCase> yakuList = new ArrayList<IYakuTestCase>();

    /**
     * Calculates han value of hand
     * @param hand hand
     * @return han value
     */
    public static int calculateHan(HandState hand) {
        return 0;
    }

    /**
     * Calculates fu value of hand
     * @param hand hand
     * @return fu value
     */
    public static int calculateFu(HandState hand) {
        return 0;
    }

    /**
     * Calculates score of hand
     * @param hand hand
     * @return score value
     */
    public static int calculateScore(HandState hand) {
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
