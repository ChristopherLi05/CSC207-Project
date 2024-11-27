package interface_adapter.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.calculator.CalculatorViewState;
import use_case.addTile.AddTileOutputBoundary;
import use_case.addTile.AddTileOutputData;

public class AddTilePresenter implements AddTileOutputBoundary {
    private final CalculatorViewState calculatorViewState;

    /**
     * Constructs AddTilePresenter with specified calculator view state.
     * @param calculatorViewState the concrete observer that observes calculatorState.
     */
    public AddTilePresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }

    /**
     * Presents output data from add tile use case to view.
     * @param outputData the data to be displayed in the view
     */
    @Override
    public void present(AddTileOutputData outputData) {
        if (calculatorViewState.getState().getTileNumber() + getNumTiles(outputData) > 14) return;

        for (MahjongGroup group : outputData.getAddedOpenGroup()) {
            calculatorViewState.getState().addOpenGroup(group);
        }

        for (MahjongGroup group : outputData.getAddedClosedGroup()) {
            calculatorViewState.getState().addClosedGroup(group);
        }

        for (MahjongTile tile : outputData.getAddedTile()) {
            if (calculatorViewState.getState().getTileNumber() == 13) {
                calculatorViewState.getState().setWinningTile(tile);
                break;
            } else {
                calculatorViewState.getState().addClosedTile(tile);
            }
        }

        if (calculatorViewState.getState().getTileNumber() == 14 && calculatorViewState.getState().getWinningTile() == null) {
            calculatorViewState.getState().setWinningTile();
        }
        calculatorViewState.firePropertyChanged();
    }

    /**
     * Calculates the total number of tiles represented in the output data.
     * @param outputData the output data containing the added tiles and groups
     * @return the total number of tiles, including individual tiles and tiles in groups
     */
    private int getNumTiles(AddTileOutputData outputData) {
        return outputData.getAddedTile().size() + 3 * outputData.getAddedClosedGroup().size() + 3 *
                outputData.getAddedOpenGroup().size();
    }
}
