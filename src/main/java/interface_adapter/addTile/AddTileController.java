package interface_adapter.addTile;

import entity.calculator.mahjong.MahjongTile;
import use_case.addTile.AddTileInputBoundary;
import use_case.addTile.AddTileInputData;
import view.component.TileSelectorComponentState;

public class AddTileController {
    private final AddTileInputBoundary addTileInputBoundary;

    public AddTileController(AddTileInputBoundary addTileInputBoundary) {
        this.addTileInputBoundary = addTileInputBoundary;
    }

    public void execute(MahjongTile tileClicked, boolean isAka, TileSelectorComponentState.SelectorType selectorType) {
        // Pass input data
        addTileInputBoundary.execute(new AddTileInputData(tileClicked, isAka, selectorType));
    }
}
