package mahjong;

import calculator.HandState;
import calculator.HandStateFactory;
import calculator.mahjong.MahjongGroup;
import calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(serialization, state.serializeHand(), "Invalid Hand Serialization - Expected: " + serialization + " Received: " + state.serializeHand());
    }

    @Test
    void testFactoryDeserialize() {
        String serialization = "1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1";
        HandStateFactory factory = new HandStateFactory();
        HandState state = factory.createHandState(serialization);

        assertEquals(serialization, state.serializeHand(), "Invalid Hand Deserialization - Expected: " + serialization + " Received: " + state.serializeHand());
    }
}
