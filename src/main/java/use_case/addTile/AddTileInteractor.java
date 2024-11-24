package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorComponentState;

public class AddTileInteractor implements AddTileInputBoundary {
    AddTileOutputBoundary addTileOutputBoundary;

    public AddTileInteractor(AddTileOutputBoundary addTileOutputBoundary) {
        this.addTileOutputBoundary = addTileOutputBoundary;
    }

    @Override
    public void execute(AddTileInputData inputData) {
        AddTileOutputData data = addTiles(inputData);
        addTileOutputBoundary.present(data);
    }

    private AddTileOutputData addTiles(AddTileInputData inputData) {
        AddTileOutputData data = new AddTileOutputData();

        if (inputData.getSelectorType() == ITileSelectorComponentState.SelectorType.NONE) {
            data.addTile(addClosedTile(inputData.getTile()));
        } else if (inputData.getSelectorType() == ITileSelectorComponentState.SelectorType.CHII) {
            MahjongGroup group = addChii(inputData.getTile(), inputData.isAka());
            if (group != null) {
                data.addOpenGroup(group);
            }
        } else if (inputData.getSelectorType() == ITileSelectorComponentState.SelectorType.PON) {
            data.addOpenGroup(addPon(inputData.getTile(), inputData.isAka()));
        } else if (inputData.getSelectorType() == ITileSelectorComponentState.SelectorType.CLOSED_KAN) {
            data.addClosedGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
        } else if (inputData.getSelectorType() == ITileSelectorComponentState.SelectorType.OPEN_KAN) {
            data.addOpenGroup(createKanGroup(inputData.getTile(), inputData.isAka()));
        }

        return data;
    }

    private MahjongTile addClosedTile(MahjongTile inputData) {
        return inputData;
    }

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
