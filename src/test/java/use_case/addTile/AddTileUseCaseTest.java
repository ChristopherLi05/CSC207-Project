package use_case.addTile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.mahjong.MahjongGroup;
import view.component.ITileSelectorComponentState;
import java.util.ArrayList;
import java.util.List;

class AddTileUseCaseTest {
    private AddTileInteractor interactor;
    private TestAddTileOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        outputBoundary = new TestAddTileOutputBoundary();
        interactor = new AddTileInteractor(outputBoundary);
    }

    @Test
    void testAddTileWithValidInput() {
        // Create valid input data
        MahjongTile tile = MahjongTile.ONE_MAN;
        ITileSelectorComponentState.SelectorType selectorType = ITileSelectorComponentState.SelectorType.NONE;
        AddTileInputData inputData = new AddTileInputData(tile, false, selectorType);

        // Execute interactor
        interactor.execute(inputData);

        // Assert that output data has been recorded
        assertEquals(1, outputBoundary.addedTiles.size());
        assertTrue(outputBoundary.addedTiles.contains(tile));
    }

    @Test
    void testAddTileWithAkaTile() {
        // Create input data with an aka (red) tile
        MahjongTile tile = MahjongTile.RED_FIVE_MAN;
        ITileSelectorComponentState.SelectorType selectorType = ITileSelectorComponentState.SelectorType.PON;
        AddTileInputData inputData = new AddTileInputData(tile, true, selectorType);

        // Execute interactor
        interactor.execute(inputData);

        // Assert that aka tile has been recorded
        assertEquals(1, outputBoundary.addedTiles.size());
        assertTrue(outputBoundary.addedTiles.contains(tile));
    }

    @Test
    void testAddTileWithInvalidInput() {
        // Testing case of invalid input
        MahjongTile tile = null;
        ITileSelectorComponentState.SelectorType selectorType = ITileSelectorComponentState.SelectorType.NONE;

        Exception exception = assertThrows(NullPointerException.class, () -> {
            AddTileInputData inputData = new AddTileInputData(tile, false, selectorType);
            interactor.execute(inputData);
        });

        assertNotNull(exception);
    }

    @Test
    void testInteractorHandlesMultipleTiles() {
        MahjongTile tile1 = MahjongTile.ONE_MAN;
        MahjongTile tile2 = MahjongTile.TWO_MAN;

        AddTileInputData inputData1 = new AddTileInputData(tile1, false, ITileSelectorComponentState.SelectorType.NONE);
        AddTileInputData inputData2 = new AddTileInputData(tile2, false, ITileSelectorComponentState.SelectorType.NONE);

        // Execute interactor for both tiles
        interactor.execute(inputData1);
        interactor.execute(inputData2);

        // Assert that both tiles are recorded
        assertEquals(2, outputBoundary.addedTiles.size());
        assertTrue(outputBoundary.addedTiles.contains(tile1));
        assertTrue(outputBoundary.addedTiles.contains(tile2));
    }

    // Test implementation of AddTileOutputBoundary
    private static class TestAddTileOutputBoundary implements AddTileOutputBoundary {
        List<MahjongTile> addedTiles = new ArrayList<>();

        @Override
        public void present(AddTileOutputData outputData) {
            addedTiles.addAll(outputData.getAddedTile());
        }
    }
}