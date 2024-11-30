package use_case.addTile;

import entity.calculator.mahjong.MahjongTile;
import view.component.TileSelectorComponentState;

public class AddTileInputData {
    private final MahjongTile tile;
    private final boolean isAka;
    private final TileSelectorComponentState.SelectorType selectorType;

    /**
     * Constructs AddTileInputData object with given a tile and other attributes.
     * @param tile the tile to be added
     * @param isAka whether the tile is red (aka)
     * @param selectorType the type of tile selection being performed
     */
    public AddTileInputData(MahjongTile tile, boolean isAka, TileSelectorComponentState.SelectorType selectorType) {
        this.tile = tile;
        this.isAka = isAka;
        this.selectorType = selectorType;
    }

    /**
     * Gets selector type for the tile operation.
     * @return the selector type for the tile operation
     */
    public TileSelectorComponentState.SelectorType getSelectorType() {
        return selectorType;
    }

    /**
     * Retrieves tile associated with input data.
     * @return the tile in the input data.
     */
    public MahjongTile getTile() {
        return tile;
    }

    /**
     * Checks whether the tile is an aka (red) tile.
     * @return True if and only if the tile is aka (red)
     */
    public boolean isAka() {
        return isAka;
    }
}
