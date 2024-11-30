package entity.calculator.yaku;

import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhiteDragonTestCaseTest {

    private final HandStateFactory handStateFactory = new HandStateFactory();
    private final WhiteDragonTestCase whiteDragonTestCase = new WhiteDragonTestCase();

    @Test
    void testIsYaku_WhiteDragonPresentInGroup() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.WHITE_DRAGON, MahjongTile.WHITE_DRAGON, MahjongTile.WHITE_DRAGON}));
        boolean result = whiteDragonTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected White Dragon Yaku to be true when a group contains the White Dragon.");
    }

    @Test
    void testIsYaku_WhiteDragonNotPresentInGroup() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ew", "sw", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.GREEN_DRAGON, MahjongTile.GREEN_DRAGON, MahjongTile.GREEN_DRAGON}));

        boolean result = whiteDragonTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected White Dragon Yaku to be false when no group contains the White Dragon.");
    }

    @Test
    void testIsYaku_NoGroups() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));

        boolean result = whiteDragonTestCase.isYaku(handState, handGrouping);

        assertFalse(result, "Expected White Dragon Yaku to be false when there are no groups.");
    }

    @Test
    void testIsYaku_MultipleGroupsWhiteDragonPresent() {
        HandState handState = handStateFactory.createHandState(
                "", "", "", "2s", "", "", "ww", "ww", 0
        );
        HandGrouping handGrouping = new HandGrouping(List.of(new MahjongTile[]{MahjongTile.ONE_SOU, MahjongTile.THREE_SOU}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.WHITE_DRAGON, MahjongTile.WHITE_DRAGON, MahjongTile.WHITE_DRAGON}));
        handGrouping.addGroup(new MahjongGroup(new MahjongTile[]{MahjongTile.GREEN_DRAGON, MahjongTile.GREEN_DRAGON, MahjongTile.GREEN_DRAGON}));

        boolean result = whiteDragonTestCase.isYaku(handState, handGrouping);

        assertTrue(result, "Expected White Dragon Yaku to be true when at least one group contains the White Dragon.");
    }

    @Test
    void testGetClosedHanValue() {
        // Act
        int closedHanValue = whiteDragonTestCase.getClosedHanValue();

        // Assert
        assertEquals(1, closedHanValue, "Expected closed Han value to be 1 for White Dragon Yaku.");
    }

    @Test
    void testGetOpenHanValue() {
        // Act
        int openHanValue = whiteDragonTestCase.getOpenHanValue();

        // Assert
        assertEquals(1, openHanValue, "Expected open Han value to be 1 for White Dragon Yaku.");
    }
}
