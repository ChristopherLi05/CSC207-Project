package interface_adapter.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.calculator.CalculatorViewState;
import use_case.addTile.AddTileOutputBoundary;
import use_case.addTile.AddTileOutputData;

/**
 * Presenter class for handling the output of the Add Tile use case.
 * This class updates the CalculatorViewState with the new tile data and manages
 * the state of the hand being calculated.
 */
public class AddTilePresenter implements AddTileOutputBoundary {

    /**
     * The view state representing the current state of the calculator, used to update the tile data.
     */
    private final CalculatorViewState calculatorViewState;

    /**
     * Constructs an AddTilePresenter with the given CalculatorViewState.
     *
     * @param calculatorViewState the view state to be updated with the new tile information
     */
    public AddTilePresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }

    /**
     * Updates the CalculatorViewState based on the output data provided by the use case.
     * Ensures the number of tiles does not exceed the limit of 14 and updates open/closed groups,
     * closed tiles, and the winning tile as necessary.
     *
     * @param outputData the output data containing information about the tiles and groups to add
     */
    @Override
    public void present(AddTileOutputData outputData) {
        // Prevent adding tiles if the total number exceeds 14
        if (calculatorViewState.getState().getTileNumber() + getNumTiles(outputData) > 14) return;

        // Add open groups to the state
        for (MahjongGroup group : outputData.getAddedOpenGroup()) {
            calculatorViewState.getState().addOpenGroup(group);
        }

        // Add closed groups to the state
        for (MahjongGroup group : outputData.getAddedClosedGroup()) {
            calculatorViewState.getState().addClosedGroup(group);
        }

        // Add individual tiles or set the winning tile
        for (MahjongTile tile : outputData.getAddedTile()) {
            if (calculatorViewState.getState().getTileNumber() == 13) {
                calculatorViewState.getState().setWinningTile(tile);
                break;
            } else {
                calculatorViewState.getState().addClosedTile(tile);
            }
        }

        // Automatically set the winning tile if 14 tiles are present but none is set
        if (calculatorViewState.getState().getTileNumber() == 14 && calculatorViewState.getState().getWinningTile() == null) {
            calculatorViewState.getState().setWinningTile();
        }

        // Notify the view state that changes have occurred
        calculatorViewState.firePropertyChanged();
    }

    /**
     * Calculates the total number of tiles to be added based on the output data.
     * Includes tiles from closed/open groups and individual tiles.
     *
     * @param outputData the output data containing the tiles and groups to be added
     * @return the total number of tiles being added
     */
    private int getNumTiles(AddTileOutputData outputData) {
        return outputData.getAddedTile().size()
                + 3 * outputData.getAddedClosedGroup().size()
                + 3 * outputData.getAddedOpenGroup().size();
    }
}
