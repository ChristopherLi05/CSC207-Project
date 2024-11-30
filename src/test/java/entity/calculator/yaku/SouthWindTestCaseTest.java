package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SouthWindTestCaseTest {

    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final SouthWindTestCase southWindTestCase = new SouthWindTestCase();

    @Test
    void testIsYaku_SouthWindPresentInGroupAndRoundWind() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "sw", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND}));
        boolean result = southWindTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected South Wind Yaku to be true when SOUTH_WIND group exists and round wind is SOUTH_WIND.");
    }

    @Test
    void testIsYaku_SouthWindPresentInGroupButNotRoundWind() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "ew", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND, MahjongTile.SOUTH_WIND}));

        boolean result = southWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected South Wind Yaku to be false when round wind is not SOUTH_WIND.");
    }

    @Test
    void testIsYaku_NoSouthWindInGroups() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "sw", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));

        // Act
        boolean result = southWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected South Wind Yaku to be false when no group contains SOUTH_WIND.");
    }

    @Test
    void testIsYaku_EmptyGroups() {
        // Arrange
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "sw", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of());

        // Act
        boolean result = southWindTestCase.isYaku(handState, handGrouping);

        // Assert
        assertFalse(result, "Expected South Wind Yaku to be false when there are no groups.");
    }

    @Test
    void testGetClosedHanValue() {
        // Act
        int closedHanValue = southWindTestCase.getClosedHanValue();

        // Assert
        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for South Wind Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        // Act
        int openHanValue = southWindTestCase.getOpenHanValue();

        // Assert
        assertEquals(1, openHanValue, "Expected open Han value to be 1 for South Wind Yaku.");
    }
}
