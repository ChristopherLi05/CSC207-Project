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
     * Constructs AddTileController with specified input boundary.
     * @param addTileInputBoundary the input boundary for executing the add tile use case
     */
    public AddTileController(AddTileInputBoundary addTileInputBoundary) {
        this.addTileInputBoundary = addTileInputBoundary;
    }

    /**
     * Executes add tile operation based on tile clicked and its attributes.
     * @param tileClicked the tile selected by the user
     * @param isAka whether the tile is aka (red)
     * @param selectorType the type of tile selection (e.g., closed tile, closed group)
     */
    public void execute(MahjongTile tileClicked, boolean isAka, ITileSelectorComponentState.SelectorType selectorType) {
        addTileInputBoundary.execute(new AddTileInputData(tileClicked, isAka, selectorType));
    }
}
