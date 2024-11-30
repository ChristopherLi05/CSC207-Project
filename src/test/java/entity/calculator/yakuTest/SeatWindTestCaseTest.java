package entity.calculator.yakuTest;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.yaku.SeatWindTestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatWindTestCaseTest {

    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final SeatWindTestCase seatWindTestCase = new SeatWindTestCase();

    @Test
    void testIsYaku_SeatWindPresentInGroup() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "ew", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));
        boolean result = seatWindTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected Seat Wind Yaku to be true when a group contains the seat wind.");
    }

    @Test
    void testIsYaku_SeatWindNotPresentInGroup() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "sw", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));
        boolean result = seatWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected Seat Wind Yaku to be false when no group contains the seat wind.");
    }

    @Test
    void testIsYaku_EmptyGroups() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "ew", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        boolean result = seatWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected Seat Wind Yaku to be false when there are no groups.");
    }

    @Test
    void testIsYaku_MultipleGroupsSeatWindPresent() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND}));
        boolean result = seatWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertTrue(result, "Expected Seat Wind Yaku to be true when at least one group contains the seat wind.");
    }

    @Test
    void testGetClosedHanValue() {
        // Act
        int closedHanValue = seatWindTestCase.getClosedHanValue();

        // Assert
        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for Seat Wind Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        // Act
        int openHanValue = seatWindTestCase.getOpenHanValue();

        // Assert
        assertEquals(1, openHanValue, "Expected open Han value to be 1 for Seat Wind Yaku.");
    }
}