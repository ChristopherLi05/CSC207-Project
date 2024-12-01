package entity.calculator.yaku;

import entity.calculator.Calculator;
import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChinnitsuTestCaseTest {
    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final ChinnitsuTestCase chinnitsuTestCase = new ChinnitsuTestCase();

    @Test
    void testIsYaku_AllTilesSameSuit() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "1s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));

        boolean result = chinnitsuTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected Chinnitsu Yaku to be true when all tiles are of the same suit.");
    }

    @Test
    void testIsYaku_MixedSuits() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "1s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_PIN, MahjongTile.EIGHT_PIN, MahjongTile.NINE_PIN}));

        boolean result = chinnitsuTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected Chinnitsu Yaku to be false when tiles are of mixed suits.");
    }

    @Test
    void testIsYaku_EmptyGroups() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "1s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of());

        boolean result = chinnitsuTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected Chinnitsu Yaku to be true for an empty group, as there are no invalid tiles.");
    }

    @Test
    void testIsYaku_AllTilesSameSuitWithWinningTileDifferent() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "1p", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_PIN}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_PIN, MahjongTile.EIGHT_PIN, MahjongTile.NINE_PIN}));

        boolean result = chinnitsuTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected Chinnitsu Yaku to be false when the winning tile suit is different from other tiles.");
    }

    @Test
    void testGetClosedHanValue() {
        int closedHanValue = chinnitsuTestCase.getClosedHanValue();

        assertEquals(6, closedHanValue, "Expected closed Han value to be 6 for Chinnitsu Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        int openHanValue = chinnitsuTestCase.getOpenHanValue();

        assertEquals(5, openHanValue, "Expected open Han value to be 5 for Chinnitsu Yaku.");
    }

    @Test
    void testDragonHand() {
        HandState handState = new HandState(
                List.of(MahjongTile.GREEN_DRAGON),
                new ArrayList<>(),
                List.of(new MahjongGroup(MahjongTile.WHITE_DRAGON, MahjongTile.WHITE_DRAGON, MahjongTile.WHITE_DRAGON)),
                MahjongTile.GREEN_DRAGON,
                new ArrayList<>(), new ArrayList<>(), MahjongTile.WEST_WIND, MahjongTile.WEST_WIND,
                true, false, false, false,
                false, false, false, false, false
        );
        Assertions.assertFalse(chinnitsuTestCase.isYaku(handState, Calculator.createHandGroupings(handState).get(0)));
    }
}
