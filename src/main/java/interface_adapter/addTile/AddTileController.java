package interface_adapter.addTile;

import use_case.addTile.AddTileInputBoundary;
import use_case.addTile.AddTileInputData;
import view.component.ITileSelectorMaster;

public class AddTileController {
    private final AddTileInputBoundary addTileInputBoundary;


    public AddTileController(AddTileInputBoundary addTileInputBoundary, AddTileViewState addTileViewState) {
        this.addTileInputBoundary = addTileInputBoundary;
    }

    public void execute(Object tileClicked, boolean isAka, ITileSelectorMaster.SelectorType selectorType) {
        // Create input data
        AddTileInputData inputData = new AddTileInputData(tileClicked, isAka, selectorType);

        // Pass input data
        addTileInputBoundary.execute(inputData);
    }
}
