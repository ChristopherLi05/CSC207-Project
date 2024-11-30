package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.component.TileSelectorComponentState;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddTileUseCaseTest {

    private AddTileInteractor addTileInteractor;
    private TestOutputBoundary testOutputBoundary;

    @BeforeEach
    void setUp() {
        testOutputBoundary = new TestOutputBoundary();
        addTileInteractor = new AddTileInteractor(testOutputBoundary);
    }

    @Test
    void testAddSingleTileCase() {
        MahjongTile tile = MahjongTile.ONE_MAN;
        AddTileInputData inputData = new AddTileInputData(tile, false, TileSelectorComponentState.SelectorType.NONE);

        addTileInteractor.execute(inputData);

        List<MahjongTile> addedTiles = testOutputBoundary.getOutputData().getAddedTile();
        assertEquals(1, addedTiles.size());
        assertEquals(tile, addedTiles.get(0));
    }

    @Test
    void testAddChiiGroupWithTileValueSevenCase() {
        MahjongTile tile = MahjongTile.SEVEN_MAN;
        AddTileInputData inputData = new AddTileInputData(tile, false, TileSelectorComponentState.SelectorType.CHII);

        addTileInteractor.execute(inputData);

        List<MahjongGroup> openGroups = testOutputBoundary.getOutputData().getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        assertEquals(3, openGroups.get(0).getTiles().length);
    }

    @Test
    void testAddChiiGroupWithAkaTileCase() {
        MahjongTile tile = MahjongTile.FIVE_PIN;
        AddTileInputData inputData = new AddTileInputData(tile, true, TileSelectorComponentState.SelectorType.CHII);

        addTileInteractor.execute(inputData);

        List<MahjongGroup> openGroups = testOutputBoundary.getOutputData().getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        MahjongTile[] tiles = openGroups.get(0).getTiles();
        assertEquals(tile, tiles[0]);
    }

    @Test
    void testAddPonGroupWithAkaTileCase() {
        MahjongTile tile = MahjongTile.RED_FIVE_PIN;
        AddTileInputData inputData = new AddTileInputData(tile, true, TileSelectorComponentState.SelectorType.PON);

        addTileInteractor.execute(inputData);

        List<MahjongGroup> openGroups = testOutputBoundary.getOutputData().getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        MahjongTile[] tiles = openGroups.get(0).getTiles();
        assertEquals(tile, tiles[0]);
    }

    @Test
    void testAddPonGroupWitNonAkaTileCase() {
        MahjongTile tile = MahjongTile.FOUR_SOU;
        AddTileInputData inputData = new AddTileInputData(tile, false, TileSelectorComponentState.SelectorType.PON);

        addTileInteractor.execute(inputData);

        List<MahjongGroup> openGroups = testOutputBoundary.getOutputData().getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        MahjongTile[] tiles = openGroups.get(0).getTiles();
        assertEquals(tile, tiles[0]);
    }

    @Test
    void testAddClosedKanGroupWithAkaTileCase() {
        MahjongTile tile = MahjongTile.RED_FIVE_MAN;
        AddTileInputData inputData = new AddTileInputData(tile, true, TileSelectorComponentState.SelectorType.CLOSED_KAN);

        addTileInteractor.execute(inputData);

        List<MahjongGroup> closedGroups = testOutputBoundary.getOutputData().getAddedClosedGroup();
        assertEquals(1, closedGroups.size());
        assertEquals(4, closedGroups.get(0).getTiles().length);
    }

    @Test
    void testAddOpenKanGroupWithNonAkaTilCasee() {
        MahjongTile tile = MahjongTile.FOUR_SOU;
        AddTileInputData inputData = new AddTileInputData(tile, false, TileSelectorComponentState.SelectorType.OPEN_KAN);

        AddTileOutputData data = addTileInteractor.addTiles(inputData);

        List<MahjongGroup> openGroups = data.getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        assertEquals(4, openGroups.get(0).getTiles().length);
    }

    @Test
    void testAddOpenKanGroupWithAkaTileCase() {
        MahjongTile tile = MahjongTile.FIVE_SOU;
        AddTileInputData inputData = new AddTileInputData(tile, false, TileSelectorComponentState.SelectorType.OPEN_KAN);

        AddTileOutputData data = addTileInteractor.addTiles(inputData);

        List<MahjongGroup> openGroups = data.getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        assertEquals(4, openGroups.get(0).getTiles().length);
    }

    @Test
    void testAddChiiGroup() {
        MahjongTile tile = MahjongTile.THREE_MAN;
        AddTileInputData inputData = new AddTileInputData(tile, false, TileSelectorComponentState.SelectorType.CHII);

        addTileInteractor.execute(inputData);

        List<MahjongGroup> openGroups = testOutputBoundary.getOutputData().getAddedOpenGroup();
        assertEquals(1, openGroups.size());
        assertNotNull(openGroups.get(0));
        assertEquals(3, openGroups.get(0).getTiles().length);
    }


    @Test
    void testAddChiiGroupWithInvalidInput() {
        MahjongTile tile = MahjongTile.EIGHT_MAN;
        MahjongGroup result = addTileInteractor.addChii(tile, false);

        assertNull(result);
    }

    @Test
    void testAddChiiGroupWithTileValueFourAndAka() {
        MahjongTile tile = MahjongTile.FOUR_MAN;
        MahjongGroup result = addTileInteractor.addChii(tile, true);

        assertNotNull(result);
        MahjongTile[] tiles = result.getTiles();
        assertEquals(3, tiles.length);
        assertEquals(tile, tiles[0]);
        assertTrue(tiles[1].isAka());
        assertFalse(tiles[2].isAka());
    }

    @Test
    void testAddPonGroupWithValueFiveAndAka() {
        MahjongTile tile = MahjongTile.FIVE_MAN;
        MahjongGroup result = addTileInteractor.addPon(tile, true);

        assertNotNull(result);
        MahjongTile[] tiles = result.getTiles();
        assertEquals(3, tiles.length);
        assertTrue(tiles[0].isAka());
        assertFalse(tiles[1].isAka());
        assertFalse(tiles[2].isAka());
    }

    @Test
    void testCreateKanGroupWithValueFiveAndAka() {
        MahjongTile tile = MahjongTile.FIVE_PIN;
        MahjongGroup result = addTileInteractor.createKanGroup(tile, true);

        assertNotNull(result);
        MahjongTile[] tiles = result.getTiles();
        assertEquals(4, tiles.length);
        assertTrue(tiles[0].isAka());
        assertFalse(tiles[1].isAka());
        assertFalse(tiles[2].isAka());
        assertFalse(tiles[3].isAka());
    }

    private static class TestOutputBoundary implements AddTileOutputBoundary {
        private AddTileOutputData outputData;

        @Override
        public void present(AddTileOutputData outputData) {
            this.outputData = outputData;
        }

        public AddTileOutputData getOutputData() {
            return outputData;
        }
    }

}