package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.TileSelectorComponentState;

public class AddTileInteractor implements AddTileInputBoundary {
    AddTileOutputBoundary addTileOutputBoundary;

    /**
     * Constructs AddTileInteractor with specified output boundary.
     * @param addTileOutputBoundary the output boundary for presenting data to the view
     */
    public AddTileInteractor(AddTileOutputBoundary addTileOutputBoundary) {
        this.addTileOutputBoundary = addTileOutputBoundary;
    }

    /**
     * Executes add tile operation with provided input data and pass output data to output boundary.
     * @param inputData the data required to add the tile
     */
    @Override
    public void execute(AddTileInputData inputData) {
        AddTileOutputData data = addTiles(inputData);
        addTileOutputBoundary.present(data);
    }

    /**
     * Processes input data to and creates output data.
     * @param inputData the received input data
     * @return output data containing the added tiles or groups
     */
    AddTileOutputData addTiles(AddTileInputData inputData) {
        AddTileOutputData data = new AddTileOutputData();

        if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.NONE) {
            data.addTile(addClosedTile(inputData.getTile()));
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.CHII) {
            MahjongGroup group = addChii(inputData.getTile(), inputData.isAka());
            if (group != null) {
                data.addOpenGroup(group);
            }
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.PON) {
            data.addOpenGroup(addPon(inputData.getTile(), inputData.isAka()));
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.CLOSED_KAN) {
            data.addClosedGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.OPEN_KAN) {
            data.addOpenGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
        }

        return data;
    }

    /**
     * Adds closed tile based on input data.
     * @param inputData the data needed to create the closed tile
     * @return the closed tile
     */
    private MahjongTile addClosedTile(MahjongTile inputData) {
        return inputData;
    }

    /**
     * Creates Chii group given a tile and whether or not it is an aka.
     * @param tile  the given tile
     * @param isAka whether the given tile is aka (red)
     * @return the Chii group, or null if the group cannot be formed
     */
    MahjongGroup addChii(MahjongTile tile, boolean isAka) {
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
     * Creates Pon group given a tile and whether or not it is an aka.
     * @param tile  the given tile
     * @param isAka whether the given tile is aka (red)
     * @return the Pon group
     */
    MahjongGroup addPon(MahjongTile tile, boolean isAka) {
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
     * Creates Kan group given a tile and whether or not it is an aka.
     * @param tile  the given tile
     * @param isAka whether the given tile is aka (red)
     * @return the Kan group
     */
    MahjongGroup createKanGroup(MahjongTile tile, boolean isAka) {
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
