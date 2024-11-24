package interface_adapter.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.calculator.CalculatorViewState;
import use_case.addTile.AddTileOutputBoundary;
import use_case.addTile.AddTileOutputData;

public class AddTilePresenter implements AddTileOutputBoundary {
    private final CalculatorViewState calculatorViewState;

    public AddTilePresenter(CalculatorViewState calculatorViewState) {
        this.calculatorViewState = calculatorViewState;
    }

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

    private int getNumTiles(AddTileOutputData outputData) {
        return outputData.getAddedTile().size() + 3 * outputData.getAddedClosedGroup().size() + 3 * outputData.getAddedOpenGroup().size();
    }
}
