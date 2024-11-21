package interface_adapter.addTile;

import use_case.addTile.AddTileInputBoundary;
import use_case.addTile.AddTileInputData;

public class AddTileController {
    private final AddTileInputBoundary addTileInput;
    private final AddTileViewState addTileViewState;


    public AddTileController(AddTileInputBoundary addTileInput, AddTileViewState addTileViewState) {
        this.addTileInput = addTileInput;
        this.addTileViewState = addTileViewState;
    }
}
