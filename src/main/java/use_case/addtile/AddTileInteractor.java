package use_case.addtile;

import entity.calculator.mahjong.MahjongGroup;
import view.component.ITileSelectorMaster;
import view.component.MahjongTileInputButton;

public class AddTileInteractor implements AddTileInputBoundary {

    @Override
    public void execute(AddTileInputData inputData) {
        // Create tile
        MahjongGroup newTiles = addTiles(inputData);
    }

    private MahjongGroup addTiles(AddTileInputData inputData) {
        if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.NONE) {
            addClosedTile(inputData);
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.CHII) {
            addChii(inputData);
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.PON) {
            addPon(inputData);
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.CLOSED_KAN) {
            addClosedKan(inputData);
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.OPEN_KAN) {
            addOpenKan(inputData);
        }
    }

    private void addClosedTile(AddTileInputData inputData) {
    }

    private void addChii(AddTileInputData inputData) {
    }

    private void addPon(AddTileInputData inputData) {
    }

    private void addClosedKan(AddTileInputData inputData) {
    }

    private void addOpenKan(AddTileInputData inputData) {
    }

}
