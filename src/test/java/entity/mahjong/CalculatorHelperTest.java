package entity.mahjong;

import entity.calculator.CalculatorHelper;
import entity.calculator.HandGrouping;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorHelperTest {
    @Test
    void testExtractPairs_withValidPairs() {
        String serialization = "2s2s2s3s3s3s5s 4s4s4s;1s1s1s1s 5s";
        HandStateFactory factory = new HandStateFactory();
        HandState state = factory.createHandState(serialization);

        List<HandGrouping> result = CalculatorHelper.extractPairs(state);

        assertNotNull(result, "Result should not be null when pairs exist");
        assertEquals(1, result.size(), "Result should contain 1 pair");

        HandGrouping group = result.get(0);
        assertEquals(result.get(0).getGroups().get(0), result.get(0).getGroups().get(1), "The group should correctly identify the pair");
    }
}
