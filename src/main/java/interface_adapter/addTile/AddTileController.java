package interface_adapter.addTile;

import use_case.addTile.AddTileInputBoundary;
import use_case.addTile.AddTileInputData;
import view.component.ITileSelectorMaster;

public class AddTileController {
    private final AddTileInputBoundary addTileInput;
    private final AddTileViewState addTileViewState;


    public AddTileController(AddTileInputBoundary addTileInput, AddTileViewState addTileViewState) {
        this.addTileInput = addTileInput;
        this.addTileViewState = addTileViewState;
    }

    public void execute(Object tileClicked, boolean isAka, ITileSelectorMaster.SelectorType selectorType) {
        // Create input data
        AddTileInputData inputData = new AddTileInputData(tileClicked, isAka, selectorType);

        // Pass input data
        addTileInput.execute(inputData);
    }
}
