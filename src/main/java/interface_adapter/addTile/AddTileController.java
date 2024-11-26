package interface_adapter.addTile;

import entity.calculator.mahjong.MahjongTile;
import use_case.addTile.AddTileInputBoundary;
import use_case.addTile.AddTileInputData;
import view.component.ITileSelectorComponentState;

/**
 * Controller class for handling the addition of a Mahjong tile.
 * It acts as a mediator between the view and the use case layer,
 * passing input data from the user interaction to the interactor.
 */
public class AddTileController {

    /**
     * The input boundary interface for adding a tile, used to decouple the controller
     * from the implementation details of the use case.
     */
    private final AddTileInputBoundary addTileInputBoundary;

    /**
     * Constructs an AddTileController with the given input boundary.
     *
     * @param addTileInputBoundary the input boundary that processes the add tile use case
     */
    public AddTileController(AddTileInputBoundary addTileInputBoundary) {
        this.addTileInputBoundary = addTileInputBoundary;
    }

    /**
     * Executes the add tile use case by passing input data to the input boundary.
     *
     * @param tileClicked  the Mahjong tile that was clicked by the user
     * @param isAka        whether the tile is an aka (red dora) tile
     * @param selectorType the type of tile selector component that initiated the action
     */
    public void execute(MahjongTile tileClicked, boolean isAka, ITileSelectorComponentState.SelectorType selectorType) {
        addTileInputBoundary.execute(new AddTileInputData(tileClicked, isAka, selectorType));
    }
}
