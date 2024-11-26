package use_case.addTile;

/**
 * The {@code AddTileOutputBoundary} interface defines the contract for presenting the result
 * of adding a tile to a Mahjong hand.
 *
 * Implementations of this interface are responsible for displaying or processing the results
 * of the tile addition operation based on the {@link AddTileOutputData}.
 */
public interface AddTileOutputBoundary {

    /**
     * Presents the result of adding a tile, including any updates to the player's hand or groups.
     *
     * @param outputData the output data containing the results of the tile addition
     */
    void present(AddTileOutputData outputData);
}
