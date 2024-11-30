package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
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

    @Test
    void testCalculateHan_OpenHand() {
        List<MahjongGroup> closedgroup = new ArrayList<>();
        closedgroup.add(new MahjongGroup(MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND));
        closedgroup.add(new MahjongGroup(MahjongTile.ONE_SOU, MahjongTile.ONE_SOU, MahjongTile.ONE_SOU));
        closedgroup.add(new MahjongGroup(MahjongTile.TWO_SOU, MahjongTile.THREE_SOU, MahjongTile.FOUR_SOU));
        closedgroup.add(new MahjongGroup(MahjongTile.NINE_SOU, MahjongTile.NINE_SOU, MahjongTile.NINE_SOU));
        List<MahjongTile> closedtiles = new ArrayList<>();
        closedtiles.add(MahjongTile.NORTH_WIND);

        HandState handState = new HandState(
                closedtiles,
                closedgroup,
                new ArrayList<>(),
                MahjongTile.NORTH_WIND,
                new ArrayList<>(),  new ArrayList<>(), MahjongTile.WEST_WIND, MahjongTile.WEST_WIND,
                true, false, false, false,
                false, false, false, false, false
        );

        int hanValue = Calculator.calculateHan(handState);
        Assertions.assertEquals(0, hanValue);
    }

    @Test
    void testCalculateFu() {
        // Create a hand to test Fu calculation
        List<MahjongTile> closedTiles = new ArrayList<>();
        closedTiles.add(MahjongTile.ONE_SOU);
        closedTiles.add(MahjongTile.ONE_SOU);

        HandState handState = new HandState(
                closedTiles,
                new ArrayList<>(),
                new ArrayList<>(),
                MahjongTile.FOUR_SOU,
                null, null, null, null,
                false, false, false, false,
                false, false, false, false, false
        );

        // Fu value is constant in this implementation
        int fuValue = Calculator.calculateFu(handState);
        Assertions.assertEquals(30, fuValue);
    }

}
