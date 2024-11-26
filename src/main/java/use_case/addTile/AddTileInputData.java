package use_case.addTile;

import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorComponentState;

/**
 * Represents the input data required to add a tile to a player's hand.
 */
public class AddTileInputData {
    private final MahjongTile tile;
    private final boolean isAka;
    private final ITileSelectorComponentState.SelectorType selectorType;

    /**
     * Constructs a new `AddTileInputData` instance.
     *
     * @param tile        the Mahjong tile to be added
     * @param isAka        a boolean indicating if the tile is an aka (special red tile)
     * @param selectorType the type of selector used to choose the tile
     */
    public AddTileInputData(MahjongTile tile, boolean isAka, ITileSelectorComponentState.SelectorType selectorType) {
        this.tile = tile;
        this.isAka = isAka;
        this.selectorType = selectorType;
    }

    /**
     * Gets the selector type used to choose the tile.
     *
     * @return the selector type
     */
    public ITileSelectorComponentState.SelectorType getSelectorType() {
        return selectorType;
    }

    /**
     * Gets the Mahjong tile to be added.
     *
     * @return the tile
     */
    public MahjongTile getTile() {
        return tile;
    }

    /**
     * Checks if the tile is an aka (special red tile).
     *
     * @return true if the tile is an aka, false otherwise
     */
    public boolean isAka() {
        return isAka;
    }
}
