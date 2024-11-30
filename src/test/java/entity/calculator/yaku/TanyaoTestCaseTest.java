package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TanyaoTestCaseTest {
    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final TanyaoTestCase tanyaoTestCase = new TanyaoTestCase();

//    @Test
//    void testIsYaku_AllTilesBetween2And8() {
//        HandState handState = handStateFactory.createHandState(
//                "", "", "", "1p", "", "", "ww", "ww", 0
//        );
//        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_PIN}));
//        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU}));
//        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
//        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));
//        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_PIN, MahjongTile.EIGHT_PIN, MahjongTile.NINE_PIN}));
//
//        boolean result = tanyaoTestCase.isYaku(handState, handGrouping);
//
//        assertFalse(result, "Expected Tanyao Yaku to be false when the pair is has a value outside of 2-8 range.");
//    }

    @Test
    void testIsYaku_PairOutside2To8() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.THREE_SOU, MahjongTile.FOUR_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.SEVEN_SOU, MahjongTile.SEVEN_SOU}));
        handGrouping.setPair(MahjongTile.ONE_SOU, MahjongTile.ONE_SOU);
        boolean result = tanyaoTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected Tanyao Yaku to be false when there are tiles outside the 2-8 range.");
    }

    @Test
    void testIsYaku_TileOutside2To8() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.TWO_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_PIN, MahjongTile.EIGHT_PIN, MahjongTile.NINE_PIN}));

        boolean result = tanyaoTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected Tanyao Yaku to be false when there are tiles outside the 2-8 range.");
    }

//    @Test
//    void testIsYaku_EmptyGroups() {
//        HandState handState = handStateFactory.createHandState(
//                "", "", "", "1s", "", "", "ww", "ww", 0
//        );
//        HandGrouping handGrouping = new HandGrouping(List.of());
//
//        boolean result = chinnitsuTestCase.isYaku(handState, handGrouping);
//
//        assertTrue(result, "Expected Chinnitsu Yaku to be true for an empty group, as there are no invalid tiles.");
//    }

    @Test
    void testIsYaku_MixedTileValues() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "1p", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_PIN}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.FOUR_SOU, MahjongTile.FIVE_SOU, MahjongTile.SIX_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_SOU, MahjongTile.EIGHT_SOU, MahjongTile.NINE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SEVEN_PIN, MahjongTile.EIGHT_PIN, MahjongTile.NINE_PIN}));

        boolean result = tanyaoTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected Tanyao Yaku to be false when the pair is has a value outside of 2-8 range.");
    }

    @Test
    void testGetClosedHanValue() {
        int closedHanValue = tanyaoTestCase.getClosedHanValue();

        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for Tanyao Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        int openHanValue = tanyaoTestCase.getOpenHanValue();

        assertEquals(1, openHanValue, "Expected open Han value to be 1 for Tanyao Yaku.");
    }
}

