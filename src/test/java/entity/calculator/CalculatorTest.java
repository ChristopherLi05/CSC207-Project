package entity.calculator;

import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    @Test
    void testExtractPairsPairs() {
        List<MahjongTile> closedTiles = new ArrayList<>();
        closedTiles.add(MahjongTile.ONE_SOU);
        closedTiles.add(MahjongTile.ONE_SOU);
        closedTiles.add(MahjongTile.TWO_SOU);
        closedTiles.add(MahjongTile.THREE_SOU);

        HandState handState = new HandState(closedTiles, new ArrayList<>(), new ArrayList<>(), MahjongTile.FOUR_SOU, null, null, null, null, false, false, false, false, false, false, false, false, false);
        List<HandGrouping> result = CalculatorHelper.extractPairs(handState);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void testExtractPairsNoPairs() {
        List<MahjongTile> closedTiles = new ArrayList<>();
        closedTiles.add(MahjongTile.ONE_SOU);
        closedTiles.add(MahjongTile.TWO_SOU);
        closedTiles.add(MahjongTile.THREE_SOU);

        HandState handState = new HandState(closedTiles, new ArrayList<>(), new ArrayList<>(), MahjongTile.FOUR_SOU, null, null, null, null, false, false, false, false, false, false, false, false, false);
        List<HandGrouping> result = CalculatorHelper.extractPairs(handState);
        Assertions.assertNull(result);
    }

    @Test
    void testGroupings() {
        List<MahjongTile> tiles = new ArrayList<>();
        tiles.add(MahjongTile.ONE_SOU);
        tiles.add(MahjongTile.TWO_SOU);
        tiles.add(MahjongTile.THREE_SOU);
        tiles.add(MahjongTile.FOUR_SOU);
        tiles.add(MahjongTile.FOUR_SOU);
        tiles.add(MahjongTile.FOUR_SOU);
        tiles.add(MahjongTile.FOUR_PIN);
        tiles.add(MahjongTile.FOUR_PIN);
        tiles.add(MahjongTile.FOUR_PIN);

        HandGrouping grouping = new HandGrouping(tiles);
        grouping.setPair(MahjongTile.EAST_WIND, MahjongTile.EAST_WIND);
        List<HandGrouping> groups = CalculatorHelper.extractGroup(grouping);

        Assertions.assertEquals(1, groups.size());
    }

    @Test
    void testHandGrouping() {
        List<MahjongTile> tiles = new ArrayList<>();
//        tiles.add(MahjongTile.ONE_SOU);
//        tiles.add(MahjongTile.TWO_SOU);
//        tiles.add(MahjongTile.THREE_SOU);

        HandGrouping grouping = new HandGrouping(tiles);
        grouping.setPair(MahjongTile.EAST_WIND, MahjongTile.EAST_WIND);

        Assertions.assertEquals(MahjongTile.EAST_WIND, grouping.getPair()[0]);
        Assertions.assertEquals(0, grouping.getGroups().size());
        Assertions.assertNull(grouping.getFirstTile());
    }
}
