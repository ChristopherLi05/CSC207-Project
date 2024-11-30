package entity.calculator.mahjong;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TileGroupFactoryTest {
    private final TileGroupFactory factory = new TileGroupFactory();


    @Test
    void testCreateChiiGroupWithValidInput() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.createChiiGroup(tile, false);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertEquals(tile, group.getTiles()[0]);
    }

    @Test
    void testCreateChiiGroupWithAka() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.createChiiGroup(tile, true);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertTrue(group.getTiles()[2].isAka());
    }

    @Test
    void testCreateChiiGroupWithInvalidCase() {
        MahjongTile tile = MahjongTile.EIGHT_MAN;
        assertNull(factory.createChiiGroup(tile, false));
    }

    @Test
    void testCreatePonGroupWithAka() {
        MahjongTile tile = MahjongTile.RED_FIVE_PIN;
        MahjongGroup group = factory.createPonGroup(tile, false);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertEquals(tile, group.getTiles()[0]);
    }

    @Test
    void testCreatePonGroupWithAkaRequested() {
        MahjongTile tile = MahjongTile.FIVE_PIN;
        MahjongGroup group = factory.createPonGroup(tile, true);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertTrue(group.getTiles()[0].isAka());
    }

    @Test
    void testCreatePonGroup() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.createPonGroup(tile, false);

        assertNotNull(group);
        for (MahjongTile t : group.getTiles()) {
            assertEquals(tile, t);
        }
    }

    @Test
    void testCreateKanGroupWithAka() {
        MahjongTile tile = MahjongTile.RED_FIVE_MAN;
        MahjongGroup group = factory.createKanGroup(tile, false);

        assertNotNull(group);
        assertEquals(4, group.getTiles().length);
        assertEquals(tile, group.getTiles()[0]);
    }

    @Test
    void testCreateKanGroupWithAkaRequested() {
        MahjongTile tile = MahjongTile.FIVE_MAN;
        MahjongGroup group = factory.createKanGroup(tile, true);

        assertNotNull(group);
        assertEquals(4, group.getTiles().length);
        assertTrue(group.getTiles()[0].isAka());
    }

    @Test
    void testCreateKanGroup() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.createKanGroup(tile, false);

        assertNotNull(group);
        for (MahjongTile t : group.getTiles()) {
            assertEquals(tile, t);
        }
    }
}