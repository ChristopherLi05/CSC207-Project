package interface_adapter.addtile;

import entity.calculator.mahjong.MahjongTile;
import use_case.addtile.AddTileInputBoundary;
import use_case.addtile.AddTileInputData;
import view.component.ITileSelectorMaster;

public class AddTileController {
    private final AddTileInputBoundary addTileInputBoundary;


    public AddTileController(AddTileInputBoundary addTileInputBoundary, AddTileViewState addTileViewState) {
        this.addTileInputBoundary = addTileInputBoundary;
    }

    public void execute(MahjongTile tileClicked, boolean isAka, ITileSelectorMaster.SelectorType selectorType) {
        // Create input data
        AddTileInputData inputData = new AddTileInputData(tileClicked, isAka, selectorType);

        // Pass input data
        addTileInputBoundary.execute(inputData);
    }
}
