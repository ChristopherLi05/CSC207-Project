package use_case.addtile;

import view.component.ITileSelectorMaster;
import view.component.MahjongTileInputButton;

public class AddTileInteractor implements AddTileInputBoundary {

    @Override
    public void execute(AddTileInputData inputData) {
        // Create tile
        MahjongTileInputButton newTiles = addTiles(inputData);
    }

    private MahjongTileInputButton addTiles(AddTileInputData inputData) {
        if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.NONE) {
            addClosedTile(inputData.getTileClicked());
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.CHII) {
            addChii(inputData.getTileClicked());
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.PON) {
            addPon(inputData.getTileClicked());
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.CLOSED_KAN) {
            addClosedKan(inputData.getTileClicked());
        } else if (inputData.getSelectorType() == ITileSelectorMaster.SelectorType.OPEN_KAN) {
            addOpenKan(inputData.getTileClicked());
        }
    }
}
