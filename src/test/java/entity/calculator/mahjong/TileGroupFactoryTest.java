package entity.calculator.mahjong;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TileGroupFactoryTest {
    private final TileGroupFactory factory = new TileGroupFactory();


    @Test
    void testAddChiiWithValidInput() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.addChii(tile, false);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertEquals(tile, group.getTiles()[0]);
    }

    @Test
    void testAddChiiWithAka() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.addChii(tile, true);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertTrue(group.getTiles()[2].isAka());
    }

    @Test
    void testAddChiiWithInvalidCase() {
        MahjongTile tile = MahjongTile.EIGHT_MAN;
        assertNull(factory.addChii(tile, false));
    }

    @Test
    void testAddPonWithAka() {
        MahjongTile tile = MahjongTile.RED_FIVE_PIN;
        MahjongGroup group = factory.addPon(tile, false);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertEquals(tile, group.getTiles()[0]);
    }

    @Test
    void testAddPonWithAkaRequested() {
        MahjongTile tile = MahjongTile.FIVE_PIN;
        MahjongGroup group = factory.addPon(tile, true);

        assertNotNull(group);
        assertEquals(3, group.getTiles().length);
        assertTrue(group.getTiles()[0].isAka());
    }

    @Test
    void testAddPon() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        MahjongGroup group = factory.addPon(tile, false);

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