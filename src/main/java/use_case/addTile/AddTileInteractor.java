package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.mahjong.TileGroupFactory;
import view.component.TileSelectorComponentState;

public class AddTileInteractor implements AddTileInputBoundary {
    AddTileOutputBoundary addTileOutputBoundary;
    TileGroupFactory tileGroupFactory;

    /**
     * Constructs AddTileInteractor with specified output boundary.
     * @param addTileOutputBoundary the output boundary for presenting data to the view
     */
    public AddTileInteractor(AddTileOutputBoundary addTileOutputBoundary) {
        this.addTileOutputBoundary = addTileOutputBoundary;
    }

    /**
     * Executes add tile operation with provided input data and pass output data to output boundary.
     * @param inputData the data required to add the tile
     */
    @Override
    public void execute(AddTileInputData inputData) {
        AddTileOutputData data = addTiles(inputData);
        addTileOutputBoundary.present(data);
    }

    /**
     * Processes input data to and creates output data.
     * @param inputData the received input data
     * @return output data containing the added tiles or groups
     */
    AddTileOutputData addTiles(AddTileInputData inputData) {
        AddTileOutputData data = new AddTileOutputData();

        if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.NONE) {
            data.addTile(addClosedTile(inputData.getTile()));
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.CHII) {
            MahjongGroup group = addChii(inputData.getTile(), inputData.isAka());
            if (group != null) {
                data.addOpenGroup(group);
            }
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.PON) {
            data.addOpenGroup(addPon(inputData.getTile(), inputData.isAka()));
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.CLOSED_KAN) {
            data.addClosedGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.OPEN_KAN) {
            data.addOpenGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
        }

        return data;
    }
}
