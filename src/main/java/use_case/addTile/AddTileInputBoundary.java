package use_case.addTile;

public interface AddTileInputBoundary {
    /**
     * Executes add tile operation with provided input data.
     * @param inputData the data required to add the tile
     */
    void execute(AddTileInputData inputData);
}
