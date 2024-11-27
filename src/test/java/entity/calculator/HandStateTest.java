package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongSuit;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

class HandStateTest {
    @Test
    void testSerialization() {
        String serialization = "1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1";

        List<MahjongTile> closed = Arrays.asList(MahjongTile.ONE_SOU, MahjongTile.ONE_SOU, MahjongTile.TWO_SOU, MahjongTile.TWO_SOU, MahjongTile.THREE_SOU, MahjongTile.THREE_SOU, MahjongTile.SIX_SOU);
        List<MahjongGroup> closedGroup = List.of(new MahjongGroup(MahjongTile.FOUR_SOU, MahjongTile.FOUR_SOU, MahjongTile.FOUR_SOU, MahjongTile.FOUR_SOU));
        List<MahjongGroup> openGroup = List.of(new MahjongGroup(MahjongTile.FIVE_SOU, MahjongTile.FIVE_SOU, MahjongTile.FIVE_SOU));
        MahjongTile winning = MahjongTile.SIX_SOU;
        List<MahjongTile> dora = List.of(MahjongTile.NINE_MAN);
        List<MahjongTile> ura = List.of();
        MahjongTile seatWind = MahjongTile.WEST_WIND;
        MahjongTile roundWind = MahjongTile.EAST_WIND;

        HandState state = new HandState(closed, closedGroup, openGroup, winning, dora, ura, seatWind, roundWind, true, false, false, false, false, false, false, false, false);

        Assertions.assertEquals(serialization, state.serializeHand(), "Invalid Hand Serialization - Expected: " + serialization + " Received: " + state.serializeHand());
    }

    @Test
    void testFactoryDeserialize() {
        String serialization = "1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1";
        HandStateFactory factory = new HandStateFactory();
        HandState state = factory.createHandState(serialization);

        Assertions.assertEquals(serialization, state.serializeHand(), "Invalid Hand Deserialization - Expected: " + serialization + " Received: " + state.serializeHand());
    }

    @Test
    void testFilePaths() {
        for (MahjongTile tile : MahjongTile.values()) {
            File image = new File("src/main/resources", tile.getFilePath());
            Assertions.assertTrue(image.exists(), "File " + tile.getFilePath() + " does not exist.");
        }
    }

    @Test
    void testMahjongGroup() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND}));

        MahjongGroup group = new MahjongGroup(new MahjongTile[]{MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND});
        Assertions.assertEquals(3, group.getTiles().length);

        group = new MahjongGroup(MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND);
        Assertions.assertEquals(3, group.getTiles().length);

        group = new MahjongGroup(MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND, MahjongTile.EAST_WIND);
        Assertions.assertEquals(4, group.getTiles().length);
        Assertions.assertEquals("ewewewew", group.getSerialization());
        Assertions.assertEquals("MahjongGroup(ewewewew)", group.toString());

        Assertions.assertEquals(MahjongTile.EAST_WIND, group.getTile(0));
        group.setTile(0, MahjongTile.WEST_WIND);
        Assertions.assertEquals(MahjongTile.WEST_WIND, group.getTile(0));
    }

    @Test
    void testMahjongSuit() {
        Assertions.assertTrue(MahjongSuit.WIND.isHonor());
        Assertions.assertEquals(4, MahjongSuit.WIND.getSort());
    }

    @Test
    void testMahjongTile() {
        Assertions.assertEquals(1, MahjongTile.ONE_MAN.getValue());
        Assertions.assertEquals(MahjongSuit.MAN, MahjongTile.ONE_MAN.getSuit());
        Assertions.assertTrue(MahjongTile.ONE_MAN.isTerminal());
        Assertions.assertFalse(MahjongTile.ONE_MAN.isAka());

        Assertions.assertNull(MahjongTile.getMahjongTile(0, MahjongSuit.MAN, false));
        Assertions.assertEquals(MahjongTile.RED_FIVE_MAN, MahjongTile.getMahjongTile(5, MahjongSuit.MAN, true));

        Assertions.assertNull(MahjongTile.getMahjongTile("11"));
    }
}
