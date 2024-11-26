package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorComponentState;

/**
 * The {@code AddTileInteractor} class handles the logic for adding a Mahjong tile to the player's hand.
 * It coordinates the tile addition based on the type of selector (e.g., Chii, Pon, Kan, etc.) and delegates
 * the presentation of the results to the {@link AddTileOutputBoundary}.
 */
public class AddTileInteractor implements AddTileInputBoundary {
    private final AddTileOutputBoundary addTileOutputBoundary;

    /**
     * Constructs an {@code AddTileInteractor} with the given {@link AddTileOutputBoundary} for
     * presenting the result of the tile addition.
     *
     * @param addTileOutputBoundary the output boundary that handles presenting the results
     */
    public AddTileInteractor(AddTileOutputBoundary addTileOutputBoundary) {
        this.addTileOutputBoundary = addTileOutputBoundary;
    }

    /**
     * Executes the tile addition process based on the provided {@code AddTileInputData}.
     * It determines the type of tile addition (closed, open, Chii, Pon, or Kan)
     * and delegates the presentation of the result to the output boundary.
     *
     * @param inputData the input data containing the tile to add and the selector type
     */
    @Override
    public void execute(AddTileInputData inputData) {
        AddTileOutputData data = addTiles(inputData);
        addTileOutputBoundary.present(data);
    }

    /**
     * Determines the appropriate action for adding the tile based on the selector type
     * and returns the corresponding output data.
     *
     * @param inputData the input data containing the tile and selector type
     * @return the {@link AddTileOutputData} that contains the result of the tile addition
     */
    private AddTileOutputData addTiles(AddTileInputData inputData) {
        AddTileOutputData data = new AddTileOutputData();

        switch (inputData.getSelectorType()) {
            case NONE:
                data.addTile(addClosedTile(inputData.getTile()));
                break;
            case CHII:
                MahjongGroup chiiGroup = addChii(inputData.getTile(), inputData.isAka());
                if (chiiGroup != null) {
                    data.addOpenGroup(chiiGroup);
                }
                break;
            case PON:
                data.addOpenGroup(addPon(inputData.getTile(), inputData.isAka()));
                break;
            case CLOSED_KAN:
            case OPEN_KAN:
                data.addClosedGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
                break;
        }

        return data;
    }

    /**
     * Adds a closed tile to the player's hand.
     *
     * @param tile the Mahjong tile to add
     * @return the added tile
     */
    private MahjongTile addClosedTile(MahjongTile tile) {
        return tile;
    }

    /**
     * Creates and returns a Chii group (a sequence of 3 tiles) for the given tile.
     * A Chii group consists of tiles with consecutive values of the same suit.
     *
     * @param tile the tile to form a Chii group
     * @param isAka whether the group can include an aka (red) tile
     * @return the MahjongGroup representing the Chii group, or {@code null} if the tile value is invalid
     */
    private MahjongGroup addChii(MahjongTile tile, boolean isAka) {
        if (tile.getValue() < 1 || tile.getValue() > 7) {
            return null;
        }

        MahjongTile[] tiles = new MahjongTile[3];
        tiles[0] = tile;

        for (int i = 1; i < 3; i++) {
            if (i + tile.getValue() == 5 && isAka) {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), true);
            } else {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), false);
            }
        }

        return new MahjongGroup(tiles);
    }

    /**
     * Creates and returns a Pon group (a triplet of 3 identical tiles) for the given tile.
     * If the tile is an aka (red tile), a normal tile is used in the group.
     *
     * @param tile the tile to form a Pon group
     * @param isAka whether the group should include an aka (red) tile
     * @return the MahjongGroup representing the Pon group
     */
    private MahjongGroup addPon(MahjongTile tile, boolean isAka) {
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && isAka) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile);
        }

        return group;
    }

    /**
     * Creates and returns a Kan group (a quadruple of 4 identical tiles) for the given tile.
     * If the tile is an aka (red tile), a normal tile is used in the group.
     *
     * @param tile the tile to form a Kan group
     * @param isAka whether the group should include an aka (red) tile
     * @return the MahjongGroup representing the Kan group
     */
    private MahjongGroup createKanGroup(MahjongTile tile, boolean isAka) {
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && isAka) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile, tile);
        }

        return group;
    }
}
