package entity.calculator.yakuTest;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.yaku.NorthWindTestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NorthWindTestCaseTest {

    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final NorthWindTestCase northWindTestCase = new NorthWindTestCase();

    @Test
    void testIsYaku_NorthWindPresentInGroupAndRoundWind() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "nw", "nw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.NORTH_WIND, MahjongTile.NORTH_WIND, MahjongTile.NORTH_WIND}));
        boolean result = northWindTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected North Wind Yaku to be true when NORTH_WIND group exists and round wind is NORTH_WIND.");
    }

    @Test
    void testIsYaku_NorthWindPresentInGroupButNotRoundWind() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.NORTH_WIND, MahjongTile.NORTH_WIND, MahjongTile.NORTH_WIND}));
        boolean result = northWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected North Wind Yaku to be false when round wind is not NORTH_WIND.");
    }

    @Test
    void testIsYaku_NoNorthWindInGroups() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "nw", "nw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));
        boolean result = northWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected North Wind Yaku to be false when no group contains NORTH_WIND.");
    }

    @Test
    void testIsYaku_EmptyGroups() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "nw", "nw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of());

        boolean result = northWindTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected North Wind Yaku to be false when there are no groups.");
    }

    @Test
    void testGetClosedHanValue() {
        // Act
        int closedHanValue = northWindTestCase.getClosedHanValue();

        // Assert
        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for North Wind Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        // Act
        int openHanValue = northWindTestCase.getOpenHanValue();

        // Assert
        assertEquals(1, openHanValue, "Expected open Han value to be 1 for North Wind Yaku.");
    }
}
