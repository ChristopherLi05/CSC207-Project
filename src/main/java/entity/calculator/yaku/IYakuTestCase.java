package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;

/**
 * Interface of all YakuTestCases; defines the contract for evaluating and scoring specific Mahjong Yaku.
 *
 * Implementations of this interface are responsible for checking if a hand satisfies
 * a specific Yaku (a scoring pattern in Mahjong) and for providing the corresponding
 * Han values for both closed and open hands.
 */
public interface IYakuTestCase {
    /**
     * Determines whether the given hand satisfies the specific Yaku.
     *
     * @param hand the HandState representing the state of the hand and game,
     *             including the winning tile and other contextual information.
     * @param handGrouping the HandGrouping containing the structured groups
     *                      of the hand including closed groups and other details.
     * @return true if the hand satisfies the specific Yaku; false otherwise.
     */
    boolean isYaku(HandState hand, HandGrouping handGrouping);

    /**
     * Returns the Han value of the specific Yaku when the hand is closed (concealed).
     *
     * @return the Han value for a closed hand.
     */
    int getClosedHanValue();

    /**
     * Returns the Han value of the specific Yaku when the hand is open.
     *
     * @return the Han value for an open hand.
     */
    int getOpenHanValue();
}
