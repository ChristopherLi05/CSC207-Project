package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EastWindTestCaseTest {

    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final EastWindTestCase eastWindTestCase = new EastWindTestCase();

    @Test
    void testIsYaku_EastWindPresentInGroupAndRoundWind() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "ew", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));
        boolean result = eastWindTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected East Wind Yaku to be true when EAST_WIND group exists and round wind is EAST_WIND.");
    }

    @Test
    void testIsYaku_EastWindPresentInGroupButNotRoundWind() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));

        boolean result = eastWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected East Wind Yaku to be false when round wind is not EAST_WIND.");
    }

    @Test
    void testIsYaku_NoEastWindInGroups() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "ew", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND}));

        // Act
        boolean result = eastWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected East Wind Yaku to be false when no group contains EAST_WIND.");
    }

    @Test
    void testIsYaku_EmptyGroups() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "ew", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of());

        // Act
        boolean result = eastWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected East Wind Yaku to be false when there are no groups.");
    }

    @Test
    void testGetClosedHanValue() {
        // Act
        int closedHanValue = eastWindTestCase.getClosedHanValue();

        // Assert
        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for East Wind Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        // Act
        int openHanValue = eastWindTestCase.getOpenHanValue();

        // Assert
        assertEquals(1, openHanValue, "Expected open Han value to be 1 for East Wind Yaku.");
    }
}
