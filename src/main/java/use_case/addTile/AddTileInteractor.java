package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.TileSelectorComponentState;

public class AddTileInteractor implements AddTileInputBoundary {
    AddTileOutputBoundary addTileOutputBoundary;

    public AddTileInteractor(AddTileOutputBoundary addTileOutputBoundary) {
        this.addTileOutputBoundary = addTileOutputBoundary;
    }

    @Override
    public void execute(AddTileInputData inputData) {
        // Create tiles
        AddTileOutputBoundary newTiles = addTiles(inputData);

        // Pass tiles to output boundary
        addTileOutputBoundary.present(new AddTileOutputData(newTiles));
    }

    private AddTileOutputBoundary addTiles(AddTileInputData inputData) {
        if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.NONE) {
            return addClosedTile(inputData);
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.CHII) {
            return addChii(inputData);
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.PON) {
            return addPon(inputData);
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.CLOSED_KAN) {
            return addClosedKan(inputData);
        } else if (inputData.getSelectorType() == TileSelectorComponentState.SelectorType.OPEN_KAN) {
            return addOpenKan(inputData);
        }
        return null;
    }

    private AddTileOutputBoundary addClosedTile(AddTileInputData inputData) {
        return inputData.getTile();
    }

    private AddTileOutputBoundary addChii(AddTileInputData inputData) {
        MahjongTile tile = inputData.getTile();
        if (tile.getValue() < 1 || tile.getValue() > 7) {return null;}

        MahjongTile[] tiles = new MahjongTile[3];

        tiles[0] = tile;

        for (int i = 1; i < 3; i++) {
            if (i + tile.getValue() == 5 && inputData.isAka()) {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), true);
            } else {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), false);
            }
        }

        return new MahjongGroup(tiles);
    }

    private AddTileOutputBoundary addPon(AddTileInputData inputData) {
        MahjongTile tile = inputData.getTile();
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && inputData.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile);
        }

        return group;
    }

    private AddTileOutputBoundary addClosedKan(AddTileInputData inputData) {
        // Not sure how to do open kan vs closed kan
        return createKanGroup(inputData);
    }

    private AddTileOutputBoundary addOpenKan(AddTileInputData inputData) {
        // Not sure how to do open kan vs closed kan
        return createKanGroup(inputData);
    }

    private MahjongGroup createKanGroup(AddTileInputData inputData) {
        MahjongTile tile = inputData.getTile();
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && inputData.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile, tile);
        }
        return group;
    }
}
