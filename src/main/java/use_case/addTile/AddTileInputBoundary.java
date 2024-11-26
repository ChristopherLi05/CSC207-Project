package use_case.addTile;

/**
 * The {@code AddTileInputBoundary} interface defines the contract for the use case that handles
 * adding a Mahjong tile to the player's hand. The implementer of this interface should contain the
 * business logic for adding tiles, including validation and updating the game state.
 */
public interface AddTileInputBoundary {

    /**
     * Executes the use case for adding a tile to the player's hand.
     *
     * This method receives the input data containing the tile information and processes it. The exact
     * behavior depends on the specific implementation, but it generally involves modifying the
     * player's tile collection, updating game status, and potentially triggering events such as
     * win conditions.
     *
     * @param inputData the data required to add the tile, such as the tile itself, whether it's an aka
     *                  (special red tile), and the type of selector used to choose the tile
     */
    void execute(AddTileInputData inputData);
}
