package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WestWindTestCaseTest {

    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final WestWindTestCase westWindTestCase = new WestWindTestCase();

    @Test
    void testIsYaku_WestWindPresentInGroupAndRoundWind() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.WEST_WIND, MahjongTile.WEST_WIND, MahjongTile.WEST_WIND}));
        boolean result = westWindTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected West Wind Yaku to be true when WEST_WIND group exists and round wind is WEST_WIND.");
    }

    @Test
    void testIsYaku_WestWindPresentInGroupButNotRoundWind() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.WEST_WIND, MahjongTile.WEST_WIND, MahjongTile.WEST_WIND}));

        boolean result = westWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected West Wind Yaku to be false when round wind is not WEST_WIND.");
    }

    @Test
    void testIsYaku_NoWestWindInGroups() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND}));

        // Act
        boolean result = westWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected West Wind Yaku to be false when no group contains WEST_WIND.");
    }

    @Test
    void testIsYaku_EmptyGroups() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of());

        // Act
        boolean result = westWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected West Wind Yaku to be false when there are no groups.");
    }

    @Test
    void testGetClosedHanValue() {
        // Act
        int closedHanValue = westWindTestCase.getClosedHanValue();

        // Assert
        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for West Wind Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        // Act
        int openHanValue = westWindTestCase.getOpenHanValue();

        // Assert
        assertEquals(1, openHanValue, "Expected open Han value to be 1 for West Wind Yaku.");
    }
}
